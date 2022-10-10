package racingcar.view.dto;

public class PlayerInputDTO {
    private final String carNames;
    private final int lap;

    public PlayerInputDTO(String carNames, int lap) {
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
