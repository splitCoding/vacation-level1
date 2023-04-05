package controller;

import controller.dto.DealerStateDto;
import controller.dto.GameResultsDto;
import controller.dto.ParticipantsBenefitDto;
import controller.dto.PlayersStateDto;
import domain.BlackjackGame;
import domain.participants.Participants;
import domain.participants.attributes.Name;
import domain.participants.attributes.Names;
import domain.participants.attributes.bettingCondition.BettingAmount;
import domain.participants.players.Player;
import domain.participants.players.Players;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import view.InputView;
import view.OutputView;
import view.converter.GetCardCommandConverter;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final BlackjackGame blackjackGame;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        blackjackGame = makeBlackjackGame();
    }

    private BlackjackGame makeBlackjackGame() {
        final Names names = makeNames();
        final List<Name> playerNames = names.getNames();
        final List<Player> players = playerNames.stream()
            .map(this::makePlayer)
            .collect(Collectors.toList());
        return new BlackjackGame(new Participants(Players.of(playerNames, players)));
    }

    private Names makeNames() {
        final String playerNamesInput = inputView.getPlayerNames();
        final List<String> playerNameValues = Arrays.asList(playerNamesInput.split(",", -1));
        return new Names(
            playerNameValues.stream()
                .map(Name::new)
                .collect(Collectors.toList())
        );
    }

    private Player makePlayer(final Name name) {
        final String bettingAmount = inputView.getBettingAmount(name.getName());
        return new Player(BettingAmount.of(bettingAmount));
    }

    public void initialize() {
        blackjackGame.ready();
        final Participants participants = blackjackGame.getParticipants();
        outputView.printParticipantsInitializeCard(
            new DealerStateDto(participants),
            new PlayersStateDto(participants)
        );
    }

    public void play() {
        while (blackjackGame.isNotEnd()) {
            final Player currentPlayer = blackjackGame.getCurrentPlayer();
            final String currentPlayerName = blackjackGame.getCurrentPlayerName();
            final String getMoreCard = inputView.printPlayerGetMoreCardMessage(currentPlayerName);
            blackjackGame.playTurn(currentPlayer, GetCardCommandConverter.convert(getMoreCard));
            outputView.printFormattedNameAndCards(currentPlayerName, currentPlayer.getHand());
        }
        while (blackjackGame.isDealerNeedMoreCard()) {
            outputView.printDealerGetCardMessage();
            blackjackGame.dealerPlay();
        }
    }

    public void showResult() {
        final Participants participants = blackjackGame.getParticipants();
        final DealerStateDto dealer = new DealerStateDto(participants);
        final PlayersStateDto players = new PlayersStateDto(participants);
        outputView.printFinalParticipantsCondition(dealer, players);
        outputView.printFinalGameOutcome(dealer, players, new GameResultsDto(participants));
        outputView.printFinalBenefitOutcome(dealer, players, new ParticipantsBenefitDto(participants));
    }
}
