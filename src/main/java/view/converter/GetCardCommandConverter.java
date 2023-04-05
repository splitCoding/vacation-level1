package view.converter;

import domain.GetMoreCardCommand;
import java.util.Arrays;

public enum GetCardCommandConverter {
    YES("y"),
    NO("n");

    private final String content;

    GetCardCommandConverter(String content) {
        this.content = content;
    }

    private static GetCardCommandConverter find(final String commandInput) {
        return Arrays.stream(values())
            .filter(cardCommandConverter -> cardCommandConverter.content.equals(commandInput))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("카드 지급 여부 입력이 잘못 되었습니다."));
    }

    public static GetMoreCardCommand convert(final String commandInput) {
        return Arrays.stream(GetMoreCardCommand.values())
            .filter(command -> command.name().equals(find(commandInput).name()))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("카드 지급 여부 입력이 잘못 되었습니다."));
    }
}
