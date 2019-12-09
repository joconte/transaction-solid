package fr.epsi.jconte.service.impl;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.service.IPopulate;

import java.util.Random;

public class PopulateConstantDistribution implements IPopulate {

    private double wealth;

    public PopulateConstantDistribution(double wealth) {
        this.wealth = wealth;
    }

    @Override
    public IPerson[] populate(IPerson[] persons) {
        Random r = new Random();

        for (int i = 0; i < persons.length; i++) {
            persons[i].setWealth(wealth);
        }
        return persons;
    }
}
