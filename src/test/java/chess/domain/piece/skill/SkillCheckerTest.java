package chess.domain.piece.skill;

import chess.domain.path.Path;
import chess.domain.piece.Piece;
import chess.domain.piece.PieceFixture;
import chess.domain.piece.PieceType;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SkillCheckerTest {

    @DisplayName("폰의 이동, 공격이 가능한 상태인지 확인한다.")
    @Nested
    class Pawn {

        @DisplayName("폰이 공격 할 수 있는지 체크한다.(공격 가능)")
        @Test
        void canAttack() {
            final SkillChecker pawnSkillChecker = PieceType.PAWN.getSkill().getSkillChecker();
            final Piece blackPawn = PieceFixture.BlackPawn;
            final Path path = new Path(List.of(PieceFixture.WhitePawn));
            Assertions.assertThat(pawnSkillChecker.isAttackReady(blackPawn.getCamp(), path))
                .isTrue();
        }

        @DisplayName("폰이 공격 할 수 있는지 체크한다. (공격 불가능)")
        @Test
        void canNotAttack() {
            final SkillChecker pawnSkillChecker = PieceType.PAWN.getSkill().getSkillChecker();
            final Piece blackPawn = PieceFixture.BlackPawn;
            final Path path = new Path(List.of(PieceFixture.EMPTY));
            Assertions.assertThat(pawnSkillChecker.isAttackReady(blackPawn.getCamp(), path))
                .isFalse();
        }

        @DisplayName("폰이 이동 할 수 있는지 체크한다.(이동 가능)")
        @Test
        void canMove() {
            final SkillChecker pawnSkillChecker = PieceType.PAWN.getSkill().getSkillChecker();
            final Piece blackPawn = PieceFixture.BlackPawn;
            final Path path = new Path(List.of(PieceFixture.WhitePawn));
            Assertions.assertThat(pawnSkillChecker.isMoveReady(blackPawn.getCamp(), path))
                .isFalse();
        }

        @DisplayName("폰이 이동 할 수 있는지 체크한다. (이동 불가능)")
        @Test
        void canNotMove() {
            final SkillChecker pawnSkillChecker = PieceType.PAWN.getSkill().getSkillChecker();
            final Piece blackPawn = PieceFixture.BlackPawn;
            final Path path = new Path(List.of(PieceFixture.EMPTY));
            Assertions.assertThat(pawnSkillChecker.isMoveReady(blackPawn.getCamp(), path))
                .isTrue();
        }
    }
}
