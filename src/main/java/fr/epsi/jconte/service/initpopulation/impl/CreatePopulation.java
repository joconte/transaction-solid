package fr.epsi.jconte.service.initpopulation.impl;

import fr.epsi.jconte.model.impl.Person;
import fr.epsi.jconte.service.initpopulation.ICreatePopulation;
import org.apache.log4j.Logger;

public class CreatePopulation implements ICreatePopulation {

    public static final Logger LOGGER = Logger.getLogger(CreatePopulation.class);

    private int numberOfPerson;

    public CreatePopulation(int numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    @Override
    public Person[] initPopulationNoWealth() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Init a population of ");
        stringBuilder.append(numberOfPerson);
        stringBuilder.append(" person(s) with no wealth.");
        LOGGER.info(stringBuilder.toString());

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
