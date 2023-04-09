package chess.domain.destination;

import chess.domain.piece.Camp;

public interface DestinationChecker {

    boolean isAble(final Camp moveCamp, final Camp destinationCamp);

    static DestinationChecker attackChecker() {
        return new AttackDestinationChecker();
    }

    static DestinationChecker moveChecker() {
        return new MoveDestinationChecker();
    }
}
