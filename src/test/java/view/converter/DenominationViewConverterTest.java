package view.converter;

import domain.deck.card.Denomination;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DenominationViewConverterTest {

    @DisplayName("카드의 끝수를 출력할 내용으로 변환한다.")
    @ParameterizedTest(name = "{0}는(은) {1}로 변환된다.")
    @CsvSource(value = {
        "ACE:A",
        "TWO:2",
        "THREE:3",
        "FOUR:4",
        "FIVE:5",
        "SIX:6",
        "SEVEN:7",
        "EIGHT:8",
        "NINE:9",
        "TEN:10",
        "JACK:J",
        "QUEEN:Q",
        "KING:K"
    }, delimiter = ':')
    void convert(final Denomination denomination, final String expectContent) {
        Assertions.assertThat(DenominationViewConverter.convert(denomination))
            .isEqualTo(expectContent);
    }
}
