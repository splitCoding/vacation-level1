package chess.domain.piece.skill.attack;

import chess.domain.board.Square;

public interface Attack {

    void attack(final Square start, final Square square);
}
