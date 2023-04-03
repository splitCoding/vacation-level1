package domain.participants;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayerStatusTest {

    @DisplayName("점수에 따른 참가자의 상태를 반환한다.")
    @ParameterizedTest(name = "{0}점은 {1}이다.")
    @CsvSource(value = {
        "20:HIT",
        "21:BLACKJACK",
        "22:BUST",
    }, delimiter = ':')
    void find(int score, PlayerStatus expectedStatus) {
        PlayerStatus playerStatus = PlayerStatus.find(score);
        Assertions.assertThat(playerStatus).isEqualTo(expectedStatus);
    }
}
