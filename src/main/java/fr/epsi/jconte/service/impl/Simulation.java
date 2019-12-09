package fr.epsi.jconte.service.impl;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.service.*;
import org.apache.log4j.Logger;
import org.javatuples.Pair;

public class Simulation implements ISimulation {

    Logger logger = Logger.getLogger(Simulation.class);

    private ICreatePopulation createPopulation;

    private IPopulate populate;

    private CalculateGiniCoefficient calculateGiniCoefficient;

    private ITransaction transaction;

    private IGetPersonsIndexes getPersonsIndexes;

    private int nombreIteration;

    public Simulation(ICreatePopulation createPopulation, IPopulate populate, ITransaction transaction, IGetPersonsIndexes getPersonsIndexes, int nombreIteration) {
        this.createPopulation = createPopulation;
        this.populate = populate;
        this.transaction = transaction;
        this.getPersonsIndexes = getPersonsIndexes;
        this.calculateGiniCoefficient = new CalculateGiniCoefficient();
        this.nombreIteration = nombreIteration;
    }

    @Override
    public void makeSimulation() {

        logger.info("Create a population of " + createPopulation.getNumberOfPerson() + " persons");
        IPerson[] persons = createPopulation.initPopulationNoWealth();

        populate.populate(persons);

        logger.info("Gini coefficient before any transaction :" + calculateGiniCoefficient.getGiniCoefficient(persons));

        logger.info("Do " + nombreIteration + " iterations");

        for (int i = 0; i < nombreIteration; i++) {

            Pair<IPerson, IPerson> personPair = getPersonsIndexes.getTwoPersons(persons);

            transaction.makeTransaction(personPair.getValue0(), personPair.getValue1());
        }

        logger.info("Gini coefficient after " + nombreIteration + " transactions :" + calculateGiniCoefficient.getGiniCoefficient(persons));
    }
}
