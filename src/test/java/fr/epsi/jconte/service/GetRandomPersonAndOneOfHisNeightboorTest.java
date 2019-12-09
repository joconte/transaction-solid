package fr.epsi.jconte.service;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.model.impl.Person;
import fr.epsi.jconte.service.impl.GetRandomPersonAndOneOfHisNeightboor;
import org.javatuples.Pair;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetRandomPersonAndOneOfHisNeightboorTest {

    @Test
    public void getRandomPersonAndOneOfHisNNeighBoor() {

        // Arrange
        IGetPersonsIndexes getRandomPersonAndNeighboor = new GetRandomPersonAndOneOfHisNeightboor();
        IPerson[] persons = new IPerson[10];
        IPerson person1 = new Person(1L, 10);
        IPerson person2 = new Person(2L, 10);
        IPerson person3 = new Person(3L, 10);
        IPerson person4 = new Person(4L, 10);
        IPerson person5 = new Person(5L, 10);
        IPerson person6 = new Person(6L, 10);
        IPerson person7 = new Person(7L, 10);
        IPerson person8 = new Person(8L, 10);
        IPerson person9 = new Person(9L, 10);
        IPerson person10 = new Person(10L, 10);
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

        // Act
        Pair<IPerson, IPerson> pairs = getRandomPersonAndNeighboor.getTwoPersons(persons);

        // Assert
        assertTrue(Math.abs(pairs.getValue0().getId() - pairs.getValue1().getId()) == 1);
    }
}