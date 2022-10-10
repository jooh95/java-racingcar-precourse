package racingcar.view.dto;

import java.util.List;

public class PlayerInputDto {
    private final List<String> carNames;

    private final int lap;

    public PlayerInputDto(List<String> carNames, int lap) {
        this.carNames = carNames;
        this.lap = lap;
    }

    public List<String> getCarNames() {
        return carNames;
    }
    public int getLap() {
        return lap;
    }
}
