package domain.participants.attributes.bettingCondition;

import domain.participants.attributes.hand.GameCondition;

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

    public int getBenefit(final GameCondition gameCondition) {
        int benefit = gameResult.getBenefit(bettingAmount.getAmount());
        if (gameCondition == GameCondition.BLACKJACK && gameResult == GameResult.WIN) {
            benefit += benefit / 2;
        }
        return benefit;
    }
}
