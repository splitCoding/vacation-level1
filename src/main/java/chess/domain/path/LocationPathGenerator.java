package chess.domain.path;

import chess.domain.direction.Direction;
import chess.domain.location.Location;
import chess.domain.location.difference.LocationDifference;
import java.util.ArrayList;
import java.util.List;

public class LocationPathGenerator {

    public List<Location> generate(final Location start, final Location end) {
        final int pathLength = calculatePathLength(start, end);
        final List<Location> locationPath = new ArrayList<>();
        final Direction direction = findDirection(start, end);
        Location current = start;
        for (int count = 0; count < pathLength; count++) {
            current = current.addDirection(direction);
            locationPath.add(current);
        }
        return locationPath;
    }

    private Direction findDirection(final Location start, final Location end) {
        return Direction.find(new LocationDifference(start, end));
    }

    private int calculatePathLength(final Location start, final Location end) {
        final int absoluteRowDifference = Math.abs(start.getRowDifference(end).getValue());
        final int absoluteColumnDifference = Math.abs(start.getColumnDifference(end).getValue());
        return Math.max(absoluteRowDifference, absoluteColumnDifference);
    }
}
