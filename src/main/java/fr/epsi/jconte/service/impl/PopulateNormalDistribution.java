package fr.epsi.jconte.service.impl;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.service.IPopulate;

import java.util.Random;

public class PopulateNormalDistribution implements IPopulate {

    private double mean;

    private double deviation;

    public PopulateNormalDistribution(double mean, double deviation) {
        this.mean = mean;
        this.deviation = deviation;
    }

    @Override
    public IPerson[] populate(IPerson[] persons) {

        Random r = new Random();

        for (int i = 0; i < persons.length; i++) {
            persons[i].setWealth(r.nextGaussian() * deviation + mean);
        }
        return persons;
    }
}
