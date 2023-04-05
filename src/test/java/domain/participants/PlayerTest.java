package domain.participants;

import domain.deck.card.Card;
import domain.participants.attributes.bettingCondition.BettingAmount;
import domain.participants.attributes.bettingCondition.GameResult;
import domain.participants.players.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayerTest {

    @DisplayName("플레이어가 지급 받은 카드를 반환한다.")
    @Test
    void getHand() {
        Player player = new Player(BettingAmount.of("1000"));
        player.drawCard(Card.CLOVER_ACE);
        Assertions.assertThat(player.getHand()).containsExactly(Card.CLOVER_ACE);
    }

    @DisplayName("플레이어가 자신의 점수를 반환한다.")
    @Test
    void getScore() {
        Player player = new Player(BettingAmount.of("1000"));
        player.drawCard(Card.CLOVER_ACE);
        Assertions.assertThat(player.getHand()).containsExactly(Card.CLOVER_ACE);
        Assertions.assertThat(player.getScore()).isEqualTo(11);
    }

    @DisplayName("플레이어가 카드를 더 지급받을 수 있는 상태인지를 반환한다. (가능한 상태)")
    @Test
    void canGetMoreCard() {
        Player player = new Player(BettingAmount.of("1000"));
        player.drawCard(Card.CLOVER_ACE);
        Assertions.assertThat(player.canGetMoreCard()).isTrue();
    }

    @DisplayName("플레이어가 카드를 더 지급받을 수 있는 상태인지를 반환한다.(불가능한 상태)")
    @Test
    void canNotGetMoreCard() {
        Player player = new Player(BettingAmount.of("1000"));
        player.drawCard(Card.CLOVER_TEN);
        player.drawCard(Card.SPADE_JACK);
        player.drawCard(Card.HEART_FIVE);
        Assertions.assertThat(player.canGetMoreCard()).isFalse();
    }

    @DisplayName("플레이어가 카드가 2명이 없을 때 시작 카드를 반환할 경우 오류를 던진다..")
    @Test
    void showInitialCardsLessThanTwo() {
        Player player = new Player(BettingAmount.of("1000"));
        player.drawCard(Card.CLOVER_ACE);
        Assertions.assertThat(player.getHand()).containsExactly(Card.CLOVER_ACE);
        Assertions.assertThatThrownBy(player::showInitialCards)
            .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("플레이어가 카드를 지급 받는다.")
    @Test
    void showInitialCardsMoreThanOne() {
        Player player = new Player(BettingAmount.of("1000"));
        player.drawCard(Card.CLOVER_ACE);
        player.drawCard(Card.CLOVER_FIVE);
        Assertions.assertThat(player.showInitialCards()).containsExactly(Card.CLOVER_ACE, Card.CLOVER_FIVE);
    }

    @DisplayName("플레이어의 게임 결과에 따른 수익을 반환한다.")
    @ParameterizedTest(name = "배팅금액이 1000원아고 결과가 {0} 일 때 수익은 {1}이다 ")
    @CsvSource(value = {
        "WIN:1000",
        "DRAW:0",
        "LOSE:-1000"
    }, delimiter = ':')
    void showBenefit(final GameResult gameResult, final int expectBenefit) {
        Player player = new Player(BettingAmount.of("1000"));
        player.updateGameResult(gameResult);
        Assertions.assertThat(player.getBenefit()).isEqualTo(expectBenefit);
    }
}
