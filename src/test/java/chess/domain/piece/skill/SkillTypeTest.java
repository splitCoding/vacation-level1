package chess.domain.piece.skill;

import chess.domain.board.Square;
import chess.domain.piece.Piece;
import chess.domain.piece.PieceFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SkillTypeTest {

    @DisplayName("일반 공격 전략을 반환한다.")
    @Test
    void getNormalAttack() {
        final Square start = new Square(PieceFixture.BlackPawn);
        final Square end = new Square(PieceFixture.EMPTY);
        SkillType moveAndAttack = SkillType.MOVE_AND_ATTACK;
        moveAndAttack.getAttack().attack(start, end);
        Assertions.assertThat(end).extracting("piece").isEqualTo(PieceFixture.BlackPawn);
        Assertions.assertThat(start).extracting("piece").isEqualTo(PieceFixture.EMPTY);
    }

    @DisplayName("공격 불가한 공격 전략을 반환한다.")
    @Test
    void getInvalidAttack() {
        final Square start = new Square(PieceFixture.BlackPawn);
        final Square end = new Square(PieceFixture.EMPTY);
        Piece empty = PieceFixture.EMPTY;
        SkillType moveAndAttack = SkillType.NO_SKILL;
        Assertions.assertThatThrownBy(() -> moveAndAttack.getAttack().attack(start, end))
            .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("일반 이동 전략을 반환한다.")
    @Test
    void getNormalMove() {
        final Square start = new Square(PieceFixture.BlackPawn);
        final Square end = new Square(PieceFixture.EMPTY);
        SkillType moveAndAttack = SkillType.MOVE_AND_ATTACK;
        moveAndAttack.getMove().move(start, end);
        Assertions.assertThat(end).extracting("piece").isEqualTo(PieceFixture.BlackPawn);
        Assertions.assertThat(start).extracting("piece").isEqualTo(PieceFixture.EMPTY);
    }

    @DisplayName("이동 불가한 이동 전략을 반환한다.")
    @Test
    void getInvalidMove() {
        final Square start = new Square(PieceFixture.BlackPawn);
        final Square end = new Square(PieceFixture.EMPTY);
        SkillType moveAndAttack = SkillType.NO_SKILL;
        Assertions.assertThatThrownBy(() -> moveAndAttack.getMove().move(start, end))
            .isInstanceOf(UnsupportedOperationException.class);
    }
}
