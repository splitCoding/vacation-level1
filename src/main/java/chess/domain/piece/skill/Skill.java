package chess.domain.piece.skill;

import chess.domain.piece.skill.attack.Attack;
import chess.domain.piece.skill.attack.InvalidAttack;
import chess.domain.piece.skill.attack.NormalAttack;
import chess.domain.piece.skill.move.InvalidMove;
import chess.domain.piece.skill.move.Move;
import chess.domain.piece.skill.move.NormalMove;

public enum Skill {
    SLIDING_AND_ATTACK(new NormalAttack(), new NormalMove(), SkillChecker.SLIDE_AND_NORMAL_ATTACK),
    JUMPING_AND_ATTACK(new NormalAttack(), new NormalMove(), SkillChecker.JUMP_AND_NORMAL_ATTACK),
    NO_SKILL(new InvalidAttack(), new InvalidMove(), SkillChecker.NO_SKILL);

    private final Attack attack;
    private final Move move;
    private final SkillChecker skillChecker;

    Skill(Attack attack, Move move, SkillChecker skillChecker) {
        this.attack = attack;
        this.move = move;
        this.skillChecker = skillChecker;
    }

    public SkillChecker getSkillChecker() {
        return skillChecker;
    }

    public Attack getAttack() {
        return attack;
    }

    public Move getMove() {
        return move;
    }
}
