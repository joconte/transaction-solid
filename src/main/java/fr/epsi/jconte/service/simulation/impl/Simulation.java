package fr.epsi.jconte.service.simulation.impl;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.service.initpopulation.ICreatePopulation;
import fr.epsi.jconte.service.utility.CalculateGiniCoefficient;
import fr.epsi.jconte.service.interaction.IInteraction;
import fr.epsi.jconte.service.simulation.ISimulation;
import fr.epsi.jconte.service.transaction.ITransaction;
import fr.epsi.jconte.service.wealthdistribution.IWealthDistribution;
import org.apache.log4j.Logger;
import org.javatuples.Pair;

/**
 * Provides methods to run the economical simulation.
 */
public class Simulation implements ISimulation {

    public static final Logger LOGGER = Logger.getLogger(Simulation.class);

    private ICreatePopulation createPopulation;

    private IWealthDistribution populate;

    private CalculateGiniCoefficient calculateGiniCoefficient;

    private ITransaction transaction;

    private IInteraction interaction;

    private int numberOfIteration;

    private boolean verbose;

    public Simulation(ICreatePopulation createPopulation, IWealthDistribution populate, ITransaction transaction, IInteraction interaction, int numberOfIteration, boolean verbose) {
        this.createPopulation = createPopulation;
        this.populate = populate;
        this.transaction = transaction;
        this.interaction = interaction;
        this.calculateGiniCoefficient = new CalculateGiniCoefficient();
        this.numberOfIteration = numberOfIteration;
        this.verbose = verbose;
    }

    /**
     * Run the economical simulation.
     */
    @Override
    public void makeSimulation() {

        LOGGER.info("\n");
        LOGGER.info("New simulation.");
        LOGGER.info("Create a population of " + createPopulation.getNumberOfPerson() + " persons");
        IPerson[] persons = createPopulation.initPopulationNoWealth();

        populate.populate(persons);

        LOGGER.info("Gini coefficient before any transaction :" + calculateGiniCoefficient.getGiniCoefficient(persons));

        LOGGER.info("Do " + numberOfIteration + " iterations with : Transaction : " + transaction.myType() + ", Interaction : " + interaction.myType());

        for (int i = 0; i < numberOfIteration; i++) {

            Pair<IPerson, IPerson> personPair = interaction.getTwoPersons(persons);

            transaction.makeTransaction(personPair.getValue0(), personPair.getValue1(), verbose);
        }

        LOGGER.info("Gini coefficient after " + numberOfIteration + " transactions :" + calculateGiniCoefficient.getGiniCoefficient(persons));
        LOGGER.info("End of the simulation \n");
    }
}
