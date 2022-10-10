package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.model.CarNames.NAME_SPLITTER;

import java.util.Iterator;
import java.util.List;
import racingcar.model.CarName;
import racingcar.model.CarNames;
import racingcar.model.Lap;
import racingcar.model.MoveRecord;
import racingcar.model.MoveRecords;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
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

    public void printResult() {
        StringBuilder stringBuilder = new StringBuilder();
        Lap lap = racingMatch.getLap();
        if (lap != null) {
            setResultMessage(stringBuilder, lap.getLap());
        }

        if (stringBuilder.length() > 0) {
            System.out.println(stringBuilder);
        }
    }

    private void setResultMessage(StringBuilder stringBuilder, int lap) {
        stringBuilder.append("실행 결과\n");
        for (int step = 0; step < lap; step++) {
            RacingCars racingCars = racingMatch.getRacingCars();
            setEachStepStateMessage(stringBuilder, step, racingCars);
            stringBuilder.append("\n");
        }
        setWinnerMessage(stringBuilder);
    }

    private String generateMoveMark(MoveRecords moveRecords, Lap currentLap) {
        StringBuilder stringBuilder = new StringBuilder();
        List<MoveRecord> records = moveRecords.getRecords();
        for (int i = 0; i <= currentLap.getLap(); i++) {
            setMoveMark(stringBuilder, records, i);
        }
        return stringBuilder.toString();
    }

    private void setWinnerMessage(StringBuilder stringBuilder) {
        String winnerCarNamesStr = toString(racingMatch.getWinnerCarNames());

        if (!winnerCarNamesStr.isEmpty()) {
            stringBuilder.append(String.format("최종 우승자 : %s", winnerCarNamesStr));
        }
    }

    private String toString(CarNames winnerCarNames) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<CarName> carNameIterator = winnerCarNames.getNames().iterator();
        while (carNameIterator.hasNext()) {
            setCarNames(stringBuilder, carNameIterator);
        }
        return stringBuilder.toString();
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

    private void setEachStepStateMessage(StringBuilder stringBuilder, int step,
        RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            CarName carName = racingCar.getCarName();

            String moveMark = generateMoveMark(racingCar.getMoveRecords(), new Lap(step));

            stringBuilder.append(String.format("%s : %s\n", carName.getName(), moveMark));
        }
    }

    private void setCarNames(StringBuilder stringBuilder, Iterator<CarName> carNameIterator) {
        stringBuilder.append(carNameIterator.next().getName());
        if (carNameIterator.hasNext()) {
            stringBuilder.append(NAME_SPLITTER);
        }
    }

    private void setMoveMark(StringBuilder stringBuilder, List<MoveRecord> records, int i) {
        if (records.get(i).isMoved()) {
            stringBuilder.append("-");
        }
    }
}
