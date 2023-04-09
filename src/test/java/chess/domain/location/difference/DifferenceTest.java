package chess.domain.location.difference;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DifferenceTest {

    @DisplayName("같은 차이를 가진지 확인한다")
    @Test
    void isSame() {
        final Difference difference = new Difference(4);
        final Difference compare = new Difference(4);
        Assertions.assertThat(difference.isSame(compare)).isTrue();
    }

    @DisplayName("차이의 값이 더 큰지 확인한다")
    @Test
    void isBiggerThan() {
        final Difference difference = new Difference(4);
        final Difference compare = new Difference(1);
        Assertions.assertThat(difference.isBiggerThan(compare)).isTrue();
    }

    @DisplayName("차이의 값이 더 작은지 확인한다.")
    @Test
    void isLowerThan() {
        final Difference difference = new Difference(1);
        final Difference compare = new Difference(4);
        Assertions.assertThat(difference.isLowerThan(compare)).isTrue();
    }

    @DisplayName("차이의 절대값이 같은지 확인한다.")
    @Test
    void hasSameAbsoluteDifference() {
        final Difference difference = new Difference(4);
        final Difference compare = new Difference(4);
        Assertions.assertThat(difference.hasSameAbsoluteDifference(compare)).isTrue();
    }
}
