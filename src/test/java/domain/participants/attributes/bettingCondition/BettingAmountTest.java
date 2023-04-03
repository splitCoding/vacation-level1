package domain.participants.attributes.bettingCondition;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BettingAmountTest {

    @DisplayName("배팅금액이 1000원보다 작을 경우 오류를 던진다.")
    @Test
    void bettingAmountUnderThousand() {
        Assertions.assertThatThrownBy(() -> BettingAmount.of(999))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("배팅금액이 1000원 단위가 아닐 경우 오류를 던진다.")
    @Test
    void bettingAmountCanNotDivideByThousand() {
        Assertions.assertThatThrownBy(() -> BettingAmount.of(1001))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("배팅금액을 조회한다.")
    @Test
    void getAmount() {
        final int amount = 3000;
        BettingAmount bettingAmount = BettingAmount.of(amount);
        Assertions.assertThat(bettingAmount.getAmount()).isEqualTo(amount);
    }
}
