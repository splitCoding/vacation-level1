package domain.deck;

import domain.deck.card.Card;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeckTest {

    private final ShuffleStrategy testShuffleStrategy = card -> {
    };

    @DisplayName("카드가 한장이 있을 경우 무조건 해당 카드가 뽑힌다.")
    @Test
    void drawWhenOneCardExist() {
        final Deck deck = new Deck(List.of(Card.SPADE_ACE), testShuffleStrategy);
        deck.shuffle();
        final Card draw = deck.draw();
        Assertions.assertThat(draw).isEqualTo(Card.SPADE_ACE);
    }

    @DisplayName("카드가 없을 때 카드를 뽑으면 오류를 던진다.")
    @Test
    void throwWhenCardEmpty() {
        final Deck deck = new Deck(List.of(), testShuffleStrategy);
        deck.shuffle();
        Assertions.assertThatThrownBy(deck::draw)
            .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("카드가 여러장이 있을 경우 제일 앞에 있는 카드가 뽑힌다.")
    @Test
    void drawWhenAllCardExist() {
        final Deck deck = new Deck(List.of(Card.HEART_FIVE, Card.SPADE_ACE), testShuffleStrategy);
        deck.shuffle();
        final Card draw = deck.draw();
        Assertions.assertThat(draw).isEqualTo(Card.HEART_FIVE);
    }
}
