package racinggame.controller;

import nextstep.utils.Console;
import racinggame.domain.GameTimes;
import racinggame.domain.RacingCarGame;
import racinggame.domain.car.RacingCar;
import racinggame.domain.car.RacingCars;
import racinggame.domain.type.UiDelimiter;
import racinggame.exception.InvalidInputCommandException;

/**
 * @author Kim Jihee
 * @version 1.0
 * @since 1.0
 *
 * 자동차 게임의 흐름을 제어하고 사용자로부터 받은 입력값에 대해 게임 결과물을 출력하는 클래스
 */

public class RacingCarGameController {
	private final static String INPUT_TOTAL_TIMES_ERROR_MESSAGE = "[ERROR] 게임 횟수는 1~2147483647 사이만 가능합니다.";
	private static final String GAME_RESULT_SHOW_START_MESSAGE = "실행 결과";
	private static final String CAR_NAME_INPUT_GUID_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기즌으로 구분)";
	private static final String TOTAL_GAME_TIMES_INPUT_GUIDE_MESSAGE = "시도할 횟수는 몇회인가요?";
	private static final String CAR_NAME_INPUT_ERROR_MESSAGE = "[ERROR] 경주에 참여할 자동차 이름들을 쉼표로 구분하여 입력해주세요.";
	private static final String FINISH_IS_MESSAGE = "최종 우승자는";
	private static final String FINISH_END_MESSAGE = "입니다.";

	private RacingCarGame racingCarGame;

	public RacingCarGameController() {
	}

	public void initGame() {
		RacingCars cars = initRacingCars();
		GameTimes gameTimes = initGameTimes();
		racingCarGame = new RacingCarGame(cars, gameTimes);
	}

	public void playGames() {
		System.out.println(GAME_RESULT_SHOW_START_MESSAGE);
		for (int i = 0; i < racingCarGame.getGameTimes().getTotalTimes(); i++) {
			racingCarGame.doNextGame();
			printStatusAfterGame();
			System.out.println();
		}
	}

	private void printStatusAfterGame() {
		RacingCars cars = racingCarGame.getRacingCars();
		for (RacingCar racingCar : cars.getCars()) {
			printCarPosition(racingCar);
		}
	}

	private void printCarPosition(RacingCar racingCar) {
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < racingCar.getPosition(); t++) {
			sb.append(UiDelimiter.PositionMarker.getValue());
		}
		System.out.println(racingCar.getName() + " : " + sb.toString());
	}

	public void findBestCars() {
		printBestCarNames(racingCarGame.getBestCars().getCarNames());
	}

	private void printBestCarNames(String carNames) {
		System.out.println(FINISH_IS_MESSAGE + " " + carNames + " " + FINISH_END_MESSAGE);
	}

	private RacingCars initRacingCars() {
		try {
			String inputCarNames = readCarNamesInput();
			String[] carNames = getCarNames(inputCarNames);
			return RacingCars.makeRacingCars(carNames);
		} catch (InvalidInputCommandException ex) {
			return initRacingCars(); // 사용자가 유효하지 않은 값을 입력한 경우 다시 입력 받도록 함
		} catch (Exception ex) { // 예상치 못한 그 외 예외는 오류가 발생하도록 던짐
			throw ex;
		}
	}

	private String readCarNamesInput() {
		System.out.println(CAR_NAME_INPUT_GUID_MESSAGE);
		return Console.readLine();
	}

	private GameTimes initGameTimes() {
		try {
			String inputTotalGameTimes = readTotalGameTimesInput();
			int totalGameTimes = getTotalGameTimes(inputTotalGameTimes);
			return new GameTimes(totalGameTimes); // 사용자가 유효하지 않은 값을 입력한 경우 다시 입력 받도록 함
		} catch (InvalidInputCommandException | NumberFormatException ex) {
		// 입력받은 문자가 정수형이 아니거나 Integer.MAX_VALUE 값을 넘어가면 NumberFormatException 발생
			System.out.println(ex.getMessage());
			return initGameTimes();
		} catch (Exception ex) {
			throw ex; // 예상치 못한 그 외 예외는 오류가 발생하도록 던짐
		}
	}

	private String readTotalGameTimesInput() {
		System.out.println(TOTAL_GAME_TIMES_INPUT_GUIDE_MESSAGE);
		return Console.readLine();
	}

	private int getTotalGameTimes(String inputTotalGameTimes) {
		try {
			return Integer.parseInt(inputTotalGameTimes);
		} catch (NumberFormatException numberFormatException) {
			throw new NumberFormatException(INPUT_TOTAL_TIMES_ERROR_MESSAGE);
		}
	}

	private String[] getCarNames(String inputCarNames) {
		String[] carNames = inputCarNames.split(UiDelimiter.NamesDelimiter.getValue());
		if (carNames.length == 0) {
			throw new IllegalArgumentException(CAR_NAME_INPUT_ERROR_MESSAGE);
		}
		return inputCarNames.split(UiDelimiter.NamesDelimiter.getValue());
	}

}
