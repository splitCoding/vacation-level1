package chess.domain.board;

import chess.domain.location.Column;
import chess.domain.location.Location;
import chess.domain.location.Row;
import chess.domain.piece.Camp;
import chess.domain.piece.Piece;
import chess.domain.piece.PieceType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StandardGenerator implements BoardGenerator {

    private static final List<Square> WHITE_NOBILITY_LINE = List.of(
        new Square(Piece.typeAndCamp(PieceType.ROOK, Camp.WHITE)),
        new Square(Piece.typeAndCamp(PieceType.KNIGHT, Camp.WHITE)),
        new Square(Piece.typeAndCamp(PieceType.BISHOP, Camp.WHITE)),
        new Square(Piece.typeAndCamp(PieceType.QUEEN, Camp.WHITE)),
        new Square(Piece.typeAndCamp(PieceType.KING, Camp.WHITE)),
        new Square(Piece.typeAndCamp(PieceType.BISHOP, Camp.WHITE)),
        new Square(Piece.typeAndCamp(PieceType.KNIGHT, Camp.WHITE)),
        new Square(Piece.typeAndCamp(PieceType.ROOK, Camp.WHITE))
    );

    private static final List<Square> WHITE_PAWNS_LINE = List.of(
        new Square(Piece.typeAndCamp(PieceType.PAWN, Camp.WHITE)),
        new Square(Piece.typeAndCamp(PieceType.PAWN, Camp.WHITE)),
        new Square(Piece.typeAndCamp(PieceType.PAWN, Camp.WHITE)),
        new Square(Piece.typeAndCamp(PieceType.PAWN, Camp.WHITE)),
        new Square(Piece.typeAndCamp(PieceType.PAWN, Camp.WHITE)),
        new Square(Piece.typeAndCamp(PieceType.PAWN, Camp.WHITE)),
        new Square(Piece.typeAndCamp(PieceType.PAWN, Camp.WHITE)),
        new Square(Piece.typeAndCamp(PieceType.PAWN, Camp.WHITE))
    );

    private static final List<Square> BLACK_NOBILITY_LINE = List.of(
        new Square(Piece.typeAndCamp(PieceType.ROOK, Camp.BLACK)),
        new Square(Piece.typeAndCamp(PieceType.KNIGHT, Camp.BLACK)),
        new Square(Piece.typeAndCamp(PieceType.BISHOP, Camp.BLACK)),
        new Square(Piece.typeAndCamp(PieceType.QUEEN, Camp.BLACK)),
        new Square(Piece.typeAndCamp(PieceType.KING, Camp.BLACK)),
        new Square(Piece.typeAndCamp(PieceType.BISHOP, Camp.BLACK)),
        new Square(Piece.typeAndCamp(PieceType.KNIGHT, Camp.BLACK)),
        new Square(Piece.typeAndCamp(PieceType.ROOK, Camp.BLACK))
    );

    private static final List<Square> BLACK_PAWNS_LINE = List.of(
        new Square(Piece.typeAndCamp(PieceType.PAWN, Camp.BLACK)),
        new Square(Piece.typeAndCamp(PieceType.PAWN, Camp.BLACK)),
        new Square(Piece.typeAndCamp(PieceType.PAWN, Camp.BLACK)),
        new Square(Piece.typeAndCamp(PieceType.PAWN, Camp.BLACK)),
        new Square(Piece.typeAndCamp(PieceType.PAWN, Camp.BLACK)),
        new Square(Piece.typeAndCamp(PieceType.PAWN, Camp.BLACK)),
        new Square(Piece.typeAndCamp(PieceType.PAWN, Camp.BLACK)),
        new Square(Piece.typeAndCamp(PieceType.PAWN, Camp.BLACK))
    );

    private static final List<Square> EMPTY_LINE = List.of(
        new Square(Piece.empty()),
        new Square(Piece.empty()),
        new Square(Piece.empty()),
        new Square(Piece.empty()),
        new Square(Piece.empty()),
        new Square(Piece.empty()),
        new Square(Piece.empty()),
        new Square(Piece.empty())
    );
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 8;

    @Override
    public Board generate() {
        final List<Location> locations = generateLocations();
        final List<Square> squares = generateSquares();
        final Map<Location, Square> board = IntStream.range(0, locations.size())
            .boxed()
            .collect(Collectors.toMap(locations::get, squares::get));
        return new Board(board);
    }

    private List<Square> generateSquares() {
        List<Square> board = new ArrayList<>();
        board.addAll(WHITE_NOBILITY_LINE);
        board.addAll(WHITE_PAWNS_LINE);
        board.addAll(EMPTY_LINE);
        board.addAll(EMPTY_LINE);
        board.addAll(EMPTY_LINE);
        board.addAll(EMPTY_LINE);
        board.addAll(BLACK_PAWNS_LINE);
        board.addAll(BLACK_NOBILITY_LINE);
        return board;
    }

    private List<Location> generateLocations() {
        final List<Location> locations = new ArrayList<>();
        for (int rowValue = MIN_RANGE; rowValue < MAX_RANGE; rowValue++) {
            generateLocation(locations, rowValue);
        }
        return locations;
    }

    private void generateLocation(final List<Location> locations, final int rowValue) {
        for (int columnValue = MIN_RANGE; columnValue < MAX_RANGE; columnValue++) {
            locations.add(new Location(Row.valueOf(rowValue), Column.valueOf(columnValue)));
        }
    }
}
