package racinggame.domain.car;

enum CarNextStatus {
	Forward("전진"),
	Wait("대기");
	private String value;

	CarNextStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
