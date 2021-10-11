package racinggame.domain.car;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarTest {

	@Test
	void 자동차_생성(){
		String carName="jerrC";
		RacingCar car = new RacingCar(carName);
		assertThat(car.getName()).isEqualTo(carName);
		assertThat(car.getPosition()).isEqualTo(0);
	}

	@ParameterizedTest
	@ValueSource(strings={"jerry","hazel","po","A","K12"})
	void 유효한_자동차_이름_생성(String name){
		RacingCar car = new RacingCar(name);
		assertThat(car.getName()).isEqualTo(name);
	}

	@ParameterizedTest
	@ValueSource(strings={"","audixx","benz550"})
	void 유효하지_않은_자동차_이름_예외처리(String name){
		assertThatThrownBy(()->{
			RacingCar car = new RacingCar(name);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@ValueSource(ints={0,1,345,5,765,7})
	void 자동차_위치_전진(int numsToGo) {
		String name="exAud";
		RacingCar car = new RacingCar(name);
		for(int i=0; i<numsToGo; i++){
			car.forwardPosition();
		}

		Assertions.assertThat(car.getPosition()).isEqualTo(numsToGo);
	}
}
