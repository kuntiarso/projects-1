package com.geekseat.witchsaga.model;

public class Person extends PersonImpact {
    private int ageOfDeath;
    private int yearOfDeath;
    private int yearOfBirth;

    public Person(int ageOfDeath, int yearOfDeath) {
        this.ageOfDeath = ageOfDeath;
        this.yearOfDeath = yearOfDeath;
        this.yearOfBirth = yearOfDeath - ageOfDeath;
    }

    public int getDeathAge() {
        return ageOfDeath;
    }

    public int getDeathYear() {
        return yearOfDeath;
    }

    public int getBirthYear() {
        return yearOfBirth;
    }
}
