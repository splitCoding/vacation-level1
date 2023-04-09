package chess.domain.path;

import chess.domain.piece.Camp;
import chess.domain.piece.Piece;
import java.util.ArrayList;
import java.util.List;

public class Path {

    private final List<Piece> piecesInPath;
    private final Camp destinationCamp;

    public Path(Piece piece) {
        this.destinationCamp = piece.getCamp();
        piecesInPath = new ArrayList<>();
    }

    public Path(final List<Piece> piecesInPath) {
        final ArrayList<Piece> pieces = new ArrayList<>(piecesInPath);
        this.destinationCamp = pieces.remove(pieces.size() - 1).getCamp();
        this.piecesInPath = pieces;
    }

    public boolean isClean() {
        return piecesInPath.stream()
            .allMatch(Piece::isEmptyPiece);
    }

    public int getMoveCount() {
        return piecesInPath.size();
    }

    public Camp getDestinationCamp() {
        return destinationCamp;
    }
}
