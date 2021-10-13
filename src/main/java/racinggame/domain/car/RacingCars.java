package racinggame.domain.car;

import java.util.ArrayList;
import java.util.List;

import racinggame.domain.type.UiDelimiter;

public class RacingCars {

	List<RacingCar> cars;

	public RacingCars(List<RacingCar> cars) {
		this.cars = cars;
	}

	public static RacingCars makeRacingCars(String[] carNames) {
		List<RacingCar> racingCars = new ArrayList<>();
		for (String name : carNames) {
			racingCars.add(new RacingCar(name));
		}
		return new RacingCars(racingCars);
	}

	public void nextPlay() {
		for (RacingCar car : cars) {
			car.nextPlay();
		}
	}

	public List<RacingCar> getCars() {
		return cars;
	}

	public String getCarNames() {
		List<String> names = new ArrayList<>();
		for (RacingCar car : cars) {
			names.add(car.getName());
		}
		return String.join(UiDelimiter.NamesDelimiter.getValue(), names);
	}

	public int getMaxCarPosition() {
		int maxCarPosition = 0;
		for (RacingCar car : cars) {
			maxCarPosition = Math.max(maxCarPosition, car.getPosition());
		}
		return maxCarPosition;
	}
}
