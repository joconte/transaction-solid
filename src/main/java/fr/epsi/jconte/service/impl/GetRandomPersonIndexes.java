package fr.epsi.jconte.service.impl;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.service.IGetPersonsIndexes;
import org.javatuples.Pair;

import java.util.Random;

public class GetRandomPersonIndexes implements IGetPersonsIndexes {

    @Override
    public Pair<IPerson, IPerson> getTwoPersons(IPerson[] persons) {
        int indexPerson1 = new Random().nextInt(persons.length);

        int indexPerson2 = new Random().nextInt(persons.length);

        while (indexPerson2 == indexPerson1) {
            indexPerson2 = new Random().nextInt(persons.length);
        }

        Pair<IPerson, IPerson> personIPersonPair = new Pair<IPerson, IPerson>(persons[indexPerson1], persons[indexPerson2]);

        return personIPersonPair;
    }
}
