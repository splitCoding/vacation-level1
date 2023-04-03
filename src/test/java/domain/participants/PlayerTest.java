package domain.participants;

import domain.deck.card.Card;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("플레이어가 카드를 지급 받는다.")
    @Test
    void drawCard() {
        Player player = new Player();
        player.drawCard(Card.CLOVER_ACE);
        Assertions.assertThat(player.getHand()).containsExactly(Card.CLOVER_ACE);
        Assertions.assertThat(player.getScore()).isEqualTo(11);
    }
}
