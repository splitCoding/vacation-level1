package chess.domain.location;

import chess.domain.location.difference.RowDifference;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RowTest {

    @DisplayName("행의 값이 0보다 작을 경우 오류를 던진다.")
    @Test
    void createFailUnderZero() {
        Assertions.assertThatThrownBy(() -> Row.valueOf(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("행의 값이 7보다 큰 경우 오류를 던진다.")
    @Test
    void createFailOverSeven() {
        Assertions.assertThatThrownBy(() -> Row.valueOf(8))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다른 행과의 차이를 가진 객체를 반환한다.")
    @Test
    void getDifference() {
        final Row start = Row.valueOf(3);
        final Row end = Row.valueOf(6);
        final RowDifference difference = start.getDifference(end);
        Assertions.assertThat(difference.hasSameAbsoluteDifference(RowDifference.valueOf(-3)))
            .isTrue();
    }
}
