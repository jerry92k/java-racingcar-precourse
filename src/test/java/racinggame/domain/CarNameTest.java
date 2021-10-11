package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {

	@ParameterizedTest
	@ValueSource(strings={"jerry","hazel","po","A","K12"})
	void 유효한_자동차_이름_생성(String name){
		CarName carName=new CarName(name);
		Assertions.assertThat(carName.getCarName()).isEqualTo(name);
	}

	@ParameterizedTest
	@ValueSource(strings={"","audixx","benz550"})
	void 유효하지_않은_자동차_이름_체크(String name){
		assertThatThrownBy(()->{
			CarName carName=new CarName(name);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
