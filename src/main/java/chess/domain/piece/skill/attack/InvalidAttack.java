package chess.domain.piece.skill.attack;

import chess.domain.board.Square;

public class InvalidAttack implements Attack {

    @Override
    public void attack(final Square start, final Square end) {
        throw new UnsupportedOperationException("공격이 불가능 합니다");
    }
}
