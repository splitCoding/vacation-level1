package domain.participants;

import domain.deck.card.Card;
import domain.participants.attributes.hand.Hand;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HandTest {

    @DisplayName("아무 카드도 없는 Hand를 반환한다.")
    @Test
    void empty() {
        final Hand empty = Hand.empty();
        Assertions.assertThat(empty.getCards()).hasSize(0);
        Assertions.assertThat(empty.getScore()).isEqualTo(0);
    }

    @DisplayName("아무 카드도 없는 Hand에 카드를 추가한다.")
    @Test
    void addCard() {
        final Hand empty = Hand.empty();
        empty.addCard(Card.SPADE_ACE);
        Assertions.assertThat(empty.getCards()).containsExactly(Card.SPADE_ACE);
        Assertions.assertThat(empty.getScore()).isEqualTo(11);
    }
}
