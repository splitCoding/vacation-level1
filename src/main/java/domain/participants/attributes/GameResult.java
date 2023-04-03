package domain.participants.attributes;

import java.util.function.Function;

public enum GameResult {
    PLAYING((bettingAmount) -> {
        throw new IllegalStateException("아직 플레이 중입니다.");
    }),
    WIN((bettingAmount) -> bettingAmount),
    DRAW((bettingAmount) -> 0),
    LOSE((bettingAmount) -> bettingAmount * -1);

    private final Function<Integer, Integer> calculateBenefit;

    GameResult(Function<Integer, Integer> calculateBenefit) {
        this.calculateBenefit = calculateBenefit;
    }

    public final int getBenefit(int bettingAmount) {
        return calculateBenefit.apply(bettingAmount);
    }
}
