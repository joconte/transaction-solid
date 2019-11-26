package fr.epsi.jconte.service;

import fr.epsi.jconte.model.IPerson;

public interface IPopulateNormalDistribution {

    IPerson[] populate(IPerson[] persons, double mean, double deviation);
}
