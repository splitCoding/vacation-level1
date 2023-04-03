package domain.participants.attributes;

public final class Name {

    private static final String DEALER_NAME = "딜러";
    private final String name;

    public Name(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 빈칸일 수 없습니다.");
        }
        this.name = name;
    }

    public static Name dealer() {
        return new Name(DEALER_NAME);
    }

    public String getName() {
        return name;
    }
}
