package racingcar.view.dto;

import java.util.List;

public class PlayerInputDto {
    private final String carNames;
    private final int lap;

    public PlayerInputDto(String carNames, int lap) {
        this.carNames = carNames;
        this.lap = lap;
    }

    public String getCarNames() {
        return carNames;
    }

    public int getLap() {
        return lap;
    }
}
