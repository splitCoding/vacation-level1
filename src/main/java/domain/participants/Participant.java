package domain.participants;

import domain.deck.card.Card;
import java.util.List;

public interface Participant {

    void drawCard(Card card);

    List<Card> showInitialCards();

    boolean canGetMoreCard();
}
