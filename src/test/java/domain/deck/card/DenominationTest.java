package domain.deck.card;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DenominationTest {

    @DisplayName("끝수는 자신에 해당되는 점수를 반환한다.")
    @ParameterizedTest(name = "{0}는 {1}점이다.")
    @CsvSource(value = {
        "ACE:1",
        "TWO:2",
        "THREE:3",
        "FOUR:4",
        "FIVE:5",
        "SIX:6",
        "SEVEN:7",
        "EIGHT:8",
        "NINE:9",
        "TEN:10",
        "JACK:10",
        "QUEEN:10",
        "KING:10",
    }, delimiter = ':')
    void getScore(Denomination denomination, int score) {
        int expectScore = denomination.getScore();
        Assertions.assertThat(expectScore).isEqualTo(score);
    }
}
