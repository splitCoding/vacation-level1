package domain.participants.attributes;

import java.util.List;

public class Names {

    private static final int MIN_COUNT = 1;
    private static final int MAX_COUNT = 6;
    private final List<Name> names;

    public Names(final List<Name> names) {
        if (names == null) {
            throw new IllegalArgumentException("참가자 이름이 존재하지 않습니다.");
        }
        final long distinctCount = names.stream().distinct().count();
        if (names.size() != distinctCount) {
            throw new IllegalArgumentException("참자가 중에 중복된 이름이 존재합니다.");
        }
        if (MIN_COUNT > distinctCount || distinctCount > MAX_COUNT) {
            throw new IllegalArgumentException("참가자는 1명 이상 6이하 여야 합니다.");
        }
        this.names = names;
    }

    public List<Name> getNames() {
        return List.copyOf(names);
    }
}
