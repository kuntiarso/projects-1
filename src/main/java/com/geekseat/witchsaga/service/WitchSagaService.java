package com.geekseat.witchsaga.service;

import java.math.BigDecimal;

import com.geekseat.witchsaga.model.Person;
import com.geekseat.witchsaga.model.WitchSaga;

public interface WitchSagaService {

    public WitchSaga gettingRidOfTheWitch(Person person1, Person person2);

    public BigDecimal calculateAveragePeopleWereKilled(int total1, int total2);

    public int calculatePeopleWereKilledInAYear(int year);

}
