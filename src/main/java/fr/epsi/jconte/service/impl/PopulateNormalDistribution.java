package fr.epsi.jconte.service.impl;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.service.IPopulateNormalDistribution;

import java.util.Random;

public class PopulateNormalDistribution implements IPopulateNormalDistribution {
    @Override
    public IPerson[] populate(IPerson[] persons, double mean, double deviation) {

        Random r = new Random();

        for (int i = 0; i < persons.length; i++) {
            persons[i].setWealth(r.nextGaussian() * deviation + mean);
        }
        /*
        for (Person person : persons) {
            person.setWealth(r.nextGaussian() * deviation + mean);
        }*/
        return persons;
    }
}
