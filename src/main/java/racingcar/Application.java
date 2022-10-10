package racingcar;

import racingcar.controller.RacingMatchController;
import racingcar.view.dto.PlayerInputDTO;
import racingcar.model.RacingMatch;
import racingcar.view.RacingMatchView;

public class Application {
    public static void main(String[] args) {
        RacingMatchView racingMatchView = new RacingMatchView(RacingMatch.START);
        PlayerInputDTO playerInputDto = racingMatchView.askForPlayerInput();

        RacingMatchController racingMatchController = new RacingMatchController(playerInputDto);
        RacingMatch racingMatch = racingMatchController.process();
    }
}
