package domain;

import domain.deck.card.Card;
import domain.participants.Dealer;
import domain.participants.Participants;
import domain.participants.attributes.Name;
import domain.participants.attributes.bettingCondition.BettingAmount;
import domain.participants.players.Player;
import domain.participants.players.Players;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlackjackGameTest {

    private final Participants participants = new Participants(
        Players.of(
            List.of(
                new Name("split")
            ),
            List.of(
                new Player(BettingAmount.of("1000"))
            )
        )
    );
    private final BlackjackGame blackjackGame = new BlackjackGame(participants);

    @DisplayName("모든 참가인원에게 시작 카드를 지급한다.")
    @Test
    void ready() {
        blackjackGame.ready();
        final Dealer dealer = participants.getDealer();
        final List<Player> players = participants.getPlayers();
        Assertions.assertThat(dealer.getHand()).hasSize(2);
        players.forEach(player -> Assertions.assertThat(player.getHand()).hasSize(2));
    }

    @DisplayName("게임을 기다리는 참가자가 있는지 반환한다. (있을 떄)")
    @Test
    void isWaitingPlayerExist() {
        Assertions.assertThat(blackjackGame.isNotEnd()).isTrue();
    }

    @DisplayName("게임을 기다리는 참가자가 있는지 반환한다. (없을 떄)")
    @Test
    void isWaitingPlayerNotExist() {
        final Player currentPlayer = blackjackGame.getCurrentPlayer();
        blackjackGame.playTurn(currentPlayer, GetMoreCardCommand.NO);
        Assertions.assertThat(blackjackGame.isNotEnd()).isFalse();
    }

    @DisplayName("게임을 진행할 수 있는 참가자를 반환한다.")
    @Test
    void getCurrentPlayer() {
        final Player currentPlayer = blackjackGame.getCurrentPlayer();
        Assertions.assertThat(currentPlayer.canGetMoreCard()).isTrue();
    }

    @DisplayName("플레이어와 카드 지급 여부를 이용해 플레이어의 턴을 진행한다. ( 카드를 지급 받을 떄 )")
    @Test
    void playTurnGetCard() {
        final Player currentPlayer = blackjackGame.getCurrentPlayer();
        blackjackGame.playTurn(currentPlayer, GetMoreCardCommand.YES);
        Assertions.assertThat(currentPlayer.getHand()).hasSize(1);
    }

    @DisplayName("플레이어와 카드 지급 여부를 이용해 플레이어의 턴을 진행한다. ( 카드를 지급 받지 않을 떄 )")
    @Test
    void playTurnNotGettingCard() {
        final Player currentPlayer = blackjackGame.getCurrentPlayer();
        blackjackGame.playTurn(currentPlayer, GetMoreCardCommand.NO);
        Assertions.assertThat(currentPlayer.getHand()).hasSize(0);
    }

    @DisplayName("딜러에게 카드를 지급한다.")
    @Test
    void dealerPlay() {
        blackjackGame.dealerPlay();
        final List<Card> hand = blackjackGame.getParticipants().getDealer().getHand();
        Assertions.assertThat(hand).hasSize(1);
    }
}
