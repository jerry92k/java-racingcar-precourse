package racinggame.domain.car;

public class CarPosition {
	private int position;

	public void forward() {
		position++;
	}

	public int getPosition() {
		return position;
	}
}
