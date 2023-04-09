package chess.domain.piece.skill;

import chess.domain.destination.DestinationChecker;
import chess.domain.path.Path;
import chess.domain.path.PathChecker;
import chess.domain.piece.Camp;

public enum SkillChecker {
    SLIDE_AND_NORMAL_ATTACK(
        PathChecker.slideChecker(),
        DestinationChecker.moveChecker(),
        DestinationChecker.attackChecker()
    ),
    JUMP_AND_NORMAL_ATTACK(
        PathChecker.jumpChecker(),
        DestinationChecker.moveChecker(),
        DestinationChecker.attackChecker()
    ),
    NO_SKILL(
        (path) -> false,
        (moveCamp, destinationCamp) -> false,
        (moveCamp, destinationCamp) -> false
    );

    private final PathChecker pathChecker;
    private final DestinationChecker moveDestinationChecker;
    private final DestinationChecker attackDestinationChecker;

    SkillChecker(final PathChecker pathChecker, final DestinationChecker moveDestinationChecker,
        DestinationChecker attackDestinationChecker) {
        this.pathChecker = pathChecker;
        this.moveDestinationChecker = moveDestinationChecker;
        this.attackDestinationChecker = attackDestinationChecker;
    }

    public boolean isMoveReady(final Camp pieceCamp, final Path path) {
        final boolean isPathValid = pathChecker.isValid(path);
        final boolean ableToMove = moveDestinationChecker.isAble(pieceCamp, path.getDestinationCamp());
        return isPathValid && ableToMove;
    }

    public boolean isAttackReady(final Camp pieceCamp, final Path path) {
        final boolean isPathValid = pathChecker.isValid(path);
        final boolean ableToAttack = attackDestinationChecker.isAble(pieceCamp, path.getDestinationCamp());
        return isPathValid && ableToAttack;
    }
}
