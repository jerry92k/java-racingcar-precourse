package racinggame.domain.type;

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
