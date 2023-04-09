package chess.domain.location;

import chess.domain.location.difference.LocationDifference;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LocationComparatorTest {

    @DisplayName("두 로케이션의 방향이 위쪽인지 확인한다.")
    @Test
    void isPointingUp() {
        final boolean isPointingUp = LocationComparator.isPointingUp(
            new LocationDifference(LocationFixture.CENTER, LocationFixture.UP)
        );
        Assertions.assertThat(isPointingUp).isTrue();
    }

    @DisplayName("두 로케이션의 방향이 아래인지 확인한다.")
    @Test
    void isPointingDown() {
        final boolean isPointingDown = LocationComparator.isPointingDown(
            new LocationDifference(LocationFixture.CENTER, LocationFixture.DOWN)
        );
        Assertions.assertThat(isPointingDown).isTrue();
    }

    @DisplayName("두 로케이션의 방향이 왼쪽인지 확인한다.")
    @Test
    void isPointingLeft() {
        final boolean isPointingLeft = LocationComparator.isPointingLeft(
            new LocationDifference(LocationFixture.CENTER, LocationFixture.LEFT)
        );
        Assertions.assertThat(isPointingLeft).isTrue();
    }

    @DisplayName("두 로케이션의 방향이 오른쪽인지 확인한다.")
    @Test
    void isPointingRight() {
        final boolean isPointingRight = LocationComparator.isPointingRight(
            new LocationDifference(LocationFixture.CENTER, LocationFixture.RIGHT)
        );
        Assertions.assertThat(isPointingRight).isTrue();
    }

    @DisplayName("두 로케이션의 방향이 오른쪽 위인지 확인한다.")
    @Test
    void isPointingUpRight() {
        final boolean isPointingUpRight = LocationComparator.isPointingUpRight(
            new LocationDifference(LocationFixture.CENTER, LocationFixture.UP_RIGHT)
        );
        Assertions.assertThat(isPointingUpRight).isTrue();
    }

    @DisplayName("두 로케이션의 방향이 왼쪽 위인지 확인한다.")
    @Test
    void isPointingUpLeft() {
        final boolean isPointingUpLeft = LocationComparator.isPointingUpLeft(
            new LocationDifference(LocationFixture.CENTER, LocationFixture.UP_LEFT)
        );
        Assertions.assertThat(isPointingUpLeft).isTrue();
    }

    @DisplayName("두 로케이션의 방향이 오른쪽 아래인지 확인한다.")
    @Test
    void isPointingDownRight() {
        final boolean isPointingDownRight = LocationComparator.isPointingDownRight(
            new LocationDifference(LocationFixture.CENTER, LocationFixture.DOWN_RIGHT)
        );
        Assertions.assertThat(isPointingDownRight).isTrue();
    }

    @DisplayName("두 로케이션의 방향이 왼쪽 아래인지 확인한다.")
    @Test
    void isPointingDownLeft() {
        final boolean isPointingDownLeft = LocationComparator.isPointingDownLeft(
            new LocationDifference(LocationFixture.CENTER, LocationFixture.DOWN_LEFT)
        );
        Assertions.assertThat(isPointingDownLeft).isTrue();
    }

    @DisplayName("두 로케이션의 방향이 2칸 위 1칸 왼쪽인지 확인한다.")
    @Test
    void isPointingUpUpLeft() {
        final boolean isPointingUpUpLeft = LocationComparator.isPointingUpUpLeft(
            new LocationDifference(LocationFixture.CENTER, LocationFixture.UP_UP_LEFT)
        );
        Assertions.assertThat(isPointingUpUpLeft).isTrue();
    }

    @DisplayName("두 로케이션의 방향이 2칸 위 1칸 오른쪽인지 확인한다.")
    @Test
    void isPointingUpUpRight() {
        final boolean isPointingUpUpRight = LocationComparator.isPointingUpUpRight(
            new LocationDifference(LocationFixture.CENTER, LocationFixture.UP_UP_RIGHT)
        );
        Assertions.assertThat(isPointingUpUpRight).isTrue();
    }

    @DisplayName("두 로케이션의 방향이 2칸 아래 1칸 왼쪽인지 확인한다.")
    @Test
    void isPointingDownDownLeft() {
        final boolean isPointingDownDownLeft = LocationComparator.isPointingDownDownLeft(
            new LocationDifference(LocationFixture.CENTER, LocationFixture.DOWN_DOWN_LEFT)
        );
        Assertions.assertThat(isPointingDownDownLeft).isTrue();
    }

    @DisplayName("두 로케이션의 방향이 2칸 아래 1칸 오른쪽 확인한다.")
    @Test
    void isPointingDownDownRight() {
        final boolean isPointingDownDownRight = LocationComparator.isPointingDownDownRight(
            new LocationDifference(LocationFixture.CENTER, LocationFixture.DOWN_DOWN_RIGHT)
        );
        Assertions.assertThat(isPointingDownDownRight).isTrue();
    }

    @DisplayName("두 로케이션의 방향이 2칸 왼쪽 1칸 위인지 확인한다.")
    @Test
    void isPointingLeftLeftUp() {
        final boolean isPointingLeftLeftUp = LocationComparator.isPointingLeftLeftUp(
            new LocationDifference(LocationFixture.CENTER, LocationFixture.LEFT_LEFT_UP)
        );
        Assertions.assertThat(isPointingLeftLeftUp).isTrue();
    }

    @DisplayName("두 로케이션의 방향이 2칸 왼쪽 1칸 아래인지 확인한다.")
    @Test
    void isPointingLeftLeftDown() {
        final boolean isPointingLeftLeftDown = LocationComparator.isPointingLeftLeftDown(
            new LocationDifference(LocationFixture.CENTER, LocationFixture.LEFT_LEFT_DOWN)
        );
        Assertions.assertThat(isPointingLeftLeftDown).isTrue();
    }

    @DisplayName("두 로케이션의 방향이 2칸 오른쪽 1칸 위인지 확인한다.")
    @Test
    void isPointingRightRightUp() {
        final boolean isPointingRightRightUp = LocationComparator.isPointingRightRightUp(
            new LocationDifference(LocationFixture.CENTER, LocationFixture.RIGHT_RIGHT_UP)
        );
        Assertions.assertThat(isPointingRightRightUp).isTrue();
    }

    @DisplayName("두 로케이션의 방향이 2칸 오른쪽 1칸 아래인지 확인한다.")
    @Test
    void isPointingRightRightDown() {
        final boolean isPointingRightRightDown = LocationComparator.isPointingRightRightDown(
            new LocationDifference(LocationFixture.CENTER, LocationFixture.RIGHT_RIGHT_DOWN)
        );
        Assertions.assertThat(isPointingRightRightDown).isTrue();
    }
}
