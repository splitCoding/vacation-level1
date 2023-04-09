package chess.domain.game;

import chess.domain.board.BoardGenerator;

public class ChessGameGenerator {

    private ChessGameGenerator() {

    }

    public static ChessGame generate(final BoardGenerator boardGenerator) {
        return new ChessGame(boardGenerator.generate(), Turn.WHITE);
    }
}
