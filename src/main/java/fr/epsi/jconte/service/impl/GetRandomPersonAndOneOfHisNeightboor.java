package fr.epsi.jconte.service.impl;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.service.IGetPersonsIndexes;
import org.javatuples.Pair;

import java.security.SecureRandom;

public class GetRandomPersonAndOneOfHisNeightboor implements IGetPersonsIndexes {
    @Override
    public Pair<IPerson, IPerson> getTwoPersons(IPerson[] persons) {

        int indexPerson1 = new SecureRandom().nextInt(persons.length);

        int indexPerson2 = indexPerson1 < persons.length - 1 ? indexPerson1 + 1 : indexPerson1 - 1;

        Pair<IPerson, IPerson> personIPersonPair = new Pair<>(persons[indexPerson1], persons[indexPerson2]);

        return personIPersonPair;
    }
}
