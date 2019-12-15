package fr.epsi.jconte.service.initparam;

import fr.epsi.jconte.service.initparam.impl.InitParamFromJSON;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class InitParamFromJSONTest {

    @Test
    public void initParamFromJSON() throws IOException, ParseException {
        // Arrange
        URL url = Thread.currentThread().getContextClassLoader().getResource("init-test.json");
        File jsonFile = new File(url.getPath());

        // Act
        IInitParam initParam = new InitParamFromJSON(jsonFile);
        int numberOfPersons = initParam.getNumberOfPersons();
        int mean = initParam.getMean();
        int deviation = initParam.getDeviation();
        int numberOfIterations = initParam.getNumberOfIterations();

        // Assert
        assertTrue(numberOfPersons == 10000);
        assertTrue(mean == 100);
        assertTrue(deviation == 20);
        assertTrue(numberOfIterations == 100000);
    }

}