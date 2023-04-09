package chess.domain.location;

import chess.domain.direction.Direction;
import chess.domain.location.difference.ColumnDifference;
import chess.domain.location.difference.RowDifference;
import java.util.Objects;

public final class Location {

    private final Row row;
    private final Column column;

    public Location(Row row, Column column) {
        this.row = row;
        this.column = column;
    }

    public RowDifference getRowDifference(final Location other) {
        return row.getDifference(other.row);
    }

    public ColumnDifference getColumnDifference(final Location other) {
        return column.getDifference(other.column);
    }

    public Location addDirection(final Direction direction) {
        return new Location(row.addValue(direction.getRowChange()), column.addValue(direction.getColumnChange()));
    }

    public Row getRow() {
        return row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Location location = (Location) o;
        return row.equals(location.row) && column.equals(location.column);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
