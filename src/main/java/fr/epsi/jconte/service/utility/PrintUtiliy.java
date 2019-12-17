package fr.epsi.jconte.service.utility;

import fr.epsi.jconte.model.IPerson;

/**
 * Provides methods to build String related to the economical simulation.
 */
public class PrintUtiliy {

    private PrintUtiliy() {}

    /**
     * Return the details of two IPerson as a beautiful String.
     * @param person1
     * @param person2
     * @return
     */
    public static String printPersonsDetails(IPerson person1, IPerson person2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\t - Person1 : \n");
        stringBuilder.append("\t\t - id : ");
        stringBuilder.append(person1.getId());
        stringBuilder.append("\n");
        stringBuilder.append("\t\t wealth : ");
        stringBuilder.append(person1.getWealth());
        stringBuilder.append("\n");
        stringBuilder.append("\t - Person2 : \n");
        stringBuilder.append("\t\t - id : ");
        stringBuilder.append(person2.getId());
        stringBuilder.append("\n");
        stringBuilder.append("\t\t - wealth : ");
        stringBuilder.append(person2.getWealth());
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    /**
     * Return the parameters as a beautiful String.
     * @param numberOfPersons
     * @param mean
     * @param deviation
     * @param numberOfIterations
     * @return
     */
    public static String printParams(int numberOfPersons, int mean, int deviation, int numberOfIterations) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("- number of persons : ");
        stringBuilder.append(numberOfPersons);
        stringBuilder.append("\n");
        stringBuilder.append("- mean : ");
        stringBuilder.append(mean);
        stringBuilder.append("\n");
        stringBuilder.append("- deviation : ");
        stringBuilder.append(deviation);
        stringBuilder.append("\n");
        stringBuilder.append("- number of iterations : ");
        stringBuilder.append(numberOfIterations);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
