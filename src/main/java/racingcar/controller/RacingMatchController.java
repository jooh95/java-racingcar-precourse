package racingcar.controller;

import racingcar.model.CarNames;
import racingcar.model.Lap;
import racingcar.model.RacingCars;
import racingcar.model.RacingMatch;
import racingcar.view.dto.PlayerInputDTO;

public class RacingMatchController {
    private final PlayerInputDTO playerInputDTO;

    public RacingMatchController(PlayerInputDTO playerInputDTO) {
        this.playerInputDTO = playerInputDTO;
    }

    public RacingMatch process() {
        RacingCars racingCars = toRacingCars(playerInputDTO);
        Lap lap = toLap(playerInputDTO);
        return new RacingMatch(racingCars, lap);
    }

    private Lap toLap(PlayerInputDTO playerInputDto) {
        return new Lap(playerInputDto.getLap());
    }

    private RacingCars toRacingCars(PlayerInputDTO playerInputDto) {
        CarNames carNames = new CarNames(playerInputDto.getCarNames());
        return new RacingCars(carNames);
    }
}
