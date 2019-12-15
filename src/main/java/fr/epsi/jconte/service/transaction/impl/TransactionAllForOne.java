package fr.epsi.jconte.service.transaction.impl;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.service.utility.PrintUtiliy;
import fr.epsi.jconte.service.transaction.ITransaction;
import org.apache.log4j.Logger;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class TransactionAllForOne implements ITransaction {

    public static final Logger LOGGER = Logger.getLogger(TransactionAllForOne.class);

    private SecureRandom random;

    public TransactionAllForOne() throws NoSuchAlgorithmException {
        this.random = SecureRandom.getInstanceStrong();
    }

    @Override
    public void makeTransaction(IPerson person1, IPerson person2, boolean verbose) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("All for one transaction : \n");
        stringBuilder.append("- Before :\n");
        stringBuilder.append(PrintUtiliy.printPersonsDetails(person1, person2));
        double total = person1.getWealth() + person2.getWealth();
        int randomInt = random.nextInt(1);
        if (randomInt == 0) {
            person1.setWealth(total);
            person2.setWealth(0);
        } else {
            person2.setWealth(total);
            person1.setWealth(0);
        }
        stringBuilder.append("- After :\n");
        stringBuilder.append(PrintUtiliy.printPersonsDetails(person1, person2));

        if (verbose)
            LOGGER.info(stringBuilder.toString());
    }

    @Override
    public String myType() {
        return "All for one transaction";
    }
}
