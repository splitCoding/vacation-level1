package chess.domain.location.difference;

public class Difference {

    protected final int value;

    protected Difference(int value) {
        this.value = value;
    }

    public boolean isSame(final Difference other) {
        return value == other.value;
    }

    public boolean isBiggerThan(final Difference other) {
        return value > other.value;
    }

    public boolean isLowerThan(final Difference other) {
        return value < other.value;
    }

    public boolean hasSameAbsoluteDifference(final Difference other) {
        return Math.abs(value) == Math.abs(other.value);
    }

    public int getValue() {
        return value;
    }
}
