package fr.epsi.jconte.service.impl;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.service.IGetPersonsIndexes;
import org.javatuples.Pair;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class GetRandomPersonIndexes implements IGetPersonsIndexes {

    private SecureRandom random;

    public GetRandomPersonIndexes() throws NoSuchAlgorithmException {
        this.random = SecureRandom.getInstanceStrong();
    }
    @Override
    public Pair<IPerson, IPerson> getTwoPersons(IPerson[] persons) {
        int indexPerson1 = random.nextInt(persons.length);

        int indexPerson2 = random.nextInt(persons.length);

        while (indexPerson2 == indexPerson1) {
            indexPerson2 = random.nextInt(persons.length);
        }

        return new Pair<>(persons[indexPerson1], persons[indexPerson2]);
    }
}
