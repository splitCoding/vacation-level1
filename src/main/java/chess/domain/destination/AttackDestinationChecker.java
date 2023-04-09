package chess.domain.destination;

import chess.domain.piece.Camp;

public class AttackDestinationChecker implements DestinationChecker {

    public AttackDestinationChecker() {
    }

    @Override
    public boolean isAble(final Camp moveCamp, final Camp destinationCamp) {
        return moveCamp.isEnemy(destinationCamp);
    }
}
