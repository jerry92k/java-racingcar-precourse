package racinggame.domain.car;

public class RacingCar {

	private final int RANDOM_VAL_MIN=0;
	private final int RANDOM_VAL_MAX=9;
	private final int RANDOM_VAL_WAIT_UPPER_BOUND=4;

	private CarName carName;
	private CarPosition carPosition;

	public RacingCar(String name) {
		this.carName=new CarName(name);
		this.carPosition=new CarPosition();
	}

	public String getName() {
		return getCarName().getName();
	}

	public int getPosition() {
		return getCarPosition().getPosition();
	}

	public void changeCarName(String rename) {
		this.carName=new CarName(rename);
	}

	public void forwardPosition() {
		getCarPosition().forward();
	}

	private CarName getCarName() {
		return carName;
	}

	private CarPosition getCarPosition() {
		return carPosition;
	}

	public void changePosition(CarNextStatus forward) {
		if(forward == CarNextStatus.Forward){
			getCarPosition().forward();
		}
	}

	public void nextMove() {
	}

	public CarNextStatus getNextStatus(int number) {
		if(number < RANDOM_VAL_WAIT_UPPER_BOUND){
			return CarNextStatus.Wait;
		}
		return CarNextStatus.Forward;
	}
}
