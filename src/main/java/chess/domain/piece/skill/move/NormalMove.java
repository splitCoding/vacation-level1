package chess.domain.piece.skill.move;

import chess.domain.board.Square;

public class NormalMove implements Move {

    @Override
    public void move(final Square start, final Square end) {
        start.moveTo(end);
    }
}
