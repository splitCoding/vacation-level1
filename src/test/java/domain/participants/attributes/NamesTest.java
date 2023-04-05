package domain.participants.attributes;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NamesTest {

    @DisplayName("참가자 명단이 7명 이상일 경우 오류를 던진다.")
    @Test
    void nameCountOverSix() {
        Assertions.assertThatThrownBy(() ->
                new Names(List.of(
                    new Name("1"),
                    new Name("2"),
                    new Name("3"),
                    new Name("4"),
                    new Name("5"),
                    new Name("6"),
                    new Name("7")
                )))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참가자 명단이 존재하지 않을 경우 오류를 던진다.")
    @Test
    void nameCountUnderOne() {
        Assertions.assertThatThrownBy(() -> new Names(List.of()))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참가자 명단이 null일 경우 오류를 던진다.")
    @Test
    void nameNull() {
        Assertions.assertThatThrownBy(() -> new Names(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참가자 명단을 생성한다.")
    @Test
    void createNames() {
        final Name firstName = new Name("1");
        final Name secondName = new Name("2");
        final Name thridName = new Name("3");
        final Names names = new Names(List.of(firstName, secondName, thridName));
        Assertions.assertThat(names.getNames())
            .containsExactly(firstName, secondName, thridName);
    }
}
