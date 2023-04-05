package controller.dto;

import domain.Judge;
import domain.participants.Participants;
import domain.participants.attributes.bettingCondition.GameResult;
import java.util.List;
import java.util.stream.Collectors;

public class GameResultsDto {

    private final List<GameResult> gameResults;
    private final long dealerWinCount;
    private final long dealerDrawCount;
    private final long dealerLoseCount;

    public GameResultsDto(final Participants participants) {
        final Judge judge = new Judge();
        judge.judgeAll(participants);
        this.gameResults = participants.getPlayers()
            .stream()
            .map(judge::getGameResultByPlayer)
            .collect(Collectors.toList());
        this.dealerWinCount = judge.getDealerWinCount();
        this.dealerDrawCount = judge.getDealerDrawCount();
        this.dealerLoseCount = judge.getDealerLoseCount();
    }

    public List<GameResult> getGameResults() {
        return gameResults;
    }

    public long getDealerWinCount() {
        return dealerWinCount;
    }

    public long getDealerDrawCount() {
        return dealerDrawCount;
    }

    public long getDealerLoseCount() {
        return dealerLoseCount;
    }
}
