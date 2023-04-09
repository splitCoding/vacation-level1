package chess.domain.game;

import chess.domain.board.Board;
import chess.domain.location.Location;

public class ChessGame {

    private final Board board;
    private Turn turn;

    public ChessGame(Board board, Turn turn) {
        this.board = board;
    }

    public void move(final Location start, final Location end) {
        if (board.getCamp(start).isTurn(turn)) {
            board.move(start, end);
            turn.next();
        }
        throw new IllegalStateException("다른 진영의 순서입니다.");
    }

    public boolean isGameEnd() {
        return board.isAllKingAlive();
    }
}
