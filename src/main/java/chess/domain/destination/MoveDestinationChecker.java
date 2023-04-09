package chess.domain.destination;

import chess.domain.piece.Camp;

public class MoveDestinationChecker implements DestinationChecker {

    MoveDestinationChecker() {
    }

    @Override
    public boolean isAble(final Camp moveCamp, final Camp destinationCamp) {
        if (moveCamp == Camp.NONE) {
            throw new IllegalArgumentException("진영이 없는 빈 기물은 움직일 수 없습니다");
        }
        return destinationCamp == Camp.NONE;
    }
}
