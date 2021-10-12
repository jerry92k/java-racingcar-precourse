package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.domain.GameTimes;

public class GameTimesTest {

	@ParameterizedTest
	@ValueSource(ints = {1, 345, 5, 765, 7})
	public void 게임_횟수_객체_생성(int totalTimes) {
		GameTimes gameTimes = new GameTimes(totalTimes);
		assertThat(gameTimes.getTotalTimes()).isEqualTo(totalTimes);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, -1, -3436535})
	public void 유효하지_않은_게임횟수_예외처리(int totalTimes) {

		assertThatThrownBy(() -> {
			GameTimes gameTimes = new GameTimes(totalTimes);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 게임_시도횟수() {
		int totalTimes = 5;
		GameTimes gameTimes = new GameTimes(totalTimes);

		int tryTimes = 2;
		for (int i = 0; i < tryTimes; i++) {
			gameTimes.addTryTimes();
		}

		assertThat(gameTimes.getTryTimes()).isEqualTo(tryTimes);
	}

	@Test
	public void 게임_시도끝_체크() {
		int totalTimes = 10;
		GameTimes gameTimes = new GameTimes(totalTimes);
		for (int i = 0; i < gameTimes.getTotalTimes(); i++) {
			gameTimes.addTryTimes();
		}
		assertThat(gameTimes.isGameFinish()).isTrue();
	}

	@Test
	public void 게임_총횟수를_넘어_시도하면_예외처리() {
		GameTimes gameTimes = new GameTimes(10);

		assertThatThrownBy(() -> {
			for (int i = 0; i < gameTimes.getTotalTimes() + 1; i++) {
				gameTimes.addTryTimes();
			}
		}).isInstanceOf(IllegalStateException.class);

	}

}
