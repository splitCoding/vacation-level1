package domain;

import domain.deck.Deck;
import domain.deck.card.Card;
import domain.participants.Dealer;
import domain.participants.Participant;
import domain.participants.Participants;
import domain.participants.players.Player;
import java.util.Arrays;
import java.util.Collections;

public class BlackjackGame {

    private final Participants participants;
    private final Deck deck;

    public BlackjackGame(Participants participants) {
        this.participants = participants;
        deck = new Deck(Arrays.asList(Card.values()), Collections::shuffle);
    }

    public void ready() {
        initialize(participants.getDealer());
        participants.getPlayers().forEach(this::initialize);
    }

    private void initialize(final Participant participant) {
        participant.drawCard(deck.draw());
        participant.drawCard(deck.draw());
    }

    public boolean isNotEnd() {
        return participants.isWaitingPlayerExist();
    }

    public Player getCurrentPlayer() {
        return participants.getCurrentPlayer();
    }

    public String getCurrentPlayerName() {
        return participants.getCurrentPlayerName();
    }

    public void playTurn(final Player player, final GetMoreCardCommand getMoreCardCommand) {
        if (getMoreCardCommand == GetMoreCardCommand.YES) {
            player.drawCard(deck.draw());
            return;
        }
        player.drawCard(null);
    }

    public boolean isDealerNeedMoreCard() {
        return participants.getDealer().canGetMoreCard();
    }

    public void dealerPlay() {
        final Dealer dealer = participants.getDealer();
        dealer.drawCard(deck.draw());
    }

    public Participants getParticipants() {
        return participants;
    }
}
