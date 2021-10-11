package racinggame.domain.car;

public class RacingCar {

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
}
