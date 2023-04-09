package chess.domain.path;

public class JumpingPathChecker implements PathChecker {

    JumpingPathChecker() {
    }

    @Override
    public boolean isValid(Path path) {
        return path.getMoveCount() == 1;
    }
}
