package racinggame.domain;

public class CarName {
	private final int CAR_NAME_MIN_LENGTH=1;
	private final int CAR_NAME_MAX_LENGTH=5;

	String carName;

	public CarName(String carName) {
		validateCarName(carName);
		this.carName=carName;
	}

	private void validateCarName(String carName) {
		if (carName.length() < CAR_NAME_MIN_LENGTH || carName.length() > CAR_NAME_MAX_LENGTH) {
			throw new IllegalArgumentException();
		}

	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}
}
