package chess.domain.location;

import chess.domain.location.difference.ColumnDifference;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ColumnTest {

    @DisplayName("열의 값이 0보다 작을 경우 오류를 던진다.")
    @Test
    void createFailUnderZero() {
        Assertions.assertThatThrownBy(() -> Column.valueOf(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("열의 값이 7보다 큰 경우 오류를 던진다.")
    @Test
    void createFailOverSeven() {
        Assertions.assertThatThrownBy(() -> Column.valueOf(8))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다른 열과의 차이를 가진 객체를 반환한다.")
    @Test
    void getDifference() {
        final Column start = Column.valueOf(3);
        final Column end = Column.valueOf(6);
        final ColumnDifference difference = start.getDifference(end);
        Assertions.assertThat(difference.hasSameAbsoluteDifference(ColumnDifference.valueOf(-3)))
            .isTrue();
    }
}
