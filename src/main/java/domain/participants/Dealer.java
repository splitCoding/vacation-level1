package domain.participants;

import domain.deck.card.Card;
import domain.participants.attributes.hand.GameCondition;
import domain.participants.attributes.hand.Hand;
import java.util.List;

public final class Dealer implements Participant {

    private static final int INITIAL_CARD_COUNT = 2;
    private static final int DEALER_THRESHOLDS = 17;
    private final Hand hand;

    public Dealer() {
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
        final List<Card> cards = getHand();
        if (cards.size() < INITIAL_CARD_COUNT) {
            throw new IllegalStateException("시작 카드를 지급받지 않았습니다.");
        }
        return List.of(cards.get(0));
    }

    @Override
    public boolean canGetMoreCard() {
        return getScore() < DEALER_THRESHOLDS;
    }

    public List<Card> getHand() {
        return hand.getCards();
    }

    public int getScore() {
        return hand.getScore();
    }

    public GameCondition getGameCondition() {
        return hand.getGameCondition();
    }
}
