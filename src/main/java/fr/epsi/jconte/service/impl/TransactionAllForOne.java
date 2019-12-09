package fr.epsi.jconte.service.impl;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.service.ITransaction;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class TransactionAllForOne implements ITransaction {

    private SecureRandom random = SecureRandom.getInstanceStrong();

    public TransactionAllForOne() throws NoSuchAlgorithmException {
    }

    @Override
    public void makeTransaction(IPerson person1, IPerson person2) {
        double total = person1.getWealth() + person2.getWealth();
        int randomInt = random.nextInt(1);
        if (randomInt == 0) {
            person1.setWealth(total);
            person2.setWealth(0);
        } else {
            person2.setWealth(total);
            person1.setWealth(0);
        }
    }
}
