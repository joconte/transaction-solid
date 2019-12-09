package fr.epsi.jconte.service.impl;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.service.IPopulate;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PopulateNormalDistribution implements IPopulate {

    private SecureRandom random = SecureRandom.getInstanceStrong();

    private double mean;

    private double deviation;

    public PopulateNormalDistribution(double mean, double deviation) throws NoSuchAlgorithmException {
        this.mean = mean;
        this.deviation = deviation;
    }

    @Override
    public IPerson[] populate(IPerson[] persons) {

        for (int i = 0; i < persons.length; i++) {
            persons[i].setWealth(random.nextGaussian() * deviation + mean);
        }
        return persons;
    }
}
