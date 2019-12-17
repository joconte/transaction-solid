package fr.epsi.jconte.service.initpopulation.impl;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.model.impl.Person;
import fr.epsi.jconte.service.initpopulation.ICreatePopulation;
import org.apache.log4j.Logger;

/**
 * Provide methods to create population of IPerson.
 */
public class CreatePopulation implements ICreatePopulation {

    public static final Logger LOGGER = Logger.getLogger(CreatePopulation.class);

    private int numberOfPerson;

    public CreatePopulation(int numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    /**
     * Create a "population" (IPerson[]) with no wealth.
     * @return
     */
    @Override
    public IPerson[] initPopulationNoWealth() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Init a population of ");
        stringBuilder.append(numberOfPerson);
        stringBuilder.append(" person(s) with no wealth.");
        LOGGER.info(stringBuilder.toString());

        IPerson[] persons = new IPerson[numberOfPerson];
        Long i = 1L;

        for (int j = 0; j < persons.length; j++) {
            persons[j] = new Person(i, 0);
            i += 1L;
        }
        return persons;
    }

    /**
     * Return the number of persons.
     * @return
     */
    @Override
    public int getNumberOfPerson() {
        return this.numberOfPerson;
    }
}
