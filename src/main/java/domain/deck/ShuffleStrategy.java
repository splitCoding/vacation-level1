package domain.deck;

import domain.deck.card.Card;
import java.util.List;

public interface ShuffleStrategy {

    void shuffle(final List<Card> card);
}
