package chess.domain.direction;

import chess.domain.location.Column;
import chess.domain.location.Location;
import chess.domain.location.LocationFixture;
import chess.domain.location.Row;
import chess.domain.location.difference.LocationDifference;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DirectionTest {

    @DisplayName("위치의 차이를 통해 방향을 찾아 반환한다.")
    @ParameterizedTest(name = "{0}일 때 {1}를 반환한다.")
    @MethodSource("locationDifferencesAndDirection")
    void find(final LocationDifference difference, final Direction direction) {
        Assertions.assertThat(Direction.find(difference)).isEqualTo(direction);
    }

    static Stream<Arguments> locationDifferencesAndDirection() {
        return Stream.of(
            Arguments.arguments(
                new LocationDifference(LocationFixture.CENTER, LocationFixture.UP), Direction.UP
            ),
            Arguments.arguments(
                new LocationDifference(LocationFixture.CENTER, LocationFixture.DOWN), Direction.DOWN
            ),
            Arguments.arguments(
                new LocationDifference(LocationFixture.CENTER, LocationFixture.RIGHT), Direction.RIGHT
            ),
            Arguments.arguments(
                new LocationDifference(LocationFixture.CENTER, LocationFixture.LEFT), Direction.LEFT
            ),
            Arguments.arguments(
                new LocationDifference(LocationFixture.CENTER, LocationFixture.UP_RIGHT), Direction.UP_RIGHT
            ),
            Arguments.arguments(
                new LocationDifference(LocationFixture.CENTER, LocationFixture.UP_LEFT), Direction.UP_LEFT
            ),
            Arguments.arguments(
                new LocationDifference(LocationFixture.CENTER, LocationFixture.DOWN_RIGHT), Direction.DOWN_RIGHT
            ),
            Arguments.arguments(
                new LocationDifference(LocationFixture.CENTER, LocationFixture.DOWN_LEFT), Direction.DOWN_LEFT
            )
        );
    }

    @DisplayName("위치의 차이에 해당하는 방향이 없는 경우 오류를 던진다.")
    @Test
    void notValidDirection() {
        final Location start = new Location(Row.valueOf(3), Column.valueOf(3));
        final Location end = new Location(Row.valueOf(6), Column.valueOf(4));
        Assertions.assertThatThrownBy(() -> Direction.find(new LocationDifference(start, end)))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
