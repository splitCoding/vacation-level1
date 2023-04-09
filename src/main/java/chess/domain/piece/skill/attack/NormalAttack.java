package chess.domain.piece.skill.attack;

import chess.domain.board.Square;

public class NormalAttack implements Attack {

    @Override
    public void attack(final Square start, final Square end) {
        start.moveTo(end);
    }
}
