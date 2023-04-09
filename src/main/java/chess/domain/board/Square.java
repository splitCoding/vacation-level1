package chess.domain.board;

import chess.domain.piece.Piece;

public class Square {

    private Piece piece;

    public Square(Piece piece) {
        this.piece = piece;
    }

    public void moveTo(final Square destination) {
        destination.piece = this.piece;
        piece = Piece.empty();
    }

    public Piece getPiece() {
        return piece;
    }
}
