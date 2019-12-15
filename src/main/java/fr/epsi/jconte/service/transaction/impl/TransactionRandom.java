package fr.epsi.jconte.service.transaction.impl;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.service.utility.PrintUtiliy;
import fr.epsi.jconte.service.transaction.ITransaction;
import org.apache.log4j.Logger;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class TransactionRandom implements ITransaction {

    public static final Logger LOGGER = Logger.getLogger(TransactionRandom.class);

    private SecureRandom random;

    public TransactionRandom() throws NoSuchAlgorithmException {
        this.random = SecureRandom.getInstanceStrong();
    }

    @Override
    public void makeTransaction(IPerson person1, IPerson person2, boolean verbose) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("All for one transaction : \n");
        stringBuilder.append("- Before :\n");
        stringBuilder.append(PrintUtiliy.printPersonsDetails(person1, person2));

        double total = person1.getWealth() + person2.getWealth();
        double newPerson1Wealth = random.nextDouble() * total;
        double newPerson2Wealth = total - newPerson1Wealth;

        person1.setWealth(newPerson1Wealth);
        person2.setWealth(newPerson2Wealth);

        stringBuilder.append("All for one transaction : \n");
        stringBuilder.append("- Before :\n");
        stringBuilder.append(PrintUtiliy.printPersonsDetails(person1, person2));

        if (verbose)
            LOGGER.info(stringBuilder.toString());
    }

    @Override
    public String myType() {
        return "Random transaction";
    }

}
