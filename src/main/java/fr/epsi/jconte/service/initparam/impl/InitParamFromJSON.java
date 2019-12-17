package fr.epsi.jconte.service.initparam.impl;

import fr.epsi.jconte.service.utility.PrintUtiliy;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Provide methods to initialize parameters from JSON files.
 */
public class InitParamFromJSON extends InitParam{

    public static final Logger LOGGER = Logger.getLogger(InitParamFromJSON.class);

    /**
     * Initialize parameters from JSON File.
     * @param jsonFile
     * @throws IOException
     * @throws ParseException
     */
    public InitParamFromJSON(File jsonFile) throws IOException, ParseException {

        StringBuilder stringBuilder = new StringBuilder();
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader(jsonFile);
        Object obj = jsonParser.parse(fileReader);
        JSONObject jsonObject = (JSONObject)obj;
        Long numberOfPersonLong = (Long)jsonObject.get("taillePopulation");
        Long meanLong = (Long)jsonObject.get("mean");
        Long deviationLong = (Long)jsonObject.get("deviation");
        Long nombreIterationLong = (Long)jsonObject.get("nombreIteration");
        this.numberOfPersons = numberOfPersonLong.intValue();
        this.mean = meanLong.intValue();
        this.deviation = deviationLong.intValue();
        this.numberOfIterations = nombreIterationLong.intValue();

        stringBuilder.append("Init param from JSON file : ");
        stringBuilder.append(jsonFile.toString());
        stringBuilder.append("\n");
        stringBuilder.append(PrintUtiliy.printParams(this.numberOfPersons, this.mean, this.deviation, this.numberOfIterations));
        LOGGER.info(stringBuilder.toString());
    }
}
