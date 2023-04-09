package chess.domain.location;

import chess.domain.location.difference.ColumnDifference;

public final class Column {

    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 7;

    private final int value;

    private Column(int value) {
        this.value = value;
    }

    public static Column valueOf(int value) {
        validateRange(value);
        return new Column(value);
    }

    private static void validateRange(final int value) {
        if (value < MIN_RANGE || value > MAX_RANGE) {
            throw new IllegalArgumentException("존재하지 않는 열입니다." + value);
        }
    }

    public ColumnDifference getDifference(final Column other) {
        return ColumnDifference.valueOf(value - other.value);
    }

    public Column addValue(int addValue) {
        return new Column(value + addValue);
    }
}
