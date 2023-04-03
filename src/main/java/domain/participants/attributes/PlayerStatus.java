package domain.participants.attributes;

public enum PlayerStatus {
    HIT,
    BLACKJACK,
    BUST;

    public static PlayerStatus find(int score) {
        if (score > 21) {
            return BUST;
        }
        if (score == 21) {
            return BLACKJACK;
        }
        return HIT;
    }
}
