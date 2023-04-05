package view.converter;

import domain.deck.card.Suit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SuitViewConverterTest {

    @DisplayName("카드의 문양을 출력할 내용으로 변환한다.")
    @ParameterizedTest(name = "{0}는(은) {1}로 변환된다.")
    @CsvSource(value = {
        "SPADE:스페이드",
        "CLOVER:클로버",
        "DIAMOND:다이아몬드",
        "HEART:하트"
    }, delimiter = ':')
    void convert(final Suit suit, final String expectContent) {
        Assertions.assertThat(SuitViewConverter.convert(suit))
            .isEqualTo(expectContent);
    }
}
