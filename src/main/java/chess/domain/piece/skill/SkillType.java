package chess.domain.piece.skill;

import chess.domain.piece.skill.attack.Attack;
import chess.domain.piece.skill.attack.InvalidAttack;
import chess.domain.piece.skill.attack.NormalAttack;
import chess.domain.piece.skill.move.InvalidMove;
import chess.domain.piece.skill.move.Move;
import chess.domain.piece.skill.move.NormalMove;

public enum SkillType {
    MOVE_AND_ATTACK(new NormalAttack(), new NormalMove()),
    NO_SKILL(new InvalidAttack(), new InvalidMove());
    
    private final Attack attack;
    private final Move move;

    SkillType(Attack attack, Move move) {
        this.attack = attack;
        this.move = move;
    }

    public Attack getAttack() {
        return attack;
    }

    public Move getMove() {
        return move;
    }
}
