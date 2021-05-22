package com.geekseat.witchsaga;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import com.geekseat.witchsaga.model.Person;
import com.geekseat.witchsaga.model.WitchSaga;
import com.geekseat.witchsaga.service.WitchSagaService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WitchsagaApplicationTests {

	@Autowired
	private WitchSagaService witchSagaService;

	@Test
	void gettingRidOfTheWitch_WithMinusDeathAge_ExpectedReturnMinus() {
		Person person1 = new Person(-1, 5);
		Person person2 = new Person(5, 8);
		WitchSaga witchSaga = witchSagaService.gettingRidOfTheWitch(person1, person2);
		BigDecimal expected = new BigDecimal(-1);
		assertEquals(expected, witchSaga.getResult());
	}

	@Test
	void gettingRidOfTheWitch_WithMinusBornYear_ExpectedReturnMinus() {
		Person person1 = new Person(3, 5);
		Person person2 = new Person(10, 8);
		WitchSaga witchSaga = witchSagaService.gettingRidOfTheWitch(person1, person2);
		BigDecimal expected = new BigDecimal(-1);
		assertEquals(expected, witchSaga.getResult());
	}

	@Test
	void gettingRidOfTheWitch_WithNormalNumber_ExpectedReturn8() {
		Person person1 = new Person(2, 5);
		Person person2 = new Person(4, 9);
		WitchSaga witchSaga = witchSagaService.gettingRidOfTheWitch(person1, person2);
		BigDecimal expected = new BigDecimal(8);
		assertEquals(expected, witchSaga.getResult());
	}

	@Test
	void calculatePeopleWereKilledInAYear_WithValue5_ExpectedReturn12() {
		int actual = witchSagaService.calculatePeopleWereKilledInAYear(5);
		assertEquals(12, actual);
	}

}
