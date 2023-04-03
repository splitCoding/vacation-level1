package domain;

import domain.deck.Deck;
import domain.deck.card.Card;
import domain.participants.Dealer;
import domain.participants.Participant;
import domain.participants.Participants;
import domain.participants.Player;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    public boolean isWaitingPlayerExist() {
        return participants.getPlayers()
            .stream()
            .anyMatch(Player::canGetMoreCard);
    }

    public Player getCurrentPlayer() {
        final List<Player> players = participants.getPlayers();
        return players.stream()
            .filter(Player::canGetMoreCard)
            .findFirst()
            .orElseThrow(() -> new IllegalStateException("더 이상 게임을 진행할 플레이어가 없습니다."));
    }

    public void playTurn(final Player player, final boolean getMoreCard) {
        if (getMoreCard) {
            player.drawCard(deck.draw());
            return;
        }
        player.drawCard(null);
    }

    public void dealerPlay() {
        final Dealer dealer = participants.getDealer();
        while (dealer.canGetMoreCard()) {
            dealer.drawCard(deck.draw());
        }
    }

    public int getDealerScore() {
        return participants.getDealer().getScore();
    }
}
