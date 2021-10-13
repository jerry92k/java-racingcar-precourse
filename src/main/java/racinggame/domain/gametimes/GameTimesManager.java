package racinggame.domain.gametimes;

public class GameTimesManager {

	private final static String TRY_AFTER_FINISH_ERROR_MESSAGE = "[ERROR] 게임이 모두 종료되었습니다.";

	private TotalGameTimes totalGameTimes;
	private TryGameTimes tryGameTimes;

	private GameTimesManager(TotalGameTimes totalGameTimes, TryGameTimes tryGameTimes) {
		this.totalGameTimes = totalGameTimes;
		this.tryGameTimes = tryGameTimes;
	}

	public static GameTimesManager makeGameTimeManager(int totalGameTimes) {
		return new GameTimesManager(new TotalGameTimes(totalGameTimes), new TryGameTimes());
	}

	protected boolean isGameFinish() {
		if (totalGameTimes.getTimes() == tryGameTimes.getTimes()) {
			return true;
		}
		return false;
	}

	public void addTryTimes() {
		if (isGameFinish()) {
			throw new IllegalStateException(TRY_AFTER_FINISH_ERROR_MESSAGE);
		}
		tryGameTimes.addTryTime();
	}

	public int getTotalTimes() {
		return totalGameTimes.getTimes();
	}

	public int getTryTimes() {
		return tryGameTimes.getTimes();
	}
}
