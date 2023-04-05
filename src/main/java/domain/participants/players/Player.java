package domain.participants.players;

import domain.deck.card.Card;
import domain.participants.Participant;
import domain.participants.attributes.bettingCondition.BettingAmount;
import domain.participants.attributes.bettingCondition.BettingCondition;
import domain.participants.attributes.bettingCondition.GameResult;
import domain.participants.attributes.hand.GameCondition;
import domain.participants.attributes.hand.Hand;
import java.util.List;

public final class Player implements Participant {

    private static final int INITIAL_CARD_COUNT = 2;
    private final Hand hand;
    private final BettingCondition bettingCondition;

    public Player(final BettingAmount bettingAmount) {
        hand = Hand.empty();
        this.bettingCondition = new BettingCondition(bettingAmount);
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
        if (cards.size() < INITIAL_CARD_COUNT) {
            throw new IllegalStateException("시작 카드를 지급받지 않았습니다.");
        }
        return List.of(cards.get(0), cards.get(1));
    }

    @Override
    public boolean canGetMoreCard() {
        return hand.getGameCondition() == GameCondition.HIT;
    }

    public void updateGameResult(final GameResult gameResult) {
        bettingCondition.updateGameResult(gameResult);
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

    public int getBenefit() {
        return bettingCondition.getBenefit(hand.getGameCondition());
    }
}
