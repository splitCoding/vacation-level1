package chess.domain.location.difference;

public final class ColumnDifference extends Difference {

    public ColumnDifference(int value) {
        super(value);
    }

    public static ColumnDifference valueOf(int value) {
        return new ColumnDifference(value);
    }

    @Override
    public String toString() {
        return "ColumnDifference{" +
            "value=" + value +
            '}';
    }
}
