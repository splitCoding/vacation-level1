package domain.deck.card;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CardTest {

    @DisplayName("자신의 끝수와 문양을 반환한다.")
    @Test
    void test() {
        Card cloverAce = Card.CLOVER_ACE;
        Assertions.assertThat(cloverAce.getDenomination()).isEqualTo(Denomination.ACE);
        Assertions.assertThat(cloverAce.getSuit()).isEqualTo(Suit.CLOVER);
    }

    @DisplayName("끝수는 자신에 해당되는 점수를 반환한다.")
    @ParameterizedTest(name = "{0}는 {1}점이다.")
    @CsvSource(value = {
        "ACE:1",
        "TWO:2",
        "THREE:3",
        "FOUR:4",
        "FIVE:5",
        "SIX:6",
        "SEVEN:7",
        "EIGHT:8",
        "NINE:9",
        "TEN:10",
        "JACK:10",
        "QUEEN:10",
        "KING:10",
    }, delimiter = ':')
    void getScore(Denomination denomination, int score) {
        int expectScore = denomination.getScore();
        Assertions.assertThat(expectScore).isEqualTo(score);
    }

    @DisplayName("카드가 ACE인지 반환한다.")
    @ParameterizedTest(name = "{0}가 에이스인지 확인시 {1}를 반환한다.")
    @CsvSource(value = {
        "CLOVER_ACE:true",
        "CLOVER_TWO:false"
    }, delimiter = ':')
    void isAce(Card card, boolean expectIsAce) {
        Assertions.assertThat(Card.isAce(card)).isEqualTo(expectIsAce);
    }
}
