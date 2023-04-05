package controller.dto;

import domain.deck.card.Card;
import domain.participants.Participants;
import java.util.ArrayList;
import java.util.List;

public class DealerStateDto {

    private final String dealerName;
    private final List<Card> dealerHand;
    private final List<Card> initializeCards;
    private final int dealerScore;

    public DealerStateDto(final Participants participants) {
        this.dealerName = participants.getDealerName();
        this.dealerHand = new ArrayList<>(participants.getDealerHand());
        this.initializeCards = new ArrayList<>(participants.getDealerInitializeCards());
        this.dealerScore = participants.getDealerScore();
    }

    public String getName() {
        return dealerName;
    }

    public List<Card> getHand() {
        return List.copyOf(dealerHand);
    }

    public List<Card> getInitializeCards() {
        return List.copyOf(initializeCards);
    }

    public int getScore() {
        return dealerScore;
    }
}
