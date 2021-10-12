package racinggame.domain.car;

import java.util.NoSuchElementException;

import racinggame.exception.InvalidInputCommandException;

/**
 * CarName 객체는 외부에 노출하지 않고 RacingCar 객체에 aggregation 형태로 사용
 */
class CarName {
	private final String CAR_NAME_ERROR_MESSAGE="[ERROR] 유효하지 않은 자동차 이름입니다. 이름의 길이는 1~5 사이 입니다.";
	private final int CAR_NAME_MIN_LENGTH = 1;
	private final int CAR_NAME_MAX_LENGTH = 5;

	private String name;

	public CarName(String name) {
		validateCarName(name);
		this.name = name;
	}

	private void validateCarName(String carName) {
		if (carName.length() < CAR_NAME_MIN_LENGTH || carName.length() > CAR_NAME_MAX_LENGTH) {
			System.out.println(CAR_NAME_ERROR_MESSAGE);
			throw new InvalidInputCommandException(CAR_NAME_ERROR_MESSAGE);
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
