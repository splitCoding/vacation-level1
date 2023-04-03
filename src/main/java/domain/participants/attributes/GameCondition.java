package domain.participants.attributes;

public enum GameCondition {
    HIT,
    BLACKJACK,
    BUST;

    public static GameCondition find(int score) {
        if (score > 21) {
            return BUST;
        }
        if (score == 21) {
            return BLACKJACK;
        }
        return HIT;
    }
}
