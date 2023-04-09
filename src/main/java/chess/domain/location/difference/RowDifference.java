package chess.domain.location.difference;

public final class RowDifference extends Difference {

    public RowDifference(int value) {
        super(value);
    }

    public static RowDifference valueOf(int value) {
        return new RowDifference(value);
    }

    @Override
    public String toString() {
        return "RowDifference{" +
            "value=" + value +
            '}';
    }
}
