package com.geekseat.witchsaga.service;

import java.math.BigDecimal;

import com.geekseat.witchsaga.model.Person;
import com.geekseat.witchsaga.model.WitchSaga;

import org.springframework.stereotype.Service;

@Service
public class WitchSagaServiceImpl implements WitchSagaService {

    public WitchSaga gettingRidOfTheWitch(Person person1, Person person2) {
        final WitchSaga result;

        boolean validateDeathAgeOfPeople = validateDeathAgeOfPerson(person1, person2);
        if (!validateDeathAgeOfPeople) {
            String description = "There's a person with negative number of age. Unfortunately, the witch will continue to kill the villagers.";
            result = new WitchSaga.WitchSagaBuilder()
                    .withPerson1(person1)
                    .withPerson2(person2)
                    .withDescription(description)
                    .withResultValue(new BigDecimal(-1))
                    .build();
            return result;
        }
        boolean validateBirthYearOfPeople = validateBirthYearOfPerson(person1, person2);
        if (!validateBirthYearOfPeople) {
            String description = "There's a person were born before the witch took control. Unfortunately, the witch will continue to kill the villagers.";
            result = new WitchSaga.WitchSagaBuilder()
                    .withPerson1(person1)
                    .withPerson2(person2)
                    .withDescription(description)
                    .withResultValue(new BigDecimal(-1))
                    .build();
            return result;
        }

        int deathPeople1 = calculatePeopleWereKilledInAYear(person1.getBirthYear());
        int deathPeople2 = calculatePeopleWereKilledInAYear(person2.getBirthYear());
        BigDecimal resultValue = calculateAveragePeopleWereKilled(deathPeople1, deathPeople2);
        person1.setNumberOfPeopleWereKilled(deathPeople1);
        person2.setNumberOfPeopleWereKilled(deathPeople2);

        String description = "The average number is correct. Congratulation! You've stopped the witch to kill the villagers and she'll leave us forever.";
        result = new WitchSaga.WitchSagaBuilder()
                .withPerson1(person1)
                .withPerson2(person2)
                .withDescription(description)
                .withResultValue(resultValue)
                .build();
        return result;
    }
    
    public BigDecimal calculateAveragePeopleWereKilled(int total1, int total2) {
        BigDecimal totalPeopleWereKilled = new BigDecimal(total1 + total2);
        BigDecimal divider = new BigDecimal(2);
        return totalPeopleWereKilled.divide(divider);
    }

    public int calculatePeopleWereKilledInAYear(int year) {
        int n1=0, n2=1, n3, deathPeople=1;
        for (int i=1; i<year; i++) {
	        n3 = n1 + n2;
	        deathPeople += n3;
	        n1=n2;
	        n2=n3;
        }
	    return deathPeople;
    }

    private boolean validateDeathAgeOfPerson(Person person1, Person person2) {
        return (person1.getDeathAge() < 0 || person2.getDeathAge() < 0) ? false : true;
    }

    private boolean validateBirthYearOfPerson(Person person1, Person person2) {
        return (person1.getBirthYear() < 0 || person2.getBirthYear() < 0) ? false : true;
    }

}
