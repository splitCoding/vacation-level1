package domain.participants.attributes;

import java.util.Objects;

public final class Name {

    private static final String DEALER_NAME = "딜러";
    private final String name;

    public Name(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 빈칸일 수 없습니다.");
        }
        this.name = name.strip();
    }

    public static Name dealer() {
        return new Name(DEALER_NAME);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return name.equals(name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
