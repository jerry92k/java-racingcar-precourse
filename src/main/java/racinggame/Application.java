package racinggame;

import racinggame.controller.RacingCarGameController;
import racinggame.domain.car.RacingCar;

public class Application {
	public static void main(String[] args) {
		RacingCarGameController racingCarGameController = new RacingCarGameController();
		racingCarGameController.initGame();
		racingCarGameController.playGames();
		racingCarGameController.findBestCars();
	}
}
