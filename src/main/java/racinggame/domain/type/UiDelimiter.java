package racinggame.domain.type;

public enum UiDelimiter {
	PositionMarker("-"),
	NamesDelimiter(",");

	private String value;

	UiDelimiter(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}

