package chess.domain.destination;

import chess.domain.piece.Camp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveDestinationCheckerTest {

    @DisplayName("기물은 진영이 없는 곳으로만 움직일 수 있다.")
    @Test
    void isAble() {
        final MoveDestinationChecker moveDestinationChecker = new MoveDestinationChecker();
        Assertions.assertThat(moveDestinationChecker.isAble(Camp.BLACK, Camp.NONE)).isTrue();
        Assertions.assertThat(moveDestinationChecker.isAble(Camp.WHITE, Camp.NONE)).isTrue();
    }

    @DisplayName("기물은 진영이 있는 곳으로 움직일 수 없다.")
    @Test
    void isDisAble() {
        final MoveDestinationChecker moveDestinationChecker = new MoveDestinationChecker();
        Assertions.assertThat(moveDestinationChecker.isAble(Camp.BLACK, Camp.WHITE)).isFalse();
        Assertions.assertThat(moveDestinationChecker.isAble(Camp.BLACK, Camp.BLACK)).isFalse();
        Assertions.assertThat(moveDestinationChecker.isAble(Camp.WHITE, Camp.WHITE)).isFalse();
        Assertions.assertThat(moveDestinationChecker.isAble(Camp.WHITE, Camp.BLACK)).isFalse();
    }

    @DisplayName("진영이 없는 빈 기물이 움직임을 확인할 경우 오류를 던진다.")
    @Test
    void noneCampCanNotCheckMove() {
        final MoveDestinationChecker moveDestinationChecker = new MoveDestinationChecker();
        Assertions.assertThatThrownBy(() -> moveDestinationChecker.isAble(Camp.NONE, Camp.BLACK))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
