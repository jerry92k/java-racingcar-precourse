package racinggame.domain.car;

import static org.assertj.core.api.Assertions.*;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;
import racinggame.domain.type.CarNextStatus;
import racinggame.exception.InvalidInputCommandException;

public class RacingCarTest {

	@Test
	void 자동차_생성() {
		String carName = "jerrC";
		RacingCar car = new RacingCar(carName);
		assertThat(car.getName()).isEqualTo(carName);
		assertThat(car.getPosition()).isEqualTo(0);
	}

	@ParameterizedTest
	@ValueSource(strings = {"jerry", "hazel", "po", "A", "K12"})
	void 유효한_자동차_이름_생성(String name) {
		RacingCar car = new RacingCar(name);
		assertThat(car.getName()).isEqualTo(name);
	}

	@ParameterizedTest
	@ValueSource(strings = {"", "audixx", "benz550"})
	void 유효하지_않은_자동차_이름_예외처리(String name) {
		assertThatThrownBy(() -> {
			RacingCar car = new RacingCar(name);
		}).isInstanceOf(InvalidInputCommandException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"Forward:1", "Wait:0"}, delimiter = ':')
	void 자동차_다음_동작에_따른_위치(CarNextStatus carNextStatus, int nextPosition) {
		String name = "exAud";
		RacingCar car = new RacingCar(name);
		car.nextMove(carNextStatus);
		assertThat(car.getPosition()).isEqualTo(nextPosition);
	}

	@ParameterizedTest
	@CsvSource(value = {"0:Wait", "3:Wait", "4:Forward", "9:Forward"}, delimiter = ':')
	void 난수에_따른_다음동작(int nextRandom, CarNextStatus carNextStatus) {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
				.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(nextRandom);
			String name = "jerco";
			RacingCar car = new RacingCar(name);
			car.nextPlay();
			assertThat(car.getPosition()).isEqualTo(carNextStatus.getValue());
		}
	}
}
