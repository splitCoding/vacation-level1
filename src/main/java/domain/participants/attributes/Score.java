package domain.participants.attributes;

import domain.deck.card.Card;
import java.util.List;

public class Score {

    private static final int BLACKJACK_SCORE = 21;
    private static final int ACE_BONUS_SCORE = 10;
    private final int score;
    private final GameCondition gameCondition;

    private Score(final int score, final GameCondition gameCondition) {
        this.score = score;
        this.gameCondition = gameCondition;
    }

    public static Score of(final List<Card> cards) {
        final int score = calculateScore(cards);
        final GameCondition gameCondition = GameCondition.find(score);
        return new Score(score, gameCondition);
    }

    private static int calculateScore(final List<Card> cards) {
        int score = 0;
        for (Card card : cards) {
            score += card.getScore();
        }
        if (containsAce(cards) && score <= BLACKJACK_SCORE - ACE_BONUS_SCORE) {
            return score + ACE_BONUS_SCORE;
        }
        return score;
    }

    private static boolean containsAce(final List<Card> cards) {
        return cards.stream()
            .anyMatch(Card::isAce);
    }

    public int getScore() {
        return score;
    }

    public GameCondition getGameCondition() {
        return gameCondition;
    }
}
