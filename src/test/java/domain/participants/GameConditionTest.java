package domain.participants;

import domain.participants.attributes.GameCondition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameConditionTest {

    @DisplayName("점수와 카드 갯수에 따른 참가자의 상태를 반환한다.")
    @ParameterizedTest(name = "{1} 개의 카드로 {0} 점일 떄 참가자의 상태는 {2}이다.")
    @CsvSource(value = {
        "20:2:HIT",
        "21:2:BLACKJACK",
        "21:3:HIT",
        "22:2:BUST",
    }, delimiter = ':')
    void find(int score, int cardCount, GameCondition expectedCondition) {
        GameCondition gameCondition = GameCondition.find(score, cardCount);
        Assertions.assertThat(gameCondition).isEqualTo(expectedCondition);
    }
}
