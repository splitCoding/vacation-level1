package domain.participants.players;

import domain.participants.attributes.Name;
import java.util.ArrayList;
import java.util.List;

public class Players {

    private final List<Name> names;
    private final List<Player> players;

    private Players(final List<Name> names, final List<Player> players) {
        this.names = new ArrayList<>(names);
        this.players = new ArrayList<>(players);
    }

    public static Players of(final List<Name> names, final List<Player> players) {
        if (names.size() != players.size()) {
            throw new IllegalArgumentException("이름과 플레이어의 짝이 맞지 않습니다.");
        }
        return new Players(names, players);
    }

    public List<Name> getNames() {
        return List.copyOf(names);
    }

    public List<Player> getPlayers() {
        return List.copyOf(players);
    }
}
