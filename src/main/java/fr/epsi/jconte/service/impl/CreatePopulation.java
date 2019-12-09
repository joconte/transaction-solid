package fr.epsi.jconte.service.impl;

import fr.epsi.jconte.model.impl.Person;
import fr.epsi.jconte.service.ICreatePopulation;

public class CreatePopulation implements ICreatePopulation {

    private int numberOfPerson;

    public CreatePopulation(int numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    @Override
    public Person[] initPopulationNoWealth() {
        Person[] persons = new Person[numberOfPerson];
        Long i = 1L;

        for (int j = 0; j < persons.length; j++) {
            persons[j] = new Person(i, 0);
            i += 1L;
        }
        return persons;
    }

    @Override
    public int getNumberOfPerson() {
        return this.numberOfPerson;
    }
}
