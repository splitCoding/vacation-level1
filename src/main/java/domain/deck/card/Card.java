package domain.deck.card;

public enum Card {
    SPADE_ACE(Suit.SPADE, Denomination.ACE),
    SPADE_TWO(Suit.SPADE, Denomination.TWO),
    SPADE_THREE(Suit.SPADE, Denomination.THREE),
    SPADE_FOUR(Suit.SPADE, Denomination.FOUR),
    SPADE_FIVE(Suit.SPADE, Denomination.FIVE),
    SPADE_SIX(Suit.SPADE, Denomination.SIX),
    SPADE_SEVEN(Suit.SPADE, Denomination.SEVEN),
    SPADE_EIGHT(Suit.SPADE, Denomination.EIGHT),
    SPADE_NINE(Suit.SPADE, Denomination.NINE),
    SPADE_TEN(Suit.SPADE, Denomination.TEN),
    SPADE_JACK(Suit.SPADE, Denomination.JACK),
    SPADE_QUEEN(Suit.SPADE, Denomination.QUEEN),
    SPADE_KING(Suit.SPADE, Denomination.KING),
    CLOVER_ACE(Suit.CLOVER, Denomination.ACE),
    CLOVER_TWO(Suit.CLOVER, Denomination.TWO),
    CLOVER_THREE(Suit.CLOVER, Denomination.THREE),
    CLOVER_FOUR(Suit.CLOVER, Denomination.FOUR),
    CLOVER_FIVE(Suit.CLOVER, Denomination.FIVE),
    CLOVER_SIX(Suit.CLOVER, Denomination.SIX),
    CLOVER_SEVEN(Suit.CLOVER, Denomination.SEVEN),
    CLOVER_EIGHT(Suit.CLOVER, Denomination.EIGHT),
    CLOVER_NINE(Suit.CLOVER, Denomination.NINE),
    CLOVER_TEN(Suit.CLOVER, Denomination.TEN),
    CLOVER_JACK(Suit.CLOVER, Denomination.JACK),
    CLOVER_QUEEN(Suit.CLOVER, Denomination.QUEEN),
    CLOVER_KING(Suit.CLOVER, Denomination.KING),
    DIAMOND_ACE(Suit.DIAMOND, Denomination.ACE),
    DIAMOND_TWO(Suit.DIAMOND, Denomination.TWO),
    DIAMOND_THREE(Suit.DIAMOND, Denomination.THREE),
    DIAMOND_FOUR(Suit.DIAMOND, Denomination.FOUR),
    DIAMOND_FIVE(Suit.DIAMOND, Denomination.FIVE),
    DIAMOND_SIX(Suit.DIAMOND, Denomination.SIX),
    DIAMOND_SEVEN(Suit.DIAMOND, Denomination.SEVEN),
    DIAMOND_EIGHT(Suit.DIAMOND, Denomination.EIGHT),
    DIAMOND_NINE(Suit.DIAMOND, Denomination.NINE),
    DIAMOND_TEN(Suit.DIAMOND, Denomination.TEN),
    DIAMOND_JACK(Suit.DIAMOND, Denomination.JACK),
    DIAMOND_QUEEN(Suit.DIAMOND, Denomination.QUEEN),
    DIAMOND_KING(Suit.DIAMOND, Denomination.KING),
    HEART_ACE(Suit.HEART, Denomination.ACE),
    HEART_TWO(Suit.HEART, Denomination.TWO),
    HEART_THREE(Suit.HEART, Denomination.THREE),
    HEART_FOUR(Suit.HEART, Denomination.FOUR),
    HEART_FIVE(Suit.HEART, Denomination.FIVE),
    HEART_SIX(Suit.HEART, Denomination.SIX),
    HEART_SEVEN(Suit.HEART, Denomination.SEVEN),
    HEART_EIGHT(Suit.HEART, Denomination.EIGHT),
    HEART_NINE(Suit.HEART, Denomination.NINE),
    HEART_TEN(Suit.HEART, Denomination.TEN),
    HEART_JACK(Suit.HEART, Denomination.JACK),
    HEART_QUEEN(Suit.HEART, Denomination.QUEEN),
    HEART_KING(Suit.HEART, Denomination.KING);

    private final Suit suit;
    private final Denomination denomination;

    Card(Suit suit, Denomination denomination) {
        this.suit = suit;
        this.denomination = denomination;
    }

    public Suit getSuit() {
        return suit;
    }

    public Denomination getDenomination() {
        return denomination;
    }
}
