package fr.epsi.jconte.service;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.model.impl.Person;
import fr.epsi.jconte.service.impl.CalculateGiniCoefficient;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculateGiniCoefficientTest {

    @Test
    public void getGiniCoefficient() {

        // Arrange
        IPerson[] persons = new Person[3];
        persons[0] = new Person(1L, 1);
        persons[1] = new Person(2L, 1);
        persons[2] = new Person(3L, 1);

        // Act
        CalculateGiniCoefficient calculateGiniCoefficient = new CalculateGiniCoefficient();
        double giniCoefficient = calculateGiniCoefficient.getGiniCoefficient(persons);

        // Assert
        assertEquals(giniCoefficient ,0, 0.0);
    }
}