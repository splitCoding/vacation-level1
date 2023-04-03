package domain.participants;

import domain.deck.card.Card;
import java.util.List;

public class Player {

    private final Hand hand;

    public Player() {
        hand = Hand.empty();
    }

    public void drawCard(final Card card) {
        hand.addCard(card);
    }

    public List<Card> getHand() {
        return hand.getCards();
    }

    public int getScore() {
        return hand.getScore();
    }
}
