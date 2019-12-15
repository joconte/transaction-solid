package fr.epsi.jconte.service.initparam;

import fr.epsi.jconte.service.initparam.impl.InitParamFromProperties;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class InitParamFromPropertiesTest {

    @Test
    public void initParamFromProperties() throws IOException {

        // Arrange
        String propertyFileName = "init-test.properties";

        // Act
        IInitParam initParam = new InitParamFromProperties(propertyFileName);
        int numberOfPersons = initParam.getNumberOfPersons();
        int mean = initParam.getMean();
        int deviation = initParam.getDeviation();
        int numberOfIterations = initParam.getNumberOfIterations();

        // Assert
        assertTrue(numberOfPersons == 150);
        assertTrue(mean == 200);
        assertTrue(deviation == 20);
        assertTrue(numberOfIterations == 100);
    }

}