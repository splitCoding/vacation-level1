package domain.participants;

import domain.participants.attributes.Name;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Participants {

    private final Dealer dealer;
    private final Map<Name, Player> players; //중복 이름 처리해야 함

    private Participants(final Dealer dealer, final Map<Name, Player> players) {
        this.dealer = dealer;
        this.players = new HashMap<>(players);
    }

    public static Participants of(final List<Name> names, final List<Player> players) {
        if (names.size() != players.size()) {
            throw new IllegalStateException("이름과 플레이어의 짝이 맞지 않습니다.");
        }
        final Map<Name, Player> playersMap = new HashMap<>();
        for (int index = 0; index < names.size(); index++) {
            playersMap.put(names.get(index), players.get(index));
        }
        return new Participants(new Dealer(), playersMap);
    }

    public Dealer getDealer() {
        return dealer;
    }

    public List<Player> getPlayers() {
        return List.copyOf(players.values());
    }
}
