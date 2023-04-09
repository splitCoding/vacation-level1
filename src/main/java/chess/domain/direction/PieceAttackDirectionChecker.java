package chess.domain.direction;

import chess.domain.piece.PieceType;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class PieceAttackDirectionChecker implements DirectionChecker {

    private static final Map<PieceType, DirectionChecker> CACHE = new EnumMap<>(PieceType.class);

    static {
        for (PieceType pieceType : PieceType.values()) {
            CACHE.put(pieceType, new PieceAttackDirectionChecker(pieceType.getValidAttackDirections()));
        }
    }

    private final List<Direction> validDirections;

    private PieceAttackDirectionChecker(final List<Direction> directions) {
        this.validDirections = new ArrayList<>(directions);
    }

    public static DirectionChecker getByPieceType(final PieceType pieceType) {
        if (pieceType == PieceType.EMPTY) {
            throw new IllegalArgumentException("빈 기물은 공격할 수 있는 방향이 없습니다.");
        }
        return CACHE.get(pieceType);
    }

    @Override
    public boolean isValid(Direction direction) {
        return validDirections.contains(direction);
    }
}
