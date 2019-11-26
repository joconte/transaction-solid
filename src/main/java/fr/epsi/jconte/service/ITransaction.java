package fr.epsi.jconte.service;

import fr.epsi.jconte.model.IPerson;

public interface ITransaction {

    void makeTransaction(IPerson person1, IPerson person2);
}
