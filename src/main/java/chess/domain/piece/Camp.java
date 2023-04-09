package chess.domain.piece;

import chess.domain.game.Turn;

public enum Camp {
    NONE,
    WHITE,
    BLACK;

    public boolean isEnemy(Camp other) {
        if (this == NONE) {
            throw new IllegalStateException("진영이 없는 기물은 적인지 여부를 판단할 수 없습니다.");
        }
        return this != other && other != NONE;
    }

    public boolean isTurn(final Turn turn) {
        if (this == Camp.WHITE && turn == Turn.WHITE) {
            return true;
        }
        return this == Camp.BLACK && turn == Turn.BLACK;
    }
}
