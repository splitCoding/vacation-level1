package view.converter;

import domain.GetMoreCardCommand;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GetCardCommandConverterTest {

    @DisplayName("카드 지급 여부 입력을 GetMoreCardCommand로 변환한다.")
    @ParameterizedTest(name = "입력값 {0}은(는) {1}로 바뀐다.")
    @CsvSource(value = {
        "y:YES",
        "n:NO"
    }, delimiter = ':')
    void convert(final String moreCardInput, final GetMoreCardCommand expectGetMoreCardCommand) {
        Assertions.assertThat(GetCardCommandConverter.convert(moreCardInput)).isEqualTo(expectGetMoreCardCommand);
    }

    @DisplayName("잘못된 입력은 오류를 던진다.")
    @Test
    void invalidInput() {
        Assertions.assertThatThrownBy(() -> GetCardCommandConverter.convert("a"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
