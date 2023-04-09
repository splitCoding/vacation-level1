package chess.domain.destination;

import chess.domain.piece.Camp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AttackDestinationCheckerTest {

    @DisplayName("기물은 상대진영을 공격할 수 있다.")
    @Test
    void isAble() {
        final AttackDestinationChecker attackDestinationChecker = new AttackDestinationChecker();
        Assertions.assertThat(attackDestinationChecker.isAble(Camp.BLACK, Camp.WHITE)).isTrue();
        Assertions.assertThat(attackDestinationChecker.isAble(Camp.WHITE, Camp.BLACK)).isTrue();
    }

    @DisplayName("기물은 같은 진영을 공격할 수 없다.")
    @Test
    void isDisAbleSameCamp() {
        final AttackDestinationChecker attackDestinationChecker = new AttackDestinationChecker();
        Assertions.assertThat(attackDestinationChecker.isAble(Camp.BLACK, Camp.BLACK)).isFalse();
        Assertions.assertThat(attackDestinationChecker.isAble(Camp.WHITE, Camp.WHITE)).isFalse();
    }

    @DisplayName("기물은 빈 진영을 공격할 수 없다.")
    @Test
    void isDisAbleNone() {
        final AttackDestinationChecker attackDestinationChecker = new AttackDestinationChecker();
        Assertions.assertThat(attackDestinationChecker.isAble(Camp.BLACK, Camp.NONE)).isFalse();
        Assertions.assertThat(attackDestinationChecker.isAble(Camp.WHITE, Camp.NONE)).isFalse();
    }
}
