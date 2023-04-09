package chess.domain.path;

public class SlidingPathChecker implements PathChecker {

    SlidingPathChecker() {
    }

    @Override
    public boolean isValid(Path path) {
        return path.isClean();
    }
}
