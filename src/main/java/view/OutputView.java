package view;

import controller.dto.DealerStateDto;
import controller.dto.GameResultsDto;
import controller.dto.ParticipantsBenefitDto;
import controller.dto.PlayersStateDto;
import domain.deck.card.Card;
import domain.participants.attributes.bettingCondition.GameResult;
import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import view.converter.DenominationViewConverter;
import view.converter.GameResultViewConverter;
import view.converter.SuitViewConverter;

public final class OutputView {

    private static final String AND = ", ";
    private final StringBuilder stringBuilder;

    public OutputView() {
        this.stringBuilder = new StringBuilder();
    }

    public void printParticipantsInitializeCard(final DealerStateDto dealer, final PlayersStateDto players) {
        final String dealerName = dealer.getName();
        final List<String> playerNames = players.getNames();
        final List<List<Card>> playersHand = players.getInitializeCards();

        addInitializedMessage(dealerName, playerNames);

        addFormattedNameAndCards(dealerName, dealer.getInitializeCards());
        IntStream.range(0, playerNames.size())
            .forEachOrdered((index) -> addFormattedNameAndCards(playerNames.get(index), playersHand.get(index)));
        consumeStringBuilder();
    }

    private void addInitializedMessage(final String dealerName, final List<String> playerNames) {
        final String message = String.format(
            "%s와 %s에게 2장을 나누었습니다.\n",
            dealerName,
            String.join(AND, playerNames)
        );
        stringBuilder.append(message);
    }

    private void addFormattedNameAndCards(final String participantName, final List<Card> cards) {
        final String cardContents = cards.stream()
            .map(this::formatCard)
            .collect(Collectors.joining(AND));
        final String formattedNameCards = String.format(
            "%s: %s\n",
            participantName,
            cardContents
        );
        stringBuilder.append(formattedNameCards);
    }

    private void consumeStringBuilder() {
        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
    }

    public void printFormattedNameAndCards(final String participantName, final List<Card> cards) {
        addFormattedNameAndCards(participantName, cards);
        consumeStringBuilder();
    }

    private String formatCard(Card card) {
        return String.format(
            "%s%s",
            DenominationViewConverter.convert(card.getDenomination()),
            SuitViewConverter.convert(card.getSuit())
        );
    }

    public void printFinalParticipantsCondition(final DealerStateDto dealer, final PlayersStateDto players) {
        final List<String> playerNames = players.getNames();
        final List<List<Card>> playersHand = players.getHands();
        final List<Integer> playersScore = players.getScores();

        addFormattedNameAndCardsAndScore(dealer.getName(), dealer.getHand(), dealer.getScore());
        for (int index = 0; index < playerNames.size(); index++) {
            addFormattedNameAndCardsAndScore(playerNames.get(index), playersHand.get(index), playersScore.get(index));
        }
        consumeStringBuilder();
    }

    private void addFormattedNameAndCardsAndScore(
        final String name,
        final List<Card> cards,
        final int score
    ) {
        final String cardContents = cards.stream()
            .map(this::formatCard)
            .collect(Collectors.joining(AND));
        final String formattedContent = String.format(
            "%s: %s - 결과: %d\n",
            name,
            cardContents,
            score
        );
        stringBuilder.append(formattedContent);
    }

    public void printDealerGetCardMessage() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public void printFinalGameOutcome(
        final DealerStateDto dealer,
        final PlayersStateDto players,
        final GameResultsDto gameResultsDto
    ) {
        stringBuilder.append("## 최종 승패")
            .append(System.lineSeparator());
        addFormattedDealerNameAndGameResult(dealer.getName(), gameResultsDto);
        final List<GameResult> gameResults = gameResultsDto.getGameResults();
        final List<String> names = players.getNames();
        for (int index = 0; index < names.size(); index++) {
            addFormattedPlayerNameAndGameResult(names.get(index), gameResults.get(index));
        }
        consumeStringBuilder();
    }

    private void addFormattedDealerNameAndGameResult(final String dealerName, final GameResultsDto gameResultsDto) {
        final String formattedName = String.format("%s: ", dealerName);
        final String formattedGameResult = MessageFormat.format(
            "{0}{1}{2}\n",
            addFormattedDealerGameResult(gameResultsDto.getDealerWinCount(), GameResult.WIN),
            addFormattedDealerGameResult(gameResultsDto.getDealerDrawCount(), GameResult.DRAW),
            addFormattedDealerGameResult(gameResultsDto.getDealerLoseCount(), GameResult.LOSE)
        );
        stringBuilder.append(formattedName)
            .append(formattedGameResult);
    }

    private String addFormattedDealerGameResult(final long count, final GameResult gameResult) {
        if (count > 0) {
            return String.format(
                "%d%s ",
                count,
                GameResultViewConverter.convert(gameResult)
            );
        }
        return "";
    }

    private void addFormattedPlayerNameAndGameResult(final String playerName, final GameResult gameResult) {
        final String formattedNameAndGameResult = String.format(
            "%s: %s\n",
            playerName,
            GameResultViewConverter.convert(gameResult)
        );
        stringBuilder.append(formattedNameAndGameResult);
    }

    public void printFinalBenefitOutcome(
        final DealerStateDto dealer,
        final PlayersStateDto players,
        final ParticipantsBenefitDto benefits
    ) {
        final List<String> names = players.getNames();
        final List<Integer> playersBenefit = benefits.getPlayersBenefit();

        stringBuilder.append("## 최종 수익")
            .append(System.lineSeparator());
        addFormattedNameAndBenefit(dealer.getName(), benefits.getDealerBenefit());
        for (int index = 0; index < names.size(); index++) {
            addFormattedNameAndBenefit(names.get(index), playersBenefit.get(index));
        }
        consumeStringBuilder();
    }

    private void addFormattedNameAndBenefit(final String name, final int benefit) {
        final String formattedNameAndBenefit = String.format(
            "%s: %d\n",
            name,
            benefit
        );
        stringBuilder.append(formattedNameAndBenefit);
    }
}
