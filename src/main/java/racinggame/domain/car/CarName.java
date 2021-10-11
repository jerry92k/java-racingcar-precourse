package racinggame.domain.car;

public class CarName {
	private final int CAR_NAME_MIN_LENGTH=1;
	private final int CAR_NAME_MAX_LENGTH=5;

	private String name;

	public CarName(String name) {
		validateCarName(name);
		this.name=name;
	}

	private void validateCarName(String carName) {
		if (carName.length() < CAR_NAME_MIN_LENGTH || carName.length() > CAR_NAME_MAX_LENGTH) {
			throw new IllegalArgumentException();
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
