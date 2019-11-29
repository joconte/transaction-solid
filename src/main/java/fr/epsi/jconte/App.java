package fr.epsi.jconte;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.service.ICreatePopulation;
import fr.epsi.jconte.service.IGetPersonsIndexes;
import fr.epsi.jconte.service.IPopulateNormalDistribution;
import fr.epsi.jconte.service.ITransaction;
import fr.epsi.jconte.service.impl.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.javatuples.Pair;


public class App
{
    public static void main( String[] args )
    {

        Logger logger = Logger.getLogger(App.class);
        BasicConfigurator.configure();
        ICreatePopulation createPopulation = new CreatePopulation();
        IPopulateNormalDistribution populateNormalDistribution = new PopulateNormalDistribution();

        int taillePopulation = 100;

        logger.info("Create a population of " + taillePopulation + " persons");
        IPerson[] persons = createPopulation.initPopulationNoWealth(taillePopulation);

        double mean = 100;
        double deviation = 20;

        populateNormalDistribution.populate(persons, mean, deviation);

        logger.info("Add wealth to our population using a normal distribution of mean 100 and deviation 20");

        CalculateGiniCoefficient calculateGiniCoefficient = new CalculateGiniCoefficient();
        logger.info("Gini coefficient before any transaction :" + calculateGiniCoefficient.getGiniCoefficient(persons));

        ITransaction transactionRandom = new TransactionRandom();
        IGetPersonsIndexes getRandomPerson = new GetRandomPersonIndexes();

        int nombreIteration = 1000;

        logger.info("Do " + nombreIteration + " iterations with random transaction between the population");

        for (int i = 0; i < nombreIteration; i++) {

            Pair<IPerson, IPerson> personPair = getRandomPerson.getTwoRandomPerson(persons);

            transactionRandom.makeTransaction(personPair.getValue0(), personPair.getValue1());
        }

        logger.info("Gini coefficient after " + nombreIteration + " random transactions :" + calculateGiniCoefficient.getGiniCoefficient(persons));

        logger.info("Now we will try with a all for one transaction.");

        logger.info("Re init the population wealth");

        populateNormalDistribution.populate(persons, mean, deviation);

        logger.info("Gini coefficient before any transaction :" + calculateGiniCoefficient.getGiniCoefficient(persons));

        ITransaction transactionAllForOne = new TransactionAllForOne();

        logger.info("Do " + nombreIteration + " iterations with random transaction between the population");

        for (int i = 0; i < nombreIteration; i++) {

            Pair<IPerson, IPerson> personPair = getRandomPerson.getTwoRandomPerson(persons);

            transactionAllForOne.makeTransaction(personPair.getValue0(), personPair.getValue1());
        }

        logger.info("Gini coefficient after " + nombreIteration + " all for one transactions :" + calculateGiniCoefficient.getGiniCoefficient(persons));

    }
}
