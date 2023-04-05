package domain.participants;

import domain.deck.card.Card;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DealerTest {

    @DisplayName("딜러가 지급 받은 카드를 반환한다.")
    @Test
    void getHand() {
        Dealer dealer = new Dealer();
        dealer.drawCard(Card.CLOVER_ACE);
        Assertions.assertThat(dealer.getHand()).containsExactly(Card.CLOVER_ACE);
    }

    @DisplayName("딜러가 자신의 점수를 반환한다.")
    @Test
    void getScore() {
        Dealer dealer = new Dealer();
        dealer.drawCard(Card.CLOVER_ACE);
        Assertions.assertThat(dealer.getHand()).containsExactly(Card.CLOVER_ACE);
        Assertions.assertThat(dealer.getScore()).isEqualTo(11);
    }

    @DisplayName("딜러가 카드를 더 지급받을 수 있는 상태인지를 반환한다.(가능한 상태)")
    @Test
    void canGetMoreCard() {
        Dealer dealer = new Dealer();
        dealer.drawCard(Card.CLOVER_ACE);
        Assertions.assertThat(dealer.canGetMoreCard()).isTrue();
    }

    @DisplayName("딜러가 카드를 더 지급받을 수 있는 상태인지를 반환한다.(불가능한 상태)")
    @Test
    void canNotGetMoreCard() {
        Dealer dealer = new Dealer();
        dealer.drawCard(Card.CLOVER_TEN);
        dealer.drawCard(Card.SPADE_SEVEN);
        Assertions.assertThat(dealer.canGetMoreCard()).isFalse();
    }

    @DisplayName("딜러가 카드가 2명이 없을 때 시작 카드를 반환할 경우 오류를 던진다.")
    @Test
    void showInitialCardsLessThanTwo() {
        Dealer dealer = new Dealer();
        dealer.drawCard(Card.CLOVER_ACE);
        Assertions.assertThat(dealer.getHand()).containsExactly(Card.CLOVER_ACE);
        Assertions.assertThatThrownBy(dealer::showInitialCards)
            .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("딜러가 시작 카드를 반환한다.")
    @Test
    void showInitialCardsMoreThanOne() {
        Dealer dealer = new Dealer();
        dealer.drawCard(Card.CLOVER_ACE);
        dealer.drawCard(Card.CLOVER_FIVE);
        Assertions.assertThat(dealer.showInitialCards()).containsExactly(Card.CLOVER_ACE);
    }
}
