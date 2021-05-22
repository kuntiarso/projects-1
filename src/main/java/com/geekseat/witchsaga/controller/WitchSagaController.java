package com.geekseat.witchsaga.controller;

import com.geekseat.witchsaga.model.Person;
import com.geekseat.witchsaga.model.WitchSaga;
import com.geekseat.witchsaga.service.WitchSagaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WitchSagaController {
    
    @Autowired
    private WitchSagaService witchSagaService;

    @GetMapping("/stop-the-witch")
    public ResponseEntity<?> actions(@RequestParam("deathAgePerson1") int deathAgePerson1,
            @RequestParam("deathYearPerson1") int deathYearPerson1,
            @RequestParam("deathAgePerson2") int deathAgePerson2,
            @RequestParam("deathYearPerson2") int deathYearPerson2) {
        Person person1 = new Person(deathAgePerson1, deathYearPerson1);
        Person person2 = new Person(deathAgePerson2, deathYearPerson2);
        WitchSaga result = witchSagaService.gettingRidOfTheWitch(person1, person2);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
