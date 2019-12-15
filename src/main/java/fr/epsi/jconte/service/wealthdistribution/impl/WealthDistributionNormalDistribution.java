package fr.epsi.jconte.service.wealthdistribution.impl;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.service.wealthdistribution.IWealthDistribution;
import org.apache.log4j.Logger;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class WealthDistributionNormalDistribution implements IWealthDistribution {

    public static final Logger LOGGER = Logger.getLogger(WealthDistributionNormalDistribution.class);

    private SecureRandom random;

    private double mean;

    private double deviation;

    public WealthDistributionNormalDistribution(double mean, double deviation) throws NoSuchAlgorithmException {
        this.mean = mean;
        this.deviation = deviation;
        this.random = SecureRandom.getInstanceStrong();
    }

    @Override
    public IPerson[] populate(IPerson[] persons) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Populate with normal distribution ");
        stringBuilder.append(persons.length);
        stringBuilder.append(" person(s). ");
        stringBuilder.append(" Mean : ");
        stringBuilder.append(mean);
        stringBuilder.append(", Deviation : ");
        stringBuilder.append(deviation);

        LOGGER.info(stringBuilder.toString());

        for (int i = 0; i < persons.length; i++) {
            persons[i].setWealth(random.nextGaussian() * deviation + mean);
        }
        return persons;
    }
}
