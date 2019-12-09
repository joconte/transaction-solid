package fr.epsi.jconte;

import fr.epsi.jconte.service.*;
import fr.epsi.jconte.service.impl.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.security.NoSuchAlgorithmException;


public class App
{
    public static void main( String[] args ) throws IOException, ParseException, NoSuchAlgorithmException {

        // Parametrage
        Logger logger = Logger.getLogger(App.class);

        JSONParser jsonParser = new JSONParser();

        File file = new File(
                App.class.getClassLoader().getResource("init.json").getFile()
        );

        FileReader fileReader = new FileReader(file);
        Object obj = jsonParser.parse(fileReader);
        JSONObject jsonObject = (JSONObject)obj;
        Long numberOfPersonLong = (Long)jsonObject.get("taillePopulation");
        Long meanLong = (Long)jsonObject.get("mean");
        Long deviationLong = (Long)jsonObject.get("deviation");
        Long nombreIterationLong = (Long)jsonObject.get("nombreIteration");
        int numberOfPerson = numberOfPersonLong.intValue();
        int mean = meanLong.intValue();
        int deviation = deviationLong.intValue();
        int numberOfIteration = nombreIterationLong.intValue();

/*
        int numberOfPerson = 100;
        int mean = 100;
        int deviation = 20;
        int numberOfIteration = 1000;
 */
        int wealth = 100;

        BasicConfigurator.configure();
        ICreatePopulation createPopulation = new CreatePopulation(numberOfPerson);
        IPopulate populateNormalDistribution = new PopulateNormalDistribution(mean, deviation);
        IPopulate populateConstantDistribution = new PopulateConstantDistribution(wealth);
        ITransaction transactionRandom = new TransactionRandom();
        IGetPersonsIndexes getRandomPerson = new GetRandomPersonIndexes();
        IGetPersonsIndexes getNeighboorPerson = new GetRandomPersonAndOneOfHisNeightboor();
        ITransaction transactionAllForOne = new TransactionAllForOne();

        logger.info("Simulation avec une distribution normale de moyenne 100 et ecart type 20. Transaction random.");
        Simulation simulation = new Simulation(createPopulation, populateNormalDistribution, transactionRandom, getRandomPerson, numberOfIteration);
        simulation.makeSimulation();

        logger.info("Simulation avec une distribution constante de 100. Transaction voisin seulement, all for one.");
        simulation = new Simulation(createPopulation, populateConstantDistribution, transactionAllForOne, getNeighboorPerson, numberOfIteration);
        simulation.makeSimulation();


    }
}
