package controller.dto;

import domain.participants.Participants;
import domain.participants.players.Player;
import java.util.List;
import java.util.stream.Collectors;

public class ParticipantsBenefitDto {

    private final List<Integer> playersBenefit;
    private final int dealerBenefit;

    public ParticipantsBenefitDto(final Participants participants) {
        this.playersBenefit = participants.getPlayers()
            .stream()
            .map(Player::getBenefit)
            .collect(Collectors.toList());
        final int playerTotalBenefit = playersBenefit.stream()
            .mapToInt(Integer::intValue)
            .sum();
        this.dealerBenefit = playerTotalBenefit * -1;
    }

    public int getDealerBenefit() {
        return dealerBenefit;
    }

    public List<Integer> getPlayersBenefit() {
        return playersBenefit;
    }
}
