package racinggame.domain.car;

/**
 * CarPosition 객체는 외부에 노출하지 않고 RacingCar 객체에 aggregation 형태로 사용
 */
class CarPosition {
	private int position;

	public void forward() {
		position++;
	}

	public int getPosition() {
		return position;
	}
}
