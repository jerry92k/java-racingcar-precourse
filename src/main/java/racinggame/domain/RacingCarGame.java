package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

import racinggame.domain.car.RacingCar;
import racinggame.domain.car.RacingCars;
import racinggame.domain.gametimes.GameTimesManager;

/**
 * @author Kim Jihee
 * @version 1.0
 * @since 1.0
 *
 * 자동차 게임 클래
 */


public class RacingCarGame {

	private RacingCars cars;
	private GameTimesManager timesManager;

	// 게임 생성을 위해선 참가 자동차 객체와 총 횟수 객체가 반드시 필요
	public RacingCarGame(RacingCars cars, GameTimesManager timesManager) {
		this.cars = cars;
		this.timesManager = timesManager;
	}

	// 게임을 한번 할 때마다 게임 횟수 객체의 시도회수를 증가하고, 자동차들은 각자 난수를 생성하여 포지션을 정한다.
	public void doNextGame() {
		timesManager.addTryTimes();
		cars.nextPlay();
	}

	public RacingCars getRacingCars() {
		return cars;
	}

	public GameTimesManager getGameTimes() {
		return timesManager;
	}

	public RacingCars getBestCars() {
		List<RacingCar> inMaxPositionCars = getInMaxPositionCars();
		RacingCars bestCars = new RacingCars(inMaxPositionCars);
		return bestCars;
	}

	private List<RacingCar> getInMaxPositionCars() {
		List<RacingCar> inMaxPositionCars = new ArrayList<>();
		for (RacingCar car : cars.getCars()) {
			filterCar(inMaxPositionCars, car);
		}
		return inMaxPositionCars;
	}

	private void filterCar(List<RacingCar> inMaxPositionCars, RacingCar car) {
		if (car.getPosition() == cars.getMaxCarPosition()) {
			inMaxPositionCars.add(car);
		}
	}
}
