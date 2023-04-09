package chess.domain.location;

import chess.domain.location.difference.ColumnDifference;
import chess.domain.location.difference.LocationDifference;
import chess.domain.location.difference.RowDifference;

public class LocationComparator {

    private LocationComparator() {
    }

    public static boolean isPointingUp(final LocationDifference difference) {
        return difference.hasSameColumnDifference(ColumnDifference.valueOf(0))
            && difference.hasLowerRowDifference(RowDifference.valueOf(0));
    }

    public static boolean isPointingDown(final LocationDifference difference) {
        return difference.hasSameColumnDifference(ColumnDifference.valueOf(0))
            && difference.hasBiggerRowDifference(RowDifference.valueOf(0));
    }

    public static boolean isPointingLeft(final LocationDifference difference) {
        return difference.hasBiggerColumnDifference(ColumnDifference.valueOf(0))
            && difference.hasSameRowDifference(RowDifference.valueOf(0));
    }

    public static boolean isPointingRight(final LocationDifference difference) {
        return difference.hasLowerColumnDifference(ColumnDifference.valueOf(0))
            && difference.hasSameRowDifference(RowDifference.valueOf(0));
    }

    public static boolean isPointingUpRight(final LocationDifference difference) {
        return difference.isDiagonal()
            && difference.hasLowerColumnDifference(ColumnDifference.valueOf(0))
            && difference.hasLowerRowDifference(RowDifference.valueOf(0));
    }

    public static boolean isPointingUpLeft(final LocationDifference difference) {
        return difference.isDiagonal()
            && difference.hasBiggerColumnDifference(ColumnDifference.valueOf(0))
            && difference.hasLowerRowDifference(RowDifference.valueOf(0));
    }

    public static boolean isPointingDownRight(final LocationDifference difference) {
        return difference.isDiagonal()
            && difference.hasLowerColumnDifference(ColumnDifference.valueOf(0))
            && difference.hasSameRowDifference(RowDifference.valueOf(1));
    }

    public static boolean isPointingDownLeft(final LocationDifference difference) {
        return difference.isDiagonal()
            && difference.hasBiggerColumnDifference(ColumnDifference.valueOf(0))
            && difference.hasSameRowDifference(RowDifference.valueOf(1));
    }

    public static boolean isPointingUpUpLeft(final LocationDifference difference) {
        return difference.hasSameColumnDifference(ColumnDifference.valueOf(1))
            && difference.hasSameRowDifference(RowDifference.valueOf(-2));
    }

    public static boolean isPointingUpUpRight(final LocationDifference difference) {
        return difference.hasSameColumnDifference(ColumnDifference.valueOf(-1))
            && difference.hasSameRowDifference(RowDifference.valueOf(-2));
    }

    public static boolean isPointingDownDownLeft(final LocationDifference difference) {
        return difference.hasSameColumnDifference(ColumnDifference.valueOf(1))
            && difference.hasSameRowDifference(RowDifference.valueOf(2));
    }

    public static boolean isPointingDownDownRight(final LocationDifference difference) {
        return difference.hasSameColumnDifference(ColumnDifference.valueOf(-1))
            && difference.hasSameRowDifference(RowDifference.valueOf(2));
    }

    public static boolean isPointingLeftLeftUp(final LocationDifference difference) {
        return difference.hasSameColumnDifference(ColumnDifference.valueOf(2))
            && difference.hasSameRowDifference(RowDifference.valueOf(-1));
    }

    public static boolean isPointingLeftLeftDown(final LocationDifference difference) {
        return difference.hasSameColumnDifference(ColumnDifference.valueOf(2))
            && difference.hasSameRowDifference(RowDifference.valueOf(1));
    }

    public static boolean isPointingRightRightUp(final LocationDifference difference) {
        return difference.hasSameColumnDifference(ColumnDifference.valueOf(-2))
            && difference.hasSameRowDifference(RowDifference.valueOf(-1));
    }

    public static boolean isPointingRightRightDown(final LocationDifference difference) {
        return difference.hasSameColumnDifference(ColumnDifference.valueOf(-2))
            && difference.hasSameRowDifference(RowDifference.valueOf(1));
    }
}
