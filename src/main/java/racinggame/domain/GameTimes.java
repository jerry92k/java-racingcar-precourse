package racinggame.domain;

import racinggame.exception.InvalidInputCommandException;

/**
 * @author Kim Jihee
 * @version 1.0
 * @since 1.0
 *
 * 게임의 횟수를 관리하는 클래스
 * 총 횟수와 시도 횟수를 별도 관리
 */


public class GameTimes {
	private final static String INPUT_TOTAL_TIMES_ERROR_MESSAGE = "[ERROR] 게임 횟수는 1~2147483647 사이만 가능합니다.";
	private final static String TRY_AFTER_FINISH_ERROR_MESSAGE = "[ERROR] 게임이 모두 종료되었습니다.";
	private final static int TOTAL_TIMES_LOWER_BOUND = 1;
	private final static int TOTAL_TIMES_UPPER_BOUND = Integer.MAX_VALUE;
	private final int totalTimes;
	private int tryTimes;

	public GameTimes(int totalTimes) {
		validateTotalTimes(totalTimes);
		this.totalTimes = totalTimes;
	}

	private void validateTotalTimes(int totalTimes) {
		if (totalTimes < TOTAL_TIMES_LOWER_BOUND || totalTimes > TOTAL_TIMES_UPPER_BOUND) {
			throw new InvalidInputCommandException(INPUT_TOTAL_TIMES_ERROR_MESSAGE);
		}
	}

	public int getTotalTimes() {
		return totalTimes;
	}

	public void addTryTimes() {
		if (isGameFinish()) {
			throw new IllegalStateException(TRY_AFTER_FINISH_ERROR_MESSAGE);
		}
		tryTimes++;
	}

	public boolean isGameFinish() {
		if (tryTimes == totalTimes) {
			return true;
		}
		return false;
	}

	public int getTryTimes() {
		return tryTimes;
	}
}
