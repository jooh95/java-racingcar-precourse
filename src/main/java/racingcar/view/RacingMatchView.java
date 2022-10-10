package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.model.CarNames.NAME_SPLITTER;

import racingcar.model.RacingMatch;
import racingcar.view.dto.PlayerInputDTO;

public class RacingMatchView {
    private final RacingMatch racingMatch;

    public RacingMatchView(RacingMatch racingMatch) {
        this.racingMatch = racingMatch;
    }

    public PlayerInputDTO askForPlayerInput() {
        String carNames = askForCarNames();
        int lap = askForLap();
        return new PlayerInputDTO(carNames, lap);
    }

    private String askForCarNames() {
        System.out.printf("경주할 자동차 이름을 입력하세요.(이름은쉼표(%s) 기준으로 구분)\n", NAME_SPLITTER);
        return readLine();
    }

    private int askForLap() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputStr = readLine();
        return Integer.parseInt(inputStr);
    }
}
