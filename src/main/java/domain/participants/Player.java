package domain.participants;

import domain.deck.card.Card;
import java.util.List;

public class Player implements Participant {

    private final Hand hand;

    public Player() {
        hand = Hand.empty();
    }

    @Override
    public void drawCard(final Card card) {
        if (canGetMoreCard()) {
            hand.addCard(card);
            return;
        }
        throw new IllegalStateException("카드를 더이상 받을 수 없습니다.");
    }

    @Override
    public List<Card> showInitialCards() {
        final List<Card> cards = hand.getCards();
        if (cards.size() < 2) {
            throw new IllegalStateException("시작 카드를 지급받지 않았습니다.");
        }
        return List.of(cards.get(0), cards.get(1));
    }

    @Override
    public boolean canGetMoreCard() {
        return hand.getStatus() == PlayerStatus.HIT;
    }
    
    public List<Card> getHand() {
        return hand.getCards();
    }

    public int getScore() {
        return hand.getScore();
    }
}
