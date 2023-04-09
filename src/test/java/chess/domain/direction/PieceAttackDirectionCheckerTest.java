package chess.domain.direction;

import chess.domain.piece.PieceType;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PieceAttackDirectionCheckerTest {

    @DisplayName("기물이 공격가능한 방향인지 체크한다.")
    @ParameterizedTest(name = "{0} 은 {1} 방향들로 공격할 수 있다. ")
    @MethodSource(value = "pieceTypeAndValidAttackDirections")
    void checkValidDirections(final PieceType pieceType, final List<Direction> attackDirections) {
        final DirectionChecker attackDirectionChecker = PieceAttackDirectionChecker.getByPieceType(pieceType);
        for (Direction attackDirection : attackDirections) {
            Assertions.assertThat(attackDirectionChecker.isValid(attackDirection)).isTrue();
        }
    }

    private static Stream<Arguments> pieceTypeAndValidAttackDirections() {
        return Stream.of(
            Arguments.arguments(PieceType.PAWN, PieceType.PAWN.getValidAttackDirections()),
            Arguments.arguments(PieceType.ROOK, PieceType.ROOK.getValidAttackDirections()),
            Arguments.arguments(PieceType.KNIGHT, PieceType.KNIGHT.getValidAttackDirections()),
            Arguments.arguments(PieceType.BISHOP, PieceType.BISHOP.getValidAttackDirections()),
            Arguments.arguments(PieceType.QUEEN, PieceType.QUEEN.getValidAttackDirections()),
            Arguments.arguments(PieceType.KING, PieceType.KING.getValidAttackDirections())
        );
    }

    @DisplayName("기물이 공격 불가능 방향일 경우 오류를 던진다.")
    @ParameterizedTest(name = "{0} 은 {1} 방향들로 공격할 수 없다. ")
    @MethodSource(value = "pieceTypeAndInValidAttackDirections")
    void checkInvalidDirections(final PieceType pieceType, final List<Direction> attackDirections) {
        final DirectionChecker attackDirectionChecker = PieceAttackDirectionChecker.getByPieceType(pieceType);
        for (Direction attackDirection : attackDirections) {
            Assertions.assertThat(attackDirectionChecker.isValid(attackDirection)).isFalse();
        }
    }

    private static Stream<Arguments> pieceTypeAndInValidAttackDirections() {
        return Stream.of(
            Arguments.arguments(PieceType.PAWN, PieceType.ROOK.getValidAttackDirections()),
            Arguments.arguments(PieceType.ROOK, PieceType.BISHOP.getValidAttackDirections()),
            Arguments.arguments(PieceType.KNIGHT, PieceType.QUEEN.getValidAttackDirections()),
            Arguments.arguments(PieceType.BISHOP, PieceType.ROOK.getValidAttackDirections()),
            Arguments.arguments(PieceType.QUEEN, PieceType.KNIGHT.getValidAttackDirections()),
            Arguments.arguments(PieceType.KING, PieceType.KNIGHT.getValidAttackDirections())
        );
    }

    @DisplayName("빈 기물의 공격방향 검증 객체를 조회시 오류를 던진다.")
    @Test
    void emptyPieceChecker() {
        Assertions.assertThatThrownBy(() -> PieceAttackDirectionChecker.getByPieceType(PieceType.EMPTY))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
