package fr.epsi.jconte.service.initpopulation;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.service.initpopulation.impl.CreatePopulation;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreatePopulationTest {

    @Test
    public void initPopulationNoWealth() {

        // Arrange
        int nbOfPeople = 100;
        ICreatePopulation createPopulation = new CreatePopulation(nbOfPeople);

        // Act
        IPerson[] persons = createPopulation.initPopulationNoWealth();

        // Assert
        assertEquals(persons[0].getId(), 1L, 0.0);
        assertEquals(persons[0].getWealth(), 0, 0.0);
        assertEquals(persons[99].getId(), 100L, 0.0);
        assertEquals(persons[0].getWealth(), 0, 0.0);
    }

    @Test
    public void getNumberOfPerson() {

        // Arrange
        int nbOfPeople = 100;
        ICreatePopulation createPopulation = new CreatePopulation(nbOfPeople);

        // Act
        int nbOfPersons = createPopulation.getNumberOfPerson();

        // Assert
        assertEquals(nbOfPeople, nbOfPersons);
    }
}