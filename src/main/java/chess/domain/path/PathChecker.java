package chess.domain.path;

public interface PathChecker {

    boolean isValid(final Path path);

    static PathChecker jumpChecker() {
        return new JumpingPathChecker();
    }

    static PathChecker slideChecker() {
        return new SlidingPathChecker();
    }
}
