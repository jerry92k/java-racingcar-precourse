package racinggame.domain.car;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;


class RacingCarsTest {

	@Test
	void 자동차_이름_배열_받아서_객체_생성(){
		String[] carNames={"pobi","crong","houd"};
		RacingCars racingCars=RacingCars.makeRacingCars(carNames);
		Assertions.assertThat(racingCars.getCars().get(0).getName()).isEqualTo(carNames[0]);

	}

	@Test
	void 자동차들_이름_하나의_문자열로_생성(){
		String[] carNames={"pobi","crong","houd"};
		RacingCars racingCars=RacingCars.makeRacingCars(carNames);
		Assertions.assertThat(racingCars.getCarNames()).isEqualTo("pobi,crong,houd");
	}
}