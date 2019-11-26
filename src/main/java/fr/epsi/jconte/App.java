package fr.epsi.jconte;

import fr.epsi.jconte.model.IPerson;
import fr.epsi.jconte.service.ICreatePopulation;
import fr.epsi.jconte.service.IGetPersonsIndexes;
import fr.epsi.jconte.service.IPopulateNormalDistribution;
import fr.epsi.jconte.service.ITransaction;
import fr.epsi.jconte.service.impl.*;
import org.javatuples.Pair;


public class App
{
    public static void main( String[] args )
    {

        ICreatePopulation createPopulation = new CreatePopulation();
        IPopulateNormalDistribution populateNormalDistribution = new PopulateNormalDistribution();

        int taillePopulation = 100;

        System.out.println("Create a population of " + taillePopulation + " persons");
        IPerson[] persons = createPopulation.initPopulationNoWealth(taillePopulation);

        double mean = 100;
        double deviation = 20;

        populateNormalDistribution.populate(persons, mean, deviation);

        System.out.println("Add wealth to our population using a normal distribution of mean 100 and deviation 20");

        CalculateGiniCoefficient calculateGiniCoefficient = new CalculateGiniCoefficient();
        System.out.println("Gini coefficient before any transaction :" + calculateGiniCoefficient.getGiniCoefficient(persons));

        ITransaction transactionRandom = new TransactionRandom();
        IGetPersonsIndexes getRandomPerson = new GetRandomPersonIndexes();

        int nombreIteration = 1000;

        System.out.println("Do " + nombreIteration + " iterations with random transaction between the population");

        for (int i = 0; i < nombreIteration; i++) {

            Pair<IPerson, IPerson> personPair = getRandomPerson.getTwoRandomPerson(persons);

            transactionRandom.makeTransaction(personPair.getValue0(), personPair.getValue1());
        }

        System.out.println("Gini coefficient after " + nombreIteration + " random transactions :" + calculateGiniCoefficient.getGiniCoefficient(persons));

        System.out.println("Now we will try with a all for one transaction.");

        System.out.println("Re init the population wealth");

        populateNormalDistribution.populate(persons, mean, deviation);

        System.out.println("Gini coefficient before any transaction :" + calculateGiniCoefficient.getGiniCoefficient(persons));

        ITransaction transactionAllForOne = new TransactionAllForOne();

        System.out.println("Do " + nombreIteration + " iterations with random transaction between the population");

        for (int i = 0; i < nombreIteration; i++) {

            Pair<IPerson, IPerson> personPair = getRandomPerson.getTwoRandomPerson(persons);

            transactionAllForOne.makeTransaction(personPair.getValue0(), personPair.getValue1());
        }

        System.out.println("Gini coefficient after " + nombreIteration + " all for one transactions :" + calculateGiniCoefficient.getGiniCoefficient(persons));

    }
}
