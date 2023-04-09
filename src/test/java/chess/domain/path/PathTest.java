package chess.domain.path;

import chess.domain.piece.Camp;
import chess.domain.piece.PieceFixture;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PathTest {

    @DisplayName("경로에 기물이 존재하지 않는지 반환한다. (기물이 존재할 때)")
    @Test
    void isCleanWhenPieceExistInPath() {
        final Path path = new Path(List.of(
            PieceFixture.BlackPawn,
            PieceFixture.WhitePawn,
            PieceFixture.EMPTY
        ));
        Assertions.assertThat(path.isClean()).isFalse();
    }

    @DisplayName("경로에 기물이 존재하지 않는지 반환한다. (기물이 존재하지 않을 때)")
    @Test
    void isCleanWhenPieceNotExistInPath() {
        final Path path = new Path(List.of(
            PieceFixture.EMPTY,
            PieceFixture.EMPTY,
            PieceFixture.BlackPawn
        ));
        Assertions.assertThat(path.isClean()).isTrue();
    }

    @DisplayName("도착지점의 진영을 반환한다.")
    @Test
    void getDestinationCamp() {
        final Path path = new Path(PieceFixture.EMPTY);
        Assertions.assertThat(path.getDestinationCamp()).isEqualTo(Camp.NONE);
    }
}
