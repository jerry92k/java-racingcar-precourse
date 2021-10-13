package racinggame;

import nextstep.test.NSTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ApplicationTest extends NSTest {
	private final static String INPUT_TOTAL_TIMES_ERROR_MESSAGE = "[ERROR] 게임 횟수는 1~2147483647 사이만 가능합니다.";

	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;

	private static final String ERROR_MESSAGE = "[ERROR]";

	@BeforeEach
	void beforeEach() {
		setUp();
	}

	@Test
	void 전진_정지() {
		assertRandomTest(() -> {
			run("pobi,woni", "1");
			verify("pobi : -", "woni : ", "최종 우승자는 pobi 입니다.");
		}, MOVING_FORWARD, STOP);
	}

	@Test
	void 이름에_대한_예외_처리() {
		assertSimpleTest(() -> {
			runNoLineFound("pobi,javaji");
			verify(ERROR_MESSAGE);
		});
	}

	@ParameterizedTest
	@ValueSource(strings = {"0", "-1", "9999999999999", "두개"})
	void 유효하지않은_게임횟수_예외_처리(String gameTimes) {
		assertSimpleTest(() -> {
			runNoLineFound("pobi,woni,jes,alca", gameTimes);
			verify(INPUT_TOTAL_TIMES_ERROR_MESSAGE);
		});
	}

	@Test
	void 우승자가_여러명인경우() {
		assertRandomTest(() -> {
				run("pobi,woni,brek", "3");
				verify("최종 우승자는 pobi,brek 입니다.");
			}, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP,
			MOVING_FORWARD);
	}

	@AfterEach
	void tearDown() {
		outputStandard();
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
