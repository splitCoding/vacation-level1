package domain.participants.attributes.bettingCondition;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameResultTest {

    @DisplayName("1000원 배팅시 게임 결과에 따른 수익을 반환한다.")
    @ParameterizedTest(name = "게임결과가 {0}일 때 수익은 {1}이다.")
    @CsvSource(value = {
        "WIN:1000",
        "DRAW:0",
        "LOSE:-1000"
    }, delimiter = ':')
    void getBenefit(final GameResult gameResult, final int expectBenefit) {
        final int bettingAmount = 1000;
        final int benefit = gameResult.getBenefit(bettingAmount);
        Assertions.assertThat(benefit).isEqualTo(expectBenefit);
    }

    @DisplayName("플레이 중에 수익을 조회할 경우 오류를 던진다.")
    @Test
    void getBenefitWhilePlaying() {
        Assertions.assertThatThrownBy(() -> GameResult.PLAYING.getBenefit(1000))
            .isInstanceOf(IllegalStateException.class);
    }
}
