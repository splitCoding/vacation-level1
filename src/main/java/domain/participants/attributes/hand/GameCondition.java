package domain.participants.attributes.hand;

public enum GameCondition {
    HIT,
    BLACKJACK,
    STAND,
    BUST;

    private static final int BLACKJACK_SCORE = 21;

    public static GameCondition find(final int score, final int cardCount) {
        if (score > BLACKJACK_SCORE) {
            return BUST;
        }
        if (score == BLACKJACK_SCORE && cardCount == 2) {
            return BLACKJACK;
        }
        if (score == BLACKJACK_SCORE) {
            return STAND;
        }
        return HIT;
    }
}
