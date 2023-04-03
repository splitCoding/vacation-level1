package domain.participants;

import domain.participants.attributes.GameCondition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameConditionTest {

    @DisplayName("점수에 따른 참가자의 상태를 반환한다.")
    @ParameterizedTest(name = "{0}점은 {1}이다.")
    @CsvSource(value = {
        "20:HIT",
        "21:BLACKJACK",
        "22:BUST",
    }, delimiter = ':')
    void find(int score, GameCondition expectedCondition) {
        GameCondition gameCondition = GameCondition.find(score);
        Assertions.assertThat(gameCondition).isEqualTo(expectedCondition);
    }
}
