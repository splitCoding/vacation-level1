package domain.participants;

import domain.deck.card.Card;
import domain.participants.attributes.GameCondition;
import domain.participants.attributes.Score;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreTest {

    @DisplayName("카드를 이용하여 Score를 생성한다.")
    @Test
    void getPlayerStatus() {
        final Score score = Score.of(List.of(Card.CLOVER_THREE, Card.CLOVER_KING));
        final int cardScore = 13;
        Assertions.assertThat(score.getScore()).isEqualTo(cardScore);
        Assertions.assertThat(score.getGameCondition()).isEqualTo(GameCondition.find(cardScore));
    }

    @DisplayName("점수가 11점 이하일 시 ACE보너스 점수를 적용한다.")
    @Test
    void getPlayerStatusContainAce() {
        final Score score = Score.of(List.of(Card.CLOVER_ACE, Card.CLOVER_KING));
        final int cardScore = 21;
        Assertions.assertThat(score.getScore()).isEqualTo(cardScore);
        Assertions.assertThat(score.getGameCondition()).isEqualTo(GameCondition.find(cardScore));
    }

    @DisplayName("점수가 11점 보다 크면 ACE보너스 점수를 적용하지 않는다.")
    @Test
    void getPlayerStatusNotContainAce() {
        final Score score = Score.of(List.of(Card.CLOVER_FIVE, Card.HEART_SEVEN, Card.SPADE_ACE));
        final int cardScore = 13;
        Assertions.assertThat(score.getScore()).isEqualTo(cardScore);
        Assertions.assertThat(score.getGameCondition()).isEqualTo(GameCondition.find(cardScore));
    }
}
