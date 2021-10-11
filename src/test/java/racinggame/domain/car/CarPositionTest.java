package racinggame.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarPositionTest {

	@ParameterizedTest
	@ValueSource(ints={0,1,345,5,765,7})
	void 자동차_위치_전진(int numsToGo) {
		CarPosition carPosition=new CarPosition();
		for(int i=0; i<numsToGo; i++){
			carPosition.forward();
		}

		Assertions.assertThat(carPosition.getPosition()).isEqualTo(numsToGo);
	}
}
