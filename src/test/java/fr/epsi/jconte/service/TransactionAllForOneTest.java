package fr.epsi.jconte.service;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.model.impl.Person;
import fr.epsi.jconte.service.transaction.impl.TransactionAllForOne;
import fr.epsi.jconte.service.transaction.ITransaction;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;

public class TransactionAllForOneTest {

    @Test
    public void makeTransaction() throws NoSuchAlgorithmException {
        // Arrange
        IPerson person1 = new Person(1L, 10);
        IPerson person2 = new Person(2L, 30);

        // Act
        ITransaction transaction = new TransactionAllForOne();
        transaction.makeTransaction(person1, person2, false);

        // Act
        assertTrue((person1.getWealth() == 0D && person2.getWealth() == 40D) || (person1.getWealth() == 40D && person2.getWealth() == 0D));
    }
}