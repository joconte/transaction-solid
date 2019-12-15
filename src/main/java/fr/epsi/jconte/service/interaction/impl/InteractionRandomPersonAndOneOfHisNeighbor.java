package fr.epsi.jconte.service.interaction.impl;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.service.utility.PrintUtiliy;
import fr.epsi.jconte.service.interaction.IInteraction;
import org.apache.log4j.Logger;
import org.javatuples.Pair;

import java.security.SecureRandom;

public class InteractionRandomPersonAndOneOfHisNeighbor implements IInteraction {

    public static final Logger LOGGER = Logger.getLogger(InteractionRandomPersonAndOneOfHisNeighbor.class);

    private boolean verbose;

    public InteractionRandomPersonAndOneOfHisNeighbor(boolean verbose) {
        this.verbose = verbose;
    }

    @Override
    public Pair<IPerson, IPerson> getTwoPersons(IPerson[] persons) {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Pick random persons and one of his neighbor : \n");

        int indexPerson1 = new SecureRandom().nextInt(persons.length);

        int indexPerson2 = indexPerson1 < persons.length - 1 ? indexPerson1 + 1 : indexPerson1 - 1;

        stringBuilder.append(PrintUtiliy.printPersonsDetails(persons[indexPerson1], persons[indexPerson2]));

        if (verbose)
            LOGGER.info(stringBuilder.toString());

        return new Pair<>(persons[indexPerson1], persons[indexPerson2]);
    }

    @Override
    public String myType() {
        return "A random person and one of his neighbor";
    }
}
