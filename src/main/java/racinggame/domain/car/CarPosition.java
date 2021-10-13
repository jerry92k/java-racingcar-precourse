package racinggame.domain.car;

/**
 * @author Kim Jihee
 * @version 1.0
 * @since 1.0
 *
 * 자동차 위치 position 타입을 래핑한 클래스
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
