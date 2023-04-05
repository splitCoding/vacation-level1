package domain.participants;

import static org.assertj.core.api.Assertions.assertThat;

import domain.participants.attributes.Name;
import domain.participants.attributes.bettingCondition.BettingAmount;
import domain.participants.players.Player;
import domain.participants.players.Players;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantsTest {

    private final Player player = new Player(BettingAmount.of("1000"));
    private Participants participants;

    @BeforeEach
    void beforeEach() {
        final Name name = new Name("split");
        final Players players = Players.of(
            List.of(name),
            List.of(player)
        );
        participants = new Participants(players);
    }

    @DisplayName("현재 게임을 진행해야 하는 플레이어의 이름을 반환한다.")
    @Test
    void getCurrentPlayerName() {
        assertThat(participants.getCurrentPlayerName()).isEqualTo("split");
    }

    @DisplayName("현재 게임을 진행해야 하는 플레이어를 반환한다.")
    @Test
    void getCurrentPlayer() {
        assertThat(participants.getCurrentPlayer()).isEqualTo(player);
    }

    @DisplayName("게임을 기다리는 플레이어가 있는지 반환한다.")
    @Test
    void isWaitingPlayerExist() {
        assertThat(participants.isWaitingPlayerExist()).isTrue();
    }

    @DisplayName("딜러의 이름을 반환한다.")
    @Test
    void getDealerName() {
        assertThat(participants.getDealerName()).isEqualTo("딜러");
    }

    @DisplayName("플레이어들의 이름을 반환한다.")
    @Test
    void getPlayerNames() {
        assertThat(participants.getPlayerNames()).containsExactly("split");
    }
}
