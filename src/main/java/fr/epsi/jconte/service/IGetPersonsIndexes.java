package fr.epsi.jconte.service;

import fr.epsi.jconte.model.IPerson;
import org.javatuples.Pair;

public interface IGetPersonsIndexes {

    Pair<IPerson, IPerson> getTwoRandomPerson(IPerson[] persons);
}
