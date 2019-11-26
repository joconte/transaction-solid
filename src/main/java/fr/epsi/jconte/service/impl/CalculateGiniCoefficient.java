package fr.epsi.jconte.service.impl;

import fr.epsi.jconte.model.IPerson;

import java.util.Arrays;
import java.util.Comparator;

public class CalculateGiniCoefficient {

    public double getGiniCoefficient(IPerson[] persons) {

        Arrays.sort(persons, Comparator.comparing(IPerson::getWealth));

        double sumOfAbsoluteDifferences = 0;
        double subsum = 0;

        for(int i = 0; i < persons.length; i++) {
            sumOfAbsoluteDifferences += i * persons[i].getWealth() - subsum;
            subsum += persons[i].getWealth();
        }

        return sumOfAbsoluteDifferences / subsum / persons.length;
    }
}
