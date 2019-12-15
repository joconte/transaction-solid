package fr.epsi.jconte.service.transaction;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.model.impl.Person;
import fr.epsi.jconte.service.transaction.impl.TransactionRandom;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertTrue;

public class TransactionRandomTest {

    @Test
    public void makeTransaction() throws NoSuchAlgorithmException {

        // Arrange
        IPerson person1 = new Person(1L, 10);
        IPerson person2 = new Person(2L, 30);

        // Act
        ITransaction transaction = new TransactionRandom();
        transaction.makeTransaction(person1, person2, false);

        // Act
        assertTrue(person1.getWealth() + person2.getWealth() == 40);
    }

    @Test
    public void myType() throws NoSuchAlgorithmException {

        // Act
        ITransaction transaction = new TransactionRandom();
        String myType = transaction.myType();

        // Assert
        assertTrue(myType.equals("Random transaction"));
    }
}