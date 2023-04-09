package chess.domain.piece.skill.move;

import chess.domain.board.Square;

public class InvalidMove implements Move {

    @Override
    public void move(final Square start, final Square end) {
        throw new UnsupportedOperationException("이동할 수 없습니다.");
    }
}
