package domain;

import domain.deck.card.Card;
import domain.participants.Dealer;
import domain.participants.Participants;
import domain.participants.attributes.Name;
import domain.participants.attributes.bettingCondition.BettingAmount;
import domain.participants.attributes.bettingCondition.GameResult;
import domain.participants.players.Player;
import domain.participants.players.Players;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgeTest {

    private Participants participants;

    @BeforeEach
    void beforeEach() {
        final Name name = new Name("split");
        final Players players = Players.of(
            List.of(name),
            List.of(new Player(BettingAmount.of("1000")))
        );
        participants = new Participants(players);
    }

    @DisplayName("참가자들의 승패를 판단한다. (블랙잭으로 비겼을 때)")
    @Test
    void judgeAllDrawWithBlackjack() {
        final Judge judge = new Judge();

        final Dealer dealer = participants.getDealer();
        dealer.drawCard(Card.CLOVER_ACE);
        dealer.drawCard(Card.CLOVER_KING);

        final Player player = participants.getCurrentPlayer();
        player.drawCard(Card.HEART_ACE);
        player.drawCard(Card.HEART_TEN);

        judge.judgeAll(participants);
        Assertions.assertThat(judge.getGameResultByPlayer(player)).isEqualTo(GameResult.DRAW);
        Assertions.assertThat(judge.getDealerDrawCount()).isEqualTo(1);
    }

    @DisplayName("참가자들의 승패를 판단한다. (버스트로 비겼을 때)")
    @Test
    void judgeAllDrawWithBust() {
        final Judge judge = new Judge();

        final Dealer dealer = participants.getDealer();
        dealer.drawCard(Card.CLOVER_TWO);
        dealer.drawCard(Card.CLOVER_KING);
        dealer.drawCard(Card.CLOVER_QUEEN);

        final Player player = participants.getCurrentPlayer();
        player.drawCard(Card.HEART_TEN);
        player.drawCard(Card.HEART_JACK);
        player.drawCard(Card.HEART_THREE);

        judge.judgeAll(participants);
        Assertions.assertThat(judge.getGameResultByPlayer(player)).isEqualTo(GameResult.DRAW);
        Assertions.assertThat(judge.getDealerDrawCount()).isEqualTo(1);
    }

    @DisplayName("참가자들의 승패를 판단한다. (스탠드로 비겼을 때)")
    @Test
    void judgeAllDrawWithStand() {
        final Judge judge = new Judge();

        final Dealer dealer = participants.getDealer();
        dealer.drawCard(Card.CLOVER_FIVE);
        dealer.drawCard(Card.CLOVER_KING);

        final Player player = participants.getCurrentPlayer();
        player.drawCard(Card.HEART_FIVE);
        player.drawCard(Card.HEART_TEN);

        judge.judgeAll(participants);
        Assertions.assertThat(judge.getGameResultByPlayer(player)).isEqualTo(GameResult.DRAW);
        Assertions.assertThat(judge.getDealerDrawCount()).isEqualTo(1);
    }

    @DisplayName("참가자들의 승패를 판단한다. (버스트로 졋을 때)")
    @Test
    void judgeAllPlayerLoseWithBust() {
        final Judge judge = new Judge();

        final Dealer dealer = participants.getDealer();
        dealer.drawCard(Card.CLOVER_ACE);
        dealer.drawCard(Card.CLOVER_KING);

        final Player player = participants.getCurrentPlayer();
        player.drawCard(Card.HEART_QUEEN);
        player.drawCard(Card.HEART_FIVE);
        player.drawCard(Card.HEART_NINE);

        judge.judgeAll(participants);
        Assertions.assertThat(judge.getGameResultByPlayer(player)).isEqualTo(GameResult.LOSE);
        Assertions.assertThat(judge.getDealerWinCount()).isEqualTo(1);
    }

    @DisplayName("참가자들의 승패를 판단한다. (스탠드로 졋을 때)")
    @Test
    void judgeAllPlayerLoseWithStand() {
        final Judge judge = new Judge();

        final Dealer dealer = participants.getDealer();
        dealer.drawCard(Card.CLOVER_SEVEN);
        dealer.drawCard(Card.CLOVER_KING);

        final Player player = participants.getCurrentPlayer();
        player.drawCard(Card.HEART_QUEEN);
        player.drawCard(Card.HEART_FIVE);

        judge.judgeAll(participants);
        Assertions.assertThat(judge.getGameResultByPlayer(player)).isEqualTo(GameResult.LOSE);
        Assertions.assertThat(judge.getDealerWinCount()).isEqualTo(1);
    }

    @DisplayName("참가자들의 승패를 판단한다. (블랙잭으로 이겼을 때)")
    @Test
    void judgeAllPlayerWinWithBlackjack() {
        final Judge judge = new Judge();

        final Dealer dealer = participants.getDealer();
        dealer.drawCard(Card.CLOVER_ACE);
        dealer.drawCard(Card.CLOVER_NINE);

        final Player player = participants.getCurrentPlayer();
        player.drawCard(Card.HEART_ACE);
        player.drawCard(Card.HEART_TEN);

        judge.judgeAll(participants);
        Assertions.assertThat(judge.getGameResultByPlayer(player)).isEqualTo(GameResult.WIN);
        Assertions.assertThat(judge.getDealerLoseCount()).isEqualTo(1);
    }

    @DisplayName("참가자들의 승패를 판단한다. (스탠드로 이겼을 때)")
    @Test
    void judgeAllPlayerWinWithStand() {
        final Judge judge = new Judge();

        final Dealer dealer = participants.getDealer();
        dealer.drawCard(Card.CLOVER_ACE);
        dealer.drawCard(Card.CLOVER_SEVEN);

        final Player player = participants.getCurrentPlayer();
        player.drawCard(Card.HEART_ACE);
        player.drawCard(Card.HEART_NINE);

        judge.judgeAll(participants);
        Assertions.assertThat(judge.getGameResultByPlayer(player)).isEqualTo(GameResult.WIN);
        Assertions.assertThat(judge.getDealerLoseCount()).isEqualTo(1);
    }
}
