package domain.participants.attributes;

import domain.deck.card.Card;
import java.util.List;

public class Score {

    private static final int BLACKJACK_SCORE = 21;
    private static final int ACE_BONUS_SCORE = 10;
    private final int score;
    private final PlayerStatus playerStatus;

    private Score(final int score, final PlayerStatus playerStatus) {
        this.score = score;
        this.playerStatus = playerStatus;
    }

    public static Score of(final List<Card> cards) {
        final int score = calculateScore(cards);
        final PlayerStatus playerStatus = PlayerStatus.find(score);
        return new Score(score, playerStatus);
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

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }
}
