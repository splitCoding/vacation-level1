package view.converter;

import domain.deck.card.Suit;

public enum SuitViewConverter {
    SPADE("스페이드"),
    CLOVER("클로버"),
    DIAMOND("다이아몬드"),
    HEART("하트");

    private final String content;

    SuitViewConverter(final String content) {
        this.content = content;
    }

    public static String convert(final Suit suit) {
        return valueOf(suit.name()).content;
    }
}
