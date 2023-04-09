package chess.domain.board;

import chess.domain.direction.Direction;
import chess.domain.direction.DirectionChecker;
import chess.domain.direction.PieceAttackDirectionChecker;
import chess.domain.direction.PieceMoveDirectionChecker;
import chess.domain.location.Location;
import chess.domain.location.Row;
import chess.domain.location.difference.LocationDifference;
import chess.domain.path.LocationPathGenerator;
import chess.domain.path.Path;
import chess.domain.piece.Camp;
import chess.domain.piece.Piece;
import chess.domain.piece.PieceType;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Board {

    private static final int NEEDED_KING_COUNT = 2;
    private final Map<Location, Square> squares;
    private final LocationPathGenerator locationPathGenerator;

    Board(Map<Location, Square> squares) {
        this.squares = squares;
        locationPathGenerator = new LocationPathGenerator();
    }

    public Camp getCamp(final Location location) {
        return squares.get(location).getPiece().getCamp();
    }

    public void move(final Location startLocation, final Location endLocation) {
        final Square start = squares.get(startLocation);
        final Square end = squares.get(endLocation);
        final Piece piece = start.getPiece();
        if (isAbleToMove(piece, startLocation, endLocation)) {
            start.moveTo(end);
//            piece.getMove().move(start, end);
            return;
        }
        if (isAbleToAttack(piece, startLocation, endLocation)) {
            start.moveTo(end);
//            piece.getAttack().attack(start, end);
            return;
        }
        throw new IllegalArgumentException("체스말이 이동할 수 없는 입력입니다.");
    }

    private boolean isAbleToMove(final Piece piece, final Location start, final Location end) {
        final LocationDifference locationDifference = new LocationDifference(start, end);
        final DirectionChecker moveChecker = PieceMoveDirectionChecker.getByPieceType(piece.getPieceType());
        if (!moveChecker.isValid(Direction.find(locationDifference))) {
            return false;
        }
        final Path path = makePath(start, end);

        if (piece == Piece.typeAndCamp(PieceType.PAWN, Camp.BLACK) && path.getMoveCount() == 2) {
            return start.getRow().equals(Row.valueOf(6));
        }
        return piece.getSkillChecker().isMoveReady(piece.getCamp(), path);
    }

    private boolean isAbleToAttack(final Piece piece, final Location start, final Location end) {
        if (piece.getPieceType() == PieceType.EMPTY) {
            throw new IllegalArgumentException("체스말이 없는 위치입니다.");
        }
        final LocationDifference locationDifference = new LocationDifference(start, end);
        final DirectionChecker attackChecker = PieceAttackDirectionChecker.getByPieceType(piece.getPieceType());
        final boolean validAttack = attackChecker.isValid(Direction.find(locationDifference));
        final boolean attackReady = piece.getSkillChecker().isAttackReady(piece.getCamp(), makePath(start, end));
        return validAttack && attackReady;
    }

    private Path makePath(final Location start, final Location end) {
        final List<Location> locationPath = locationPathGenerator.generate(start, end);
        final List<Piece> pathPieces = locationPath.stream()
            .map((location) -> squares.get(location).getPiece())
            .collect(Collectors.toList());
        return new Path(pathPieces);
    }

    public boolean isAllKingAlive() {
        final long kingCount = squares.values().stream()
            .map(Square::getPiece)
            .filter((piece) -> piece.getPieceType() == PieceType.KING)
            .count();
        return kingCount == NEEDED_KING_COUNT;
    }
}
