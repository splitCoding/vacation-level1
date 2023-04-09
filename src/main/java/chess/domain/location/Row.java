package chess.domain.location;

import chess.domain.location.difference.RowDifference;
import java.util.Objects;

public final class Row {

    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 7;

    private final int value;

    private Row(int value) {
        this.value = value;
    }

    public static Row valueOf(int value) {
        validateRange(value);
        return new Row(value);
    }

    private static void validateRange(final int value) {
        if (value < MIN_RANGE || value > MAX_RANGE) {
            throw new IllegalArgumentException("존재하지 않는 행입니다." + value);
        }
    }

    public RowDifference getDifference(final Row other) {
        return RowDifference.valueOf(value - other.value);
    }

    public Row addValue(final int addValue) {
        return new Row(value + addValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Row row = (Row) o;
        return value == row.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
