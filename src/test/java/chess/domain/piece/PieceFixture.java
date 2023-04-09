package chess.domain.piece;

public class PieceFixture {

    public static final Piece BlackPawn = Piece.typeAndCamp(PieceType.PAWN, Camp.BLACK);
    public static final Piece WhitePawn = Piece.typeAndCamp(PieceType.PAWN, Camp.WHITE);
    public static final Piece EMPTY = Piece.empty();

    private PieceFixture() {
    }
}
