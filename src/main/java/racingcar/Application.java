package racingcar;

import racingcar.view.dto.PlayerInputDto;
import racingcar.model.RacingMatch;
import racingcar.view.RacingMatchView;

public class Application {
    public static void main(String[] args) {
        RacingMatchView racingMatchView = new RacingMatchView(RacingMatch.START);
        PlayerInputDto playerInputDto = racingMatchView.askForPlayerInput();
    }
}
