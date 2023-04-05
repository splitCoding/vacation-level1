package view.converter;

import domain.participants.attributes.bettingCondition.GameResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameResultViewConverterTest {

    @DisplayName("게임의 결과를 출력할 내용으로 변환한다.")
    @ParameterizedTest(name = "{0}는(은) {1}로 변환된다.")
    @CsvSource(value = {
        "WIN:승",
        "DRAW:무",
        "LOSE:패"
    }, delimiter = ':')
    void convert(final GameResult gameResult, final String expectContent) {
        Assertions.assertThat(GameResultViewConverter.convert(gameResult))
            .isEqualTo(expectContent);
    }
}
