package fr.epsi.jconte.service.transaction;

import fr.epsi.jconte.model.IPerson;

public interface ITransaction {

    void makeTransaction(IPerson person1, IPerson person2, boolean verbose);

    String myType();

}
