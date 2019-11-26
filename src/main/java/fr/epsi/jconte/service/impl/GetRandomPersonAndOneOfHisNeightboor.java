package fr.epsi.jconte.service.impl;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.service.IGetRandomPersonAndNeighboor;
import org.javatuples.Pair;

import java.util.Random;

public class GetRandomPersonAndOneOfHisNeightboor implements IGetRandomPersonAndNeighboor {
    @Override
    public Pair<IPerson, IPerson> getRandomPersonAndOneOfHisNNeighBoor(IPerson[] persons) {

        int indexPerson1 = new Random().nextInt(persons.length);

        int indexPerson2 = indexPerson1 < persons.length - 1 ? indexPerson1 + 1 : indexPerson1 - 1;

        Pair<IPerson, IPerson> personIPersonPair = new Pair<IPerson, IPerson>(persons[indexPerson1], persons[indexPerson2]);

        return personIPersonPair;
    }
}
