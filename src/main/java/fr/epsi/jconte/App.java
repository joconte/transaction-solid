package fr.epsi.jconte;

import fr.epsi.jconte.service.initparam.IInitParam;
import fr.epsi.jconte.service.initparam.impl.InitParamFromJSON;
import fr.epsi.jconte.service.initparam.impl.InitParamFromProperties;
import fr.epsi.jconte.service.initparam.impl.InitParamFromYAML;
import fr.epsi.jconte.service.initpopulation.impl.CreatePopulation;
import fr.epsi.jconte.service.initpopulation.ICreatePopulation;
import fr.epsi.jconte.service.interaction.IInteraction;
import fr.epsi.jconte.service.interaction.impl.InteractionRandomPersonAndOneOfHisNeighbor;
import fr.epsi.jconte.service.interaction.impl.InteractionTwoRandomPersons;
import fr.epsi.jconte.service.simulation.ISimulation;
import fr.epsi.jconte.service.simulation.impl.Simulation;
import fr.epsi.jconte.service.transaction.ITransaction;
import fr.epsi.jconte.service.transaction.impl.TransactionAllForOne;
import fr.epsi.jconte.service.transaction.impl.TransactionRandom;
import fr.epsi.jconte.service.wealthdistribution.IWealthDistribution;
import fr.epsi.jconte.service.wealthdistribution.impl.WealthDistributionConstantDistribution;
import fr.epsi.jconte.service.wealthdistribution.impl.WealthDistributionNormalDistribution;
import org.apache.log4j.BasicConfigurator;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;


public class App
{
    public static void main( String[] args ) throws IOException, ParseException, NoSuchAlgorithmException {

        // Config logger
        BasicConfigurator.configure();

        File file = new File(
                App.class.getClassLoader().getResource("init.json").getFile()
        );

        // Init param from JSON
        IInitParam initParam = new InitParamFromJSON(file);
        int numberOfPerson = initParam.getNumberOfPersons();
        int mean = initParam.getMean();
        int deviation = initParam.getDeviation();
        int numberOfIteration = initParam.getNumberOfIterations();

        // Param services
        ICreatePopulation createPopulation = new CreatePopulation(numberOfPerson);
        IWealthDistribution populateNormalDistribution = new WealthDistributionNormalDistribution(mean, deviation);
        IWealthDistribution populateConstantDistribution = new WealthDistributionConstantDistribution(mean);
        ITransaction transactionRandom = new TransactionRandom();
        IInteraction getRandomPerson = new InteractionTwoRandomPersons(false);
        IInteraction getNeighborPerson = new InteractionRandomPersonAndOneOfHisNeighbor(false);
        ITransaction transactionAllForOne = new TransactionAllForOne();

        ISimulation simulation = new Simulation(createPopulation, populateNormalDistribution, transactionRandom, getRandomPerson, numberOfIteration, false);
        simulation.makeSimulation();

        simulation = new Simulation(createPopulation, populateConstantDistribution, transactionAllForOne, getNeighborPerson, numberOfIteration, false);
        simulation.makeSimulation();

        // Init param from properties
        IInitParam initParamFromProperties = new InitParamFromProperties("init.properties");
        numberOfPerson = initParamFromProperties.getNumberOfPersons();
        mean = initParamFromProperties.getMean();
        deviation = initParamFromProperties.getDeviation();
        numberOfIteration = initParamFromProperties.getNumberOfIterations();

        // Re-param some services impacted by the param changes
        createPopulation = new CreatePopulation(numberOfPerson);
        populateNormalDistribution = new WealthDistributionNormalDistribution(mean, deviation);
        populateConstantDistribution = new WealthDistributionConstantDistribution(mean);


        simulation = new Simulation(createPopulation, populateNormalDistribution, transactionRandom, getRandomPerson, numberOfIteration, false);
        simulation.makeSimulation();

        simulation = new Simulation(createPopulation, populateConstantDistribution, transactionAllForOne, getNeighborPerson, numberOfIteration, false);
        simulation.makeSimulation();

        // Init param from YAML file
        IInitParam initParamFromYAML = new InitParamFromYAML("init.yaml");
        numberOfPerson = initParamFromYAML.getNumberOfPersons();
        mean = initParamFromYAML.getMean();
        deviation = initParamFromYAML.getDeviation();
        numberOfIteration = initParamFromYAML.getNumberOfIterations();

        // Re-param some services empacted by the param changes
        createPopulation = new CreatePopulation(numberOfPerson);
        populateNormalDistribution = new WealthDistributionNormalDistribution(mean, deviation);
        populateConstantDistribution = new WealthDistributionConstantDistribution(mean);

        simulation = new Simulation(createPopulation, populateNormalDistribution, transactionAllForOne, getRandomPerson, numberOfIteration, false);
        simulation.makeSimulation();

        simulation = new Simulation(createPopulation, populateConstantDistribution, transactionRandom, getNeighborPerson, numberOfIteration, false);
        simulation.makeSimulation();
    }
}
