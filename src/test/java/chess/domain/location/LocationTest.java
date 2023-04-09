package chess.domain.location;

import chess.domain.location.difference.ColumnDifference;
import chess.domain.location.difference.RowDifference;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LocationTest {

    @DisplayName("위치끼리 비교하여 행의 차이를 반환한다.")
    @Test
    void getRowDifference() {
        final Location start = new Location(Row.valueOf(3), Column.valueOf(3));
        final Location end = new Location(Row.valueOf(5), Column.valueOf(5));
        final RowDifference rowDifference = start.getRowDifference(end);
        Assertions.assertThat(rowDifference.isSame(RowDifference.valueOf(-2)))
            .isTrue();
    }

    @DisplayName("위치끼리 비교하여 열의 차이를 반환한다.")
    @Test
    void getColumnDifference() {
        final Location start = new Location(Row.valueOf(5), Column.valueOf(2));
        final Location end = new Location(Row.valueOf(2), Column.valueOf(3));
        final ColumnDifference columnDifference = start.getColumnDifference(end);
        Assertions.assertThat(columnDifference.isSame(ColumnDifference.valueOf(-1)))
            .isTrue();
    }
}
