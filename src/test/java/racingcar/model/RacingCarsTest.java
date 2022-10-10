package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {
    @DisplayName("경주중이 아닐때 farthestLap이 0인지 테스트")
    @Test
    void getFarthestLap() {
        RacingCars racingCars = new RacingCars(new CarNames("a,b,c"));

        Lap farthestLap = racingCars.getFarthestLap();

        assertThat(farthestLap.getLap()).isEqualTo(0);
    }
}
