package chess.domain.location.difference;

import chess.domain.location.Location;

public class LocationDifference {

    private final Difference rowDifference;
    private final Difference columnDifference;

    public LocationDifference(final Location start, final Location end) {
        this.rowDifference = start.getRowDifference(end);
        this.columnDifference = start.getColumnDifference(end);
    }

    public boolean hasSameRowDifference(final RowDifference rowDifference) {
        return this.rowDifference.isSame(rowDifference);
    }

    public boolean hasBiggerRowDifference(final RowDifference rowDifference) {
        return this.rowDifference.isBiggerThan(rowDifference);
    }

    public boolean hasLowerRowDifference(final RowDifference rowDifference) {
        return this.rowDifference.isLowerThan(rowDifference);
    }

    public boolean hasSameColumnDifference(final ColumnDifference columnDifference) {
        return this.columnDifference.isSame(columnDifference);
    }

    public boolean hasBiggerColumnDifference(final ColumnDifference columnDifference) {
        return this.columnDifference.isBiggerThan(columnDifference);
    }

    public boolean hasLowerColumnDifference(final ColumnDifference columnDifference) {
        return this.columnDifference.isLowerThan(columnDifference);
    }

    public boolean isDiagonal() {
        return rowDifference.hasSameAbsoluteDifference(columnDifference);
    }

    @Override
    public String toString() {
        return "LocationDifference{" +
            "rowDifference=" + rowDifference +
            ", columnDifference=" + columnDifference +
            '}';
    }
}
