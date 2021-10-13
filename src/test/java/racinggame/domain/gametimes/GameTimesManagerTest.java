package racinggame.domain.gametimes;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.exception.InvalidInputCommandException;

public class GameTimesManagerTest {

	@ParameterizedTest
	@ValueSource(ints = {1, 345, 5, 765, 7})
	public void 게임_횟수_객체_생성(int totalTimes) {
		GameTimesManager timesManager = GameTimesManager.makeGameTimeManager(totalTimes);
		assertThat(timesManager.getTotalTimes()).isEqualTo(totalTimes);
		assertThat(timesManager.getTryTimes()).isEqualTo(0);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, -1, -3436535})
	public void 유효하지_않은_게임횟수_예외처리(int totalTimes) {

		assertThatThrownBy(() -> {
			GameTimesManager timesManager = GameTimesManager.makeGameTimeManager(totalTimes);
		}).isInstanceOf(InvalidInputCommandException.class);
	}

	@Test
	public void 게임_시도횟수() {
		int totalTimes = 5;
		GameTimesManager timesManager = GameTimesManager.makeGameTimeManager(totalTimes);

		int tryTimes = 2;
		for (int i = 0; i < tryTimes; i++) {
			timesManager.addTryTimes();
		}

		assertThat(timesManager.getTryTimes()).isEqualTo(tryTimes);
	}

	@Test
	public void 게임_시도끝_체크() {
		int totalTimes = 10;
		GameTimesManager timesManager = GameTimesManager.makeGameTimeManager(totalTimes);
		for (int i = 0; i < timesManager.getTotalTimes(); i++) {
			timesManager.addTryTimes();
		}
		assertThat(timesManager.isGameFinish()).isTrue();
	}

	@Test
	public void 게임_총횟수를_넘어_시도하면_예외처리() {
		int totalTimes=10;
		GameTimesManager timesManager = GameTimesManager.makeGameTimeManager(totalTimes);

		assertThatThrownBy(() -> {
			for (int i = 0; i < timesManager.getTotalTimes() + 1; i++) {
				timesManager.addTryTimes();
			}
		}).isInstanceOf(IllegalStateException.class);

	}

}
