package fr.epsi.jconte.service.initparam.impl;

import fr.epsi.jconte.service.utility.PrintUtiliy;
import org.apache.log4j.Logger;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class InitParamFromYAML extends InitParam {

    public static final Logger LOGGER = Logger.getLogger(InitParamFromYAML.class);

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
}
