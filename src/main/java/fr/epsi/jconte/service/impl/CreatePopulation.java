package fr.epsi.jconte.service.impl;

import fr.epsi.jconte.model.impl.Person;
import fr.epsi.jconte.service.ICreatePopulation;

public class CreatePopulation implements ICreatePopulation {
    @Override
    public Person[] initPopulationNoWealth(int numberOfPerson) {
        Person[] persons = new Person[numberOfPerson];
        Long i = 1L;

        for (int j = 0; j < persons.length; j++) {
            persons[j] = new Person(i, 0);
            i += 1L;
        }
        /*
        for (Person person : persons) {
            person = new Person(i, 0);
            person.setId(i);
            i += 1L;
        }*/
        return persons;
    }
}
