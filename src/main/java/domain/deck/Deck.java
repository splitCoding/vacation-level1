package domain.deck;

import domain.deck.card.Card;
import java.util.ArrayList;
import java.util.List;

public final class Deck {

    private final List<Card> cards;
    private final ShuffleStrategy shuffleStrategy;

    public Deck(final List<Card> cards, final ShuffleStrategy shuffleStrategy) {
        this.cards = new ArrayList<>(cards);
        this.shuffleStrategy = shuffleStrategy;
    }

    public void shuffle() {
        shuffleStrategy.shuffle(cards);
    }

    public Card draw() {
        if (cards.isEmpty()) {
            throw new RuntimeException("더 이상 남은 카드가 없습니다.");
        }
        return cards.remove(0);
    }
}
