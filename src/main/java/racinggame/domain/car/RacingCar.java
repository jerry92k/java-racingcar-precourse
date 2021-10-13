package racinggame.domain.car;

import nextstep.utils.Randoms;
import racinggame.domain.type.CarNextStatus;

public class RacingCar {

	private static final int RANDOM_VAL_MIN = 0;
	private static final int RANDOM_VAL_MAX = 9;
	private static final int RANDOM_VAL_WAIT_UPPER_BOUND = 4;

	private CarName carName;
	private CarPosition carPosition;

	public RacingCar(String name) {
		this.carName = new CarName(name);
		this.carPosition = new CarPosition();
	}

	public String getName() {
		return getCarName().getName();
	}

	public int getPosition() {
		return getCarPosition().getPosition();
	}

	private CarName getCarName() {
		return carName;
	}

	private CarPosition getCarPosition() {
		return carPosition;
	}

	public void nextMove(CarNextStatus forward) {
		if (forward == CarNextStatus.Forward) {
			getCarPosition().forward();
		}
	}

	public void nextPlay() {
		CarNextStatus nextStatus = getNextStatus(Randoms.pickNumberInRange(RANDOM_VAL_MIN, RANDOM_VAL_MAX));
		nextMove(nextStatus);
	}

	public CarNextStatus getNextStatus(int number) {
		if (number < RANDOM_VAL_WAIT_UPPER_BOUND) {
			return CarNextStatus.Wait;
		}
		return CarNextStatus.Forward;
	}
}
