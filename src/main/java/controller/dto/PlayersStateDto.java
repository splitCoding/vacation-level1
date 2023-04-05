package controller.dto;

import domain.deck.card.Card;
import domain.participants.Participants;
import java.util.ArrayList;
import java.util.List;

public class PlayersStateDto {

    private final List<String> playerNames;
    private final List<List<Card>> playersHand;
    private final List<List<Card>> playersInitializeCards;
    private final List<Integer> playersScore;

    public PlayersStateDto(final Participants participants) {
        this.playerNames = new ArrayList<>(participants.getPlayerNames());
        this.playersHand = new ArrayList<>(participants.getPlayersHand());
        this.playersInitializeCards = new ArrayList<>(participants.getPlayersInitializeCards());
        this.playersScore = participants.getPlayersScore();
    }

    public List<String> getNames() {
        return playerNames;
    }

    public List<List<Card>> getHands() {
        return List.copyOf(playersHand);
    }

    public List<Integer> getScores() {
        return playersScore;
    }

    public List<List<Card>> getInitializeCards() {
        return List.copyOf(playersInitializeCards);
    }
}
