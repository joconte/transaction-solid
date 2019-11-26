package fr.epsi.jconte.service.impl;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.service.ITransaction;

import java.util.Random;

public class TransactionAllForOne implements ITransaction {
    @Override
    public void makeTransaction(IPerson person1, IPerson person2) {
        Random r = new Random();
        double total = person1.getWealth() + person2.getWealth();
        int random = r.nextInt(1);
        if (random == 0) {
            person1.setWealth(total);
            person2.setWealth(0);
        } else {
            person2.setWealth(total);
            person1.setWealth(0);
        }
    }
}
