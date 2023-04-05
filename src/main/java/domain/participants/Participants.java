package domain.participants;

import domain.deck.card.Card;
import domain.participants.attributes.Name;
import domain.participants.players.Player;
import domain.participants.players.Players;
import java.util.List;
import java.util.stream.Collectors;

public final class Participants {

    private static final String DEALER_NAME = "딜러";
    private final Dealer dealer;
    private final Players players;

    public Participants(final Players players) {
        this.dealer = new Dealer();
        this.players = players;
    }

    public String getCurrentPlayerName() {
        final int currentPlayerNameIndex = players.getPlayers().indexOf(getCurrentPlayer());
        return players.getNames()
            .get(currentPlayerNameIndex)
            .getName();
    }

    public Player getCurrentPlayer() {
        return players.getPlayers()
            .stream()
            .filter(Player::canGetMoreCard)
            .findFirst()
            .orElseThrow(() -> new IllegalStateException("모든 플레이어가 게임을 진행했습니다."));
    }

    public boolean isWaitingPlayerExist() {
        return players.getPlayers()
            .stream()
            .anyMatch(Player::canGetMoreCard);
    }

    public String getDealerName() {
        return DEALER_NAME;
    }

    public List<String> getPlayerNames() {
        return players.getNames()
            .stream()
            .map(Name::getName)
            .collect(Collectors.toList());
    }

    public List<Card> getDealerInitializeCards() {
        return dealer.showInitialCards();
    }

    public List<List<Card>> getPlayersInitializeCards() {
        return players.getPlayers()
            .stream()
            .map(Player::showInitialCards)
            .collect(Collectors.toList());
    }

    public List<Card> getDealerHand() {
        return dealer.getHand();
    }

    public List<List<Card>> getPlayersHand() {
        return players.getPlayers()
            .stream()
            .map(Player::getHand)
            .collect(Collectors.toList());
    }

    public int getDealerScore() {
        return dealer.getScore();
    }

    public List<Integer> getPlayersScore() {
        return players.getPlayers()
            .stream()
            .map(Player::getScore)
            .collect(Collectors.toList());
    }

    public Dealer getDealer() {
        return dealer;
    }

    public List<Player> getPlayers() {
        return List.copyOf(players.getPlayers());
    }
}
