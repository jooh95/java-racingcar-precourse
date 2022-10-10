package racingcar;

import racingcar.controller.RacingMatchController;
import racingcar.model.RacingMatch;
import racingcar.view.RacingMatchView;
import racingcar.view.dto.PlayerInputDTO;

public class Application {
    public static void main(String[] args) {
        RacingMatchView racingMatchView = new RacingMatchView(RacingMatch.START);
        PlayerInputDTO playerInputDTO = racingMatchView.askForPlayerInput();

        RacingMatchController racingMatchController = new RacingMatchController(playerInputDTO);
        RacingMatch racingMatch = racingMatchController.process();

        racingMatchView = new RacingMatchView(racingMatch);
        racingMatchView.printResult();
    }
}
