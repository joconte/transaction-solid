package fr.epsi.jconte.service.initparam.impl;

import fr.epsi.jconte.App;
import fr.epsi.jconte.service.utility.PrintUtiliy;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Provide methods to initialize parameters from properties files.
 */
public class InitParamFromProperties extends InitParam {

    public static final Logger LOGGER = Logger.getLogger(InitParamFromProperties.class);

    /**
     * Initialize parameters from a property file.
     * @param propertyFileName
     * @throws IOException
     */
    public InitParamFromProperties(String propertyFileName) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();

        InputStream input = App.class.getClassLoader().getResourceAsStream(propertyFileName);

        Properties prop = new Properties();

        if (input == null) {
            LOGGER.info("Failed to load properties from " + propertyFileName);
            return;
        }

        //load a properties file from class path, inside static method
        prop.load(input);
        this.numberOfPersons = Integer.parseInt(prop.getProperty("app.numberOfPersons"));
        this.mean = Integer.parseInt(prop.getProperty("app.mean"));
        this.deviation = Integer.parseInt(prop.getProperty("app.deviation"));
        this.numberOfIterations = Integer.parseInt(prop.getProperty("app.numberOfIterations"));

        stringBuilder.append("Init param from property file : ");
        stringBuilder.append(propertyFileName);
        stringBuilder.append("\n");
        stringBuilder.append(PrintUtiliy.printParams(this.numberOfPersons, this.mean, this.deviation, this.numberOfIterations));
        LOGGER.info(stringBuilder.toString());
    }
}
