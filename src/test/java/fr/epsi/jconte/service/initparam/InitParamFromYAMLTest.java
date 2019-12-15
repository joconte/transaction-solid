package fr.epsi.jconte.service.initparam;

import fr.epsi.jconte.service.initparam.impl.InitParamFromYAML;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class InitParamFromYAMLTest {

    @Test
    public void initParamFromYAML() {

        // Arrange
        String yamlFileName = "init-test.yaml";

        // Act
        IInitParam initParam = new InitParamFromYAML(yamlFileName);
        int numberOfPersons = initParam.getNumberOfPersons();
        int mean = initParam.getMean();
        int deviation = initParam.getDeviation();
        int numberOfIterations = initParam.getNumberOfIterations();

        // Assert
        assertTrue(numberOfPersons == 1080);
        assertTrue(mean == 110);
        assertTrue(deviation == 15);
        assertTrue(numberOfIterations == 233);
    }

}