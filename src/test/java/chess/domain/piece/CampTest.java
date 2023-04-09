package chess.domain.piece;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CampTest {

    @DisplayName("적 진영인지 반환한다. (적 진영일 떄)")
    @Test
    void isEnemy() {
        Assertions.assertThat(Camp.BLACK.isEnemy(Camp.WHITE)).isTrue();
        Assertions.assertThat(Camp.WHITE.isEnemy(Camp.BLACK)).isTrue();
    }

    @DisplayName("적 진영인지 반환한다. (적 진영이 아닐 떄)")
    @Test
    void isNotEnemy() {
        Assertions.assertThat(Camp.BLACK.isEnemy(Camp.BLACK)).isFalse();
        Assertions.assertThat(Camp.WHITE.isEnemy(Camp.NONE)).isFalse();
    }
}
