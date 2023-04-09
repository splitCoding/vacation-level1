package chess.domain.path;

import chess.domain.piece.PieceFixture;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JumpingPathCheckerTest {

    @DisplayName("이동가능한 경로인지 반환한다.(경로에 기물이 없을 떄)")
    @Test
    void isValidWhenPathBlocked() {
        final JumpingPathChecker jumpingPathChecker = new JumpingPathChecker();
        final Path path = new Path(List.of(
            PieceFixture.BlackPawn,
            PieceFixture.WhitePawn,
            PieceFixture.EMPTY
        ));
        Assertions.assertThat(jumpingPathChecker.isValid(path)).isTrue();
    }

    @DisplayName("이동가능한 경로인지 반환한다.(경로에 기물이 없을 떄)")
    @Test
    void isValidWhenPathClean() {
        final JumpingPathChecker jumpingPathChecker = new JumpingPathChecker();
        final Path path = new Path(List.of(
            PieceFixture.EMPTY,
            PieceFixture.EMPTY,
            PieceFixture.BlackPawn
        ));
        Assertions.assertThat(jumpingPathChecker.isValid(path)).isTrue();
    }
}
