package domain;

import domain.participants.Dealer;
import domain.participants.Participants;
import domain.participants.attributes.bettingCondition.GameResult;
import domain.participants.attributes.hand.GameCondition;
import domain.participants.players.Player;
import java.util.HashMap;
import java.util.Map;

public class Judge {

    private final Map<Player, GameResult> results;

    public Judge() {
        results = new HashMap<>();
    }

    public void judgeAll(final Participants participants) {
        for (Player player : participants.getPlayers()) {
            if (results.containsKey(player)) {
                throw new IllegalArgumentException("중복되는 플레이어가 존재합니다.");
            }
            final GameResult gameResult = judgePlayer(participants.getDealer(), player);
            player.updateGameResult(gameResult);
            results.put(player, gameResult);
        }
    }

    private GameResult judgePlayer(final Dealer dealer, final Player player) {
        final GameCondition dealerCondition = dealer.getGameCondition();
        final GameCondition playerCondition = player.getGameCondition();
        if (dealer.getGameCondition() == GameCondition.BLACKJACK) {
            return judgeWhenDealerBlackjack(playerCondition);
        }
        if (dealerCondition == GameCondition.BUST) {
            return judgeWhenDealerBust(playerCondition);
        }
        return judgeWhenDealerStand(dealer, player);
    }

    private GameResult judgeWhenDealerBust(final GameCondition condition) {
        if (condition == GameCondition.BUST) {
            return GameResult.DRAW;
        }
        return GameResult.WIN;
    }

    private GameResult judgeWhenDealerBlackjack(final GameCondition condition) {
        if (condition == GameCondition.BLACKJACK) {
            return GameResult.DRAW;
        }
        return GameResult.LOSE;
    }

    private GameResult judgeWhenDealerStand(
        final Dealer dealer,
        final Player player
    ) {
        if (player.getGameCondition() == GameCondition.BLACKJACK) {
            return GameResult.WIN;
        }
        if (player.getGameCondition() == GameCondition.BUST || dealer.getScore() > player.getScore()) {
            return GameResult.LOSE;
        }
        if (dealer.getScore() == player.getScore()) {
            return GameResult.DRAW;
        }
        return GameResult.WIN;
    }

    public long getDealerWinCount() {
        return results.values().stream()
            .filter(gameResult -> gameResult == GameResult.LOSE)
            .count();
    }

    public long getDealerLoseCount() {
        return results.values().stream()
            .filter(gameResult -> gameResult == GameResult.WIN)
            .count();
    }

    public long getDealerDrawCount() {
        return results.values().stream()
            .filter(gameResult -> gameResult == GameResult.DRAW)
            .count();
    }

    public GameResult getGameResultByPlayer(final Player player) {
        return results.get(player);
    }
}
