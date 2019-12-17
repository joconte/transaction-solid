package fr.epsi.jconte.service.utility;

import fr.epsi.jconte.model.IPerson;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Provides methods to calculate Gini Coefficient.
 */
public class CalculateGiniCoefficient {

    /**
     * Return the Gini Coefficient of a IPerson population (IPerson[]).
     * @param persons
     * @return
     */
    public double getGiniCoefficient(IPerson[] persons) {

        Arrays.sort(persons, Comparator.comparing(IPerson::getWealth));

        double sumOfAbsoluteDifferences = 0;
        double subsum = 0;

        for(int i = 0; i < persons.length; i++) {
            sumOfAbsoluteDifferences += i * persons[i].getWealth() - subsum;
            subsum += persons[i].getWealth();
        }

        if (subsum == 0)
            return 0;

        return sumOfAbsoluteDifferences / subsum / persons.length;
    }
}
