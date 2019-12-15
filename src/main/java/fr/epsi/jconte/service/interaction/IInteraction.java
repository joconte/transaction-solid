package fr.epsi.jconte.service.interaction;

import fr.epsi.jconte.model.IPerson;
import org.javatuples.Pair;

public interface IInteraction {

    Pair<IPerson, IPerson> getTwoPersons(IPerson[] persons);

    String myType();
}
