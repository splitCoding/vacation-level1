package domain.participants.attributes.hand;

import domain.deck.card.Card;
import java.util.ArrayList;
import java.util.List;

public class Hand {

    private final List<Card> cards;
    private Score score;

    public Hand(final List<Card> cards) {
        this.cards = new ArrayList<>(cards);
        this.score = Score.of(cards);
    }

    public static Hand empty() {
        return new Hand(List.of());
    }

    public void addCard(final Card card) {
        cards.add(card);
        updateScore();
    }

    private void updateScore() {
        score = Score.of(cards);
    }

    public List<Card> getCards() {
        return List.copyOf(cards);
    }

    public int getScore() {
        return score.getScore();
    }

    public GameCondition getGameCondition() {
        return score.getGameCondition();
    }
}
