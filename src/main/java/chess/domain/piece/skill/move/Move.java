package chess.domain.piece.skill.move;

import chess.domain.board.Square;

public interface Move {

    void move(final Square start, final Square end);
}
