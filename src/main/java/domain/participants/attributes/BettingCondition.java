package domain.participants.attributes;

public final class BettingCondition {

    private final BettingAmount bettingAmount;

    private GameResult gameResult;

    public BettingCondition(final BettingAmount bettingAmount) {
        this.bettingAmount = bettingAmount;
        gameResult = GameResult.PLAYING;
    }

    public void updateGameResult(final GameResult gameResult) {
        if (gameResult == GameResult.PLAYING) {
            throw new IllegalArgumentException("승무패 중 하나로 업데이트 해야 합니다.");
        }
        if (this.gameResult != GameResult.PLAYING) {
            throw new IllegalArgumentException("이미 승패가 결정났습니다.");
        }
        this.gameResult = gameResult;
    }

    public int getBenefit() {
        return gameResult.getBenefit(bettingAmount.getAmount());
    }
}
