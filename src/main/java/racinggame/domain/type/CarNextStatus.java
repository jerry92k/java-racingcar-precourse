package racinggame.domain.type;

/**
 * @author Kim Jihee
 * @version 1.0
 * @since 1.0
 *
 * 자동차의 다음 상태를 열거형으로 정의
 */


public enum CarNextStatus {

	Wait(0),
	Forward(1);

	private int value;

	CarNextStatus(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
