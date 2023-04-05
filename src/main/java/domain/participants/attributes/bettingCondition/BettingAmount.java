package domain.participants.attributes.bettingCondition;

public final class BettingAmount {

    private static final int DIVIDE_UNIT = 1000;
    private final int amount;

    private BettingAmount(final int amount) {
        this.amount = amount;
    }

    public static BettingAmount of(final String amountInput) {
        try {
            final int amount = Integer.parseInt(amountInput);
            validate(amount);
            return new BettingAmount(amount);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("배팅금액은 숫자여야 합니다.");
        }
    }

    private static void validate(final int amount) {
        if (amount < DIVIDE_UNIT) {
            throw new IllegalArgumentException("배팅금액은 1000보다 작을 수 없습니다.");
        }
        if (amount % DIVIDE_UNIT != 0) {
            throw new IllegalArgumentException("배팅금액은 1000원 단위여야 합니다.");
        }
    }

    public int getAmount() {
        return amount;
    }
}
