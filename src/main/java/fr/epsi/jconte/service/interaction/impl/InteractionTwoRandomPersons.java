package fr.epsi.jconte.service.interaction.impl;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.service.utility.PrintUtiliy;
import fr.epsi.jconte.service.interaction.IInteraction;
import org.apache.log4j.Logger;
import org.javatuples.Pair;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Provides methods for the interactions of 2 random persons.
 */
public class InteractionTwoRandomPersons implements IInteraction {

    public static final Logger LOGGER = Logger.getLogger(InteractionTwoRandomPersons.class);

    private SecureRandom random;

    private boolean verbose;

    public InteractionTwoRandomPersons(boolean verbose) throws NoSuchAlgorithmException {
        this.random = SecureRandom.getInstanceStrong();
        this.verbose = verbose;
    }

    /**
     * Return a pair of IPerson randomly picked in IPerson[].
     * @param persons
     * @return
     */
    @Override
    public Pair<IPerson, IPerson> getTwoPersons(IPerson[] persons) {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Pick 2 random persons : \n");

        int indexPerson1 = random.nextInt(persons.length);

        int indexPerson2 = random.nextInt(persons.length);

        while (indexPerson2 == indexPerson1) {
            indexPerson2 = random.nextInt(persons.length);
        }

        stringBuilder.append(PrintUtiliy.printPersonsDetails(persons[indexPerson1], persons[indexPerson2]));

        if (verbose)
            LOGGER.info(stringBuilder.toString());

        return new Pair<>(persons[indexPerson1], persons[indexPerson2]);
    }

    /**
     * Return the type of the interaction.
     * @return
     */
    @Override
    public String myType() {
        return "Pick two random persons";
    }
}
