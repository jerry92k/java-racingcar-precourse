package racinggame.domain.game;

public class GameTimes {
	private final int TOTAL_TIMES_LOWER_BOUND=1;
	private final int TOTAL_TIMES_UPPER_BOUND=Integer.MAX_VALUE;
	private final int totalTimes;
	private int tryTimes;

	public GameTimes(int totalTimes) {
		validateTotalTimes(totalTimes);
		this.totalTimes=totalTimes;
	}

	private void validateTotalTimes(int totalTimes) {
		if(totalTimes < TOTAL_TIMES_LOWER_BOUND || totalTimes > TOTAL_TIMES_UPPER_BOUND) {
			throw new IllegalArgumentException("[ERROR] 게임 횟수는 1~2147483647 사이 가능합니다.");
		}
	}

	public int getTotalTimes() {
		return totalTimes;
	}

	public void addTryTimes() {
		if(isGameFinish()) {
			throw new IllegalStateException("[ERROR] "+getTotalTimes()+"번의 횟수가 끝났습니다.");
		}

		tryTimes++;
	}

	public boolean isGameFinish() {
		if(tryTimes==totalTimes){
			return true;
		}
		return false;
	}

	public int getTryTimes() {
		return tryTimes;
	}
}
