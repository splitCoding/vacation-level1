package chess.domain.direction;

import chess.domain.location.LocationComparator;
import chess.domain.location.difference.LocationDifference;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public enum Direction {
    UP(1, 0, LocationComparator::isPointingUp),
    DOWN(-1, 0, LocationComparator::isPointingDown),
    LEFT(0, -1, LocationComparator::isPointingLeft),
    RIGHT(0, 1, LocationComparator::isPointingRight),
    UP_RIGHT(1, 1, LocationComparator::isPointingUpRight),
    UP_LEFT(1, -1, LocationComparator::isPointingUpLeft),
    DOWN_RIGHT(-1, 1, LocationComparator::isPointingDownRight),
    DOWN_LEFT(-1, -1, LocationComparator::isPointingDownLeft),
    UP_UP_RIGHT(2, 1, LocationComparator::isPointingUpUpRight),
    UP_UP_LEFT(2, -1, LocationComparator::isPointingUpUpLeft),
    DOWN_DOWN_RIGHT(-2, 1, LocationComparator::isPointingDownDownRight),
    DOWN_DOWN_LEFT(-2, -1, LocationComparator::isPointingDownDownLeft),
    LEFT_LEFT_UP(1, -2, LocationComparator::isPointingLeftLeftUp),
    LEFT_LEFT_DOWN(-1, -2, LocationComparator::isPointingLeftLeftDown),
    RIGHT_RIGHT_UP(1, 2, LocationComparator::isPointingRightRightUp),
    RIGHT_RIGHT_DOWN(-1, 2, LocationComparator::isPointingRightRightDown);

    private final int rowChange;
    private final int columnChange;
    private final Predicate<LocationDifference> check;

    Direction(int rowChange, int columnChange, Predicate<LocationDifference> check) {
        this.rowChange = rowChange;
        this.columnChange = columnChange;
        this.check = check;
    }

    public static Direction find(final LocationDifference difference) {
        return Arrays.stream(values())
            .filter((direction -> direction.check.test(difference)))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("위치의 차이를 통해 구할 수 있는 기물 이동 방향이 없습니다." + difference));
    }

    private static List<Direction> upDownLeftRight() {
        return List.of(
            Direction.UP,
            Direction.DOWN,
            Direction.LEFT,
            Direction.RIGHT
        );
    }

    private static List<Direction> diagonals() {
        return List.of(
            Direction.UP_LEFT,
            Direction.UP_RIGHT,
            Direction.DOWN_LEFT,
            Direction.DOWN_RIGHT
        );
    }

    private static List<Direction> upDownLefRightAndDiagonals() {
        return List.of(
            Direction.UP,
            Direction.DOWN,
            Direction.LEFT,
            Direction.RIGHT,
            Direction.UP_LEFT,
            Direction.UP_RIGHT,
            Direction.DOWN_LEFT,
            Direction.DOWN_RIGHT
        );
    }

    public static List<Direction> getPawnMoveDirections() {
        return List.of(Direction.UP, Direction.DOWN);
    }

    public static List<Direction> getPawnAttackDirections() {
        return diagonals();
    }

    public static List<Direction> getRookMoveDirections() {
        return upDownLeftRight();
    }

    public static List<Direction> getRookAttackDirections() {
        return upDownLeftRight();
    }

    public static List<Direction> getKnightMoveDirections() {
        return List.of(
            UP_UP_RIGHT,
            UP_UP_LEFT,
            DOWN_DOWN_RIGHT,
            DOWN_DOWN_LEFT,
            LEFT_LEFT_UP,
            LEFT_LEFT_DOWN,
            RIGHT_RIGHT_UP,
            RIGHT_RIGHT_DOWN
        );
    }

    public static List<Direction> getKnightAttackDirections() {
        return List.of(
            UP_UP_RIGHT,
            UP_UP_LEFT,
            DOWN_DOWN_RIGHT,
            DOWN_DOWN_LEFT,
            LEFT_LEFT_UP,
            LEFT_LEFT_DOWN,
            RIGHT_RIGHT_UP,
            RIGHT_RIGHT_DOWN
        );
    }

    public static List<Direction> getBishopMoveDirections() {
        return diagonals();
    }

    public static List<Direction> getBishopAttackDirections() {
        return diagonals();
    }

    public static List<Direction> getQueenMoveDirections() {
        return upDownLefRightAndDiagonals();
    }

    public static List<Direction> getQueenAttackDirections() {
        return upDownLefRightAndDiagonals();
    }

    public static List<Direction> getKingMoveDirections() {
        return upDownLefRightAndDiagonals();
    }

    public static List<Direction> getKingAttackDirections() {
        return upDownLefRightAndDiagonals();
    }

    public static List<Direction> getEmpty() {
        return List.of();
    }

    public int getRowChange() {
        return rowChange;
    }

    public int getColumnChange() {
        return columnChange;
    }
}
