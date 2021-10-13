package racinggame.domain.gametimes;

import racinggame.exception.InvalidInputCommandException;

abstract public class GameTimes {
	private final static String INPUT_TOTAL_TIMES_ERROR_MESSAGE = "[ERROR] 게임 횟수는 1~2147483647 사이만 가능합니다.";
	private final static int TOTAL_TIMES_LOWER_BOUND = 1;
	private final static int TOTAL_TIMES_UPPER_BOUND = Integer.MAX_VALUE;

	protected int times;

	public GameTimes() {
	}

	public GameTimes(int times) {
		validateTotalTimes(times);
		this.times = times;
	}

	private void validateTotalTimes(int totalTimes) {
		if (totalTimes < TOTAL_TIMES_LOWER_BOUND || totalTimes > TOTAL_TIMES_UPPER_BOUND) {
			throw new InvalidInputCommandException(INPUT_TOTAL_TIMES_ERROR_MESSAGE);
		}
	}

	public int getTimes(){
		return times;
	}
}
