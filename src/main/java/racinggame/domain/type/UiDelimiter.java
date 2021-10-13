package racinggame.domain.type;

/**
 * @author Kim Jihee
 * @version 1.0
 * @since 1.0
 *
 * 입출력 과정에서 사용하는 구분자를 정의
 */


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

