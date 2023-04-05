package view.converter;

import domain.participants.attributes.bettingCondition.GameResult;

public enum GameResultViewConverter {
    WIN("승"),
    DRAW("무"),
    LOSE("패");

    private final String content;

    GameResultViewConverter(final String content) {
        this.content = content;
    }

    public static String convert(final GameResult gameResult) {
        if (gameResult == GameResult.PLAYING) {
            throw new IllegalArgumentException("플레이어가 아직 플레이 중입니다.");
        }
        return valueOf(gameResult.name()).content;
    }
}
