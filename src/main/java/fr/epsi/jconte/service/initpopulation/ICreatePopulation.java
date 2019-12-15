package fr.epsi.jconte.service.initpopulation;

import fr.epsi.jconte.model.IPerson;

public interface ICreatePopulation {

    IPerson[] initPopulationNoWealth();

    int getNumberOfPerson();
}
