package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racinggame.domain.car.RacingCar;
import racinggame.domain.car.RacingCars;
import racinggame.domain.type.CarNextStatus;

class RacingCarGameTest {

	RacingCarGame racingCarGame;

	@BeforeEach
	void beforeEach() {
		String[] carNames = {"pobi", "crong", "houd"};
		RacingCars racingCars = RacingCars.makeRacingCars(carNames);
		GameTimes gameTimes = new GameTimes(7);
		racingCarGame = new RacingCarGame(racingCars, gameTimes);
	}

	@Test
	void 가장_멀리간_자동차() {
		RacingCar firstCar = racingCarGame.getRacingCars().getCars().get(0);
		for (int i = 1; i <= 7; i++) {
			firstCar.nextMove(CarNextStatus.Forward);
		}
		RacingCars bestCars = racingCarGame.getBestCars();
		Assertions.assertThat(bestCars.getCars().size()).isEqualTo(1);
		Assertions.assertThat(bestCars.getCars().get(0).getName()).isEqualTo(firstCar.getName());
		Assertions.assertThat(bestCars.getCars().get(0).getPosition()).isEqualTo(firstCar.getPosition());
	}
}
