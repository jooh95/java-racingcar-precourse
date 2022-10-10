package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import racingcar.model.RacingMatch;
import racingcar.view.dto.PlayerInputDto;

public class RacingMatchView {
    private final RacingMatch racingMatch;

    public RacingMatchView(RacingMatch racingMatch) {
        this.racingMatch = racingMatch;
    }

    public PlayerInputDto askForPlayerInput() {
        List<String> carNames = askForCarNames();
        int lap = askForLap();
        return new PlayerInputDto(carNames, lap);
    }

    private List<String> askForCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은쉼표(,) 기준으로 구분)");
        String inputStr = readLine();
        return Arrays.asList(inputStr.split(","));
    }

    private int askForLap() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputStr = readLine();
        return Integer.parseInt(inputStr);
    }
}
