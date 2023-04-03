package domain.participants;

import domain.participants.attributes.Name;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @DisplayName("딜러의 이름은 딜러로 고정되어 있다.")
    @Test
    void getDealerName() {
        final Name dealer = Name.dealer();
        Assertions.assertThat(dealer.getName()).isEqualTo("딜러");
    }

    @DisplayName("이름을 문자열로 반환한다.")
    @Test
    void getName() {
        final String nameValue = "split";
        final Name name = new Name(nameValue);
        Assertions.assertThat(name.getName()).isEqualTo(nameValue);
    }
}
