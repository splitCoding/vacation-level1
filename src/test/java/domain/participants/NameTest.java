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

    @DisplayName("이름이 null 일 경우 오류를 반환한다.")
    @Test
    void getNameNull() {
        Assertions.assertThatThrownBy(() -> new Name(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 공백으로 이루어져 있을 경우 오류를 반환한다.")
    @Test
    void getNameBlank() {
        Assertions.assertThatThrownBy(() -> new Name("    "))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름의 값이 같으면 같은 Name객체로 판단된다.")
    @Test
    void equals() {
        final String nameValue = "split";
        final Name firstSplit = new Name(nameValue);
        final Name secondSplit = new Name(nameValue);
        Assertions.assertThat(firstSplit.equals(secondSplit)).isTrue();
    }
}
