package chess.domain.piece;

import chess.domain.direction.Direction;
import chess.domain.piece.skill.Skill;
import java.util.List;

public enum PieceType {
    PAWN(Direction.getPawnMoveDirections(), Direction.getPawnAttackDirections(), Skill.SLIDING_AND_ATTACK),
    ROOK(Direction.getRookMoveDirections(), Direction.getRookAttackDirections(), Skill.SLIDING_AND_ATTACK),
    KNIGHT(Direction.getKnightMoveDirections(), Direction.getKnightAttackDirections(), Skill.JUMPING_AND_ATTACK),
    BISHOP(Direction.getBishopMoveDirections(), Direction.getBishopAttackDirections(), Skill.SLIDING_AND_ATTACK),
    QUEEN(Direction.getQueenMoveDirections(), Direction.getQueenAttackDirections(), Skill.SLIDING_AND_ATTACK),
    KING(Direction.getKingMoveDirections(), Direction.getKingAttackDirections(), Skill.JUMPING_AND_ATTACK),
    EMPTY(Direction.getEmpty(), Direction.getEmpty(), Skill.NO_SKILL);

    private final List<Direction> validMoveDirections;
    private final List<Direction> validAttackDirections;
    private final Skill skill;

    PieceType(List<Direction> validMoveDirections, List<Direction> validAttackDirections, Skill skill) {
        this.validMoveDirections = validMoveDirections;
        this.validAttackDirections = validAttackDirections;
        this.skill = skill;
    }

    public List<Direction> getValidMoveDirections() {
        return validMoveDirections;
    }

    public List<Direction> getValidAttackDirections() {
        return validAttackDirections;
    }

    public Skill getSkill() {
        return skill;
    }
}
