package chess.domain.piece;

import chess.domain.piece.skill.SkillChecker;
import chess.domain.piece.skill.attack.Attack;
import chess.domain.piece.skill.move.Move;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Piece {

    private static final Map<Integer, Piece> CACHE = new HashMap<>();
    private final PieceType pieceType;
    private final Camp camp;

    private Piece(PieceType pieceType, Camp camp) {
        this.pieceType = pieceType;
        this.camp = camp;
    }

    public static Piece typeAndCamp(final PieceType pieceType, final Camp camp) {
        final int hash = Objects.hash(pieceType, camp);
        return CACHE.computeIfAbsent(hash, value -> new Piece(pieceType, camp));
    }

    public static Piece empty() {
        final int hash = Objects.hash(PieceType.EMPTY, Camp.NONE);
        return CACHE.computeIfAbsent(hash, value -> new Piece(PieceType.EMPTY, Camp.NONE));
    }

    public boolean isEmptyPiece() {
        return pieceType == PieceType.EMPTY;
    }

    public Camp getCamp() {
        return camp;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public Move getMove() {
        return pieceType.getSkill().getMove();
    }

    public Attack getAttack() {
        return pieceType.getSkill().getAttack();
    }

    public SkillChecker getSkillChecker() {
        return pieceType.getSkill().getSkillChecker();
    }

    @Override
    public String toString() {
        return "Piece{" +
            "pieceType=" + pieceType +
            ", camp=" + camp +
            '}';
    }
}
