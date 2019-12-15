package fr.epsi.jconte.service.wealthdistribution.impl;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.service.wealthdistribution.IWealthDistribution;
import org.apache.log4j.Logger;

public class WealthDistributionConstantDistribution implements IWealthDistribution {

    public static final Logger LOGGER = Logger.getLogger(WealthDistributionConstantDistribution.class);

    private double wealth;

    public WealthDistributionConstantDistribution(double wealth) {
        this.wealth = wealth;
    }

    @Override
    public IPerson[] populate(IPerson[] persons) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Populate with constant distribution ");
        stringBuilder.append(persons.length);
        stringBuilder.append(" person(s).");
        stringBuilder.append(" Constant wealth : ");
        stringBuilder.append(wealth);

        LOGGER.info(stringBuilder.toString());
        for (int i = 0; i < persons.length; i++) {
            persons[i].setWealth(wealth);
        }
        return persons;
    }
}
