package fr.epsi.jconte.service.impl;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.service.ITransaction;

public class TransactionRandom implements ITransaction {
    @Override
    public void makeTransaction(IPerson person1, IPerson person2) {
        double total = person1.getWealth() + person2.getWealth();
        double newPerson1Wealth = Math.random() * total;
        double newPerson2Wealth = total - newPerson1Wealth;

        person1.setWealth(newPerson1Wealth);
        person2.setWealth(newPerson2Wealth);
    }
}
