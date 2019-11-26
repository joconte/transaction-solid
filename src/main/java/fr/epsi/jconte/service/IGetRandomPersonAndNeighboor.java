package fr.epsi.jconte.service;

import fr.epsi.jconte.model.IPerson;
import org.javatuples.Pair;

public interface IGetRandomPersonAndNeighboor {
    Pair<IPerson, IPerson> getRandomPersonAndOneOfHisNNeighBoor(IPerson[] persons);
}
