package domain.participants.players;

import domain.participants.attributes.Name;
import domain.participants.attributes.bettingCondition.BettingAmount;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @DisplayName("생성시 이름의 수와 플레이어의 수가 다를 경우 오류를 던진다.")
    @Test
    void createFail() {
        Assertions.assertThatThrownBy(() -> Players.of(
            List.of(new Name("split")),
            List.of(
                new Player(BettingAmount.of("1000")),
                new Player(BettingAmount.of("1000"))
            )
        )).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름의 수와 플레이어의 수가 같은 경우 생성된다.")
    @Test
    void createSuccess() {
        final Name name = new Name("split");
        final Player player = new Player(BettingAmount.of("1000"));
        final Players players = Players.of(
            List.of(name),
            List.of(player)
        );
        Assertions.assertThat(players.getPlayers()).containsExactly(player);
        Assertions.assertThat(players.getNames()).containsExactly(name);
    }
}
