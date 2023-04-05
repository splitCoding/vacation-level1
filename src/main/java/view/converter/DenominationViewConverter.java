package view.converter;

import domain.deck.card.Denomination;

public enum DenominationViewConverter {

    ACE("A"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K");

    private final String content;

    DenominationViewConverter(final String content) {
        this.content = content;
    }

    public static String convert(final Denomination denomination) {
        final DenominationViewConverter denominationViewConverter = valueOf(denomination.name());
        return denominationViewConverter.content;
    }
}
