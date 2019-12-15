package fr.epsi.jconte.service.initparam.impl;

import fr.epsi.jconte.service.utility.PrintUtiliy;
import fr.epsi.jconte.service.initparam.IInitParam;
import org.apache.log4j.Logger;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class InitParamFromYAML implements IInitParam {

    public static final Logger LOGGER = Logger.getLogger(InitParamFromYAML.class);

    private int numberOfPersons;
    private int mean;
    private int deviation;
    private int numberOfIterations;

    public InitParamFromYAML(String yamlFileName) {

        StringBuilder stringBuilder = new StringBuilder();
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(yamlFileName);
        Map<String, Object> obj = yaml.load(inputStream);
        numberOfPersons = (int) obj.get("numberOfPersons");
        mean = (int) obj.get("mean");
        deviation = (int) obj.get("deviation");
        numberOfIterations = (int) obj.get("numberOfIterations");

        stringBuilder.append("Init param from YAML file : ");
        stringBuilder.append(yamlFileName);
        stringBuilder.append("\n");
        stringBuilder.append(PrintUtiliy.printParams(this.numberOfPersons, this.mean, this.deviation, this.numberOfIterations));
        LOGGER.info(stringBuilder.toString());
    }

    @Override
    public int getNumberOfPersons() {
        return this.numberOfPersons;
    }

    @Override
    public int getMean() {
        return this.mean;
    }

    @Override
    public int getDeviation() {
        return this.deviation;
    }

    @Override
    public int getNumberOfIterations() {
        return this.numberOfIterations;
    }
}
