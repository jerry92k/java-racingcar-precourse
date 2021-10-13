package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

import racinggame.domain.car.RacingCar;
import racinggame.domain.car.RacingCars;

public class RacingCarGame {

	private RacingCars cars;
	private GameTimes gameTimes;

	public RacingCarGame(RacingCars cars, GameTimes gameTimes) {
		this.cars = cars;
		this.gameTimes = gameTimes;
	}

	public void doNextGame() {
		gameTimes.addTryTimes();
		cars.nextPlay();
	}

	public RacingCars getRacingCars() {
		return cars;
	}

	public GameTimes getGameTimes() {
		return gameTimes;
	}

	public RacingCars getBestCars() {
		List<RacingCar> inMaxPositionCars = getInMaxPositionCars();
		RacingCars bestCars = new RacingCars(inMaxPositionCars);
		return bestCars;
	}

	private List<RacingCar> getInMaxPositionCars() {
		List<RacingCar> inMaxPositionCars = new ArrayList<>();
		for (RacingCar car : cars.getCars()) {
			filterCar(inMaxPositionCars,car);
		}
		return inMaxPositionCars;
	}

	private void filterCar(List<RacingCar> inMaxPositionCars, RacingCar car) {
		if (car.getPosition() == cars.getMaxCarPosition()) {
			inMaxPositionCars.add(car);
		}
	}
}
