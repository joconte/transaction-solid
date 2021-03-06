package fr.epsi.jconte.service.wealthdistribution;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.model.impl.Person;
import fr.epsi.jconte.service.wealthdistribution.impl.WealthDistributionConstantDistribution;
import fr.epsi.jconte.service.wealthdistribution.impl.WealthDistributionNormalDistribution;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;

public class WealthDistributionNormalDistributionTest {

    @Test
    public void populate() throws NoSuchAlgorithmException {
        // Arrange
        IPerson[] persons = new IPerson[10];
        IPerson person1 = new Person(1L, 0);
        IPerson person2 = new Person(2L, 0);
        IPerson person3 = new Person(3L, 0);
        IPerson person4 = new Person(4L, 0);
        IPerson person5 = new Person(5L, 0);
        IPerson person6 = new Person(6L, 0);
        IPerson person7 = new Person(7L, 0);
        IPerson person8 = new Person(8L, 0);
        IPerson person9 = new Person(9L, 0);
        IPerson person10 = new Person(10L, 0);
        persons[0] = person1;
        persons[1] = person2;
        persons[2] = person3;
        persons[3] = person4;
        persons[4] = person5;
        persons[5] = person6;
        persons[6] = person7;
        persons[7] = person8;
        persons[8] = person9;
        persons[9] = person10;

        double mean = 100;
        double deviation = 20;

        // Act
        IWealthDistribution wealthDistribution = new WealthDistributionNormalDistribution(mean, deviation);
        wealthDistribution.populate(persons);

        // Assert
        assertTrue(person1.getWealth() != 0);
        assertTrue(person2.getWealth() != 0);
        assertTrue(person3.getWealth() != 0);
        assertTrue(person4.getWealth() != 0);
        assertTrue(person5.getWealth() != 0);
        assertTrue(person6.getWealth() != 0);
        assertTrue(person7.getWealth() != 0);
        assertTrue(person8.getWealth() != 0);
        assertTrue(person9.getWealth() != 0);
        assertTrue(person10.getWealth() != 0);
    }
}