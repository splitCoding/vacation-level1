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

class PieceMoveDirectionCheckerTest {

    @DisplayName("기물이 이동 가능한 방향인지 체크한다.")
    @ParameterizedTest(name = "{0} 은 {1} 방향들로 이동할 수 있다. ")
    @MethodSource(value = "pieceTypeAndValidAttackDirections")
    void checkValidDirections(final PieceType pieceType, final List<Direction> moveDirection) {
        final DirectionChecker moveDirectionChecker = PieceMoveDirectionChecker.getByPieceType(pieceType);
        for (Direction attackDirection : moveDirection) {
            Assertions.assertThat(moveDirectionChecker.isValid(attackDirection)).isTrue();
        }
    }

    private static Stream<Arguments> pieceTypeAndValidAttackDirections() {
        return Stream.of(
            Arguments.arguments(PieceType.PAWN, PieceType.PAWN.getValidMoveDirections()),
            Arguments.arguments(PieceType.ROOK, PieceType.ROOK.getValidMoveDirections()),
            Arguments.arguments(PieceType.KNIGHT, PieceType.KNIGHT.getValidMoveDirections()),
            Arguments.arguments(PieceType.BISHOP, PieceType.BISHOP.getValidMoveDirections()),
            Arguments.arguments(PieceType.QUEEN, PieceType.QUEEN.getValidMoveDirections()),
            Arguments.arguments(PieceType.KING, PieceType.KING.getValidMoveDirections())
        );
    }

    @DisplayName("기물이 이동 불가능 방향일 경우 오류를 던진다.")
    @ParameterizedTest(name = "{0} 은 {1} 방향들로 이동할 수 없다. ")
    @MethodSource(value = "pieceTypeAndInValidAttackDirections")
    void checkInvalidDirections(final PieceType pieceType, final List<Direction> moveDirection) {
        final DirectionChecker moveDirectionChecker = PieceMoveDirectionChecker.getByPieceType(pieceType);
        for (Direction attackDirection : moveDirection) {
            Assertions.assertThat(moveDirectionChecker.isValid(attackDirection)).isFalse();
        }
    }

    private static Stream<Arguments> pieceTypeAndInValidAttackDirections() {
        return Stream.of(
            Arguments.arguments(PieceType.PAWN, PieceType.BISHOP.getValidMoveDirections()),
            Arguments.arguments(PieceType.ROOK, PieceType.BISHOP.getValidMoveDirections()),
            Arguments.arguments(PieceType.KNIGHT, PieceType.QUEEN.getValidMoveDirections()),
            Arguments.arguments(PieceType.BISHOP, PieceType.ROOK.getValidMoveDirections()),
            Arguments.arguments(PieceType.QUEEN, PieceType.KNIGHT.getValidMoveDirections()),
            Arguments.arguments(PieceType.KING, PieceType.KNIGHT.getValidMoveDirections())
        );
    }

    @DisplayName("빈 기물의 이동방향 검증 객체를 조회시 오류를 던진다.")
    @Test
    void emptyPieceChecker() {
        Assertions.assertThatThrownBy(() -> PieceMoveDirectionChecker.getByPieceType(PieceType.EMPTY))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
