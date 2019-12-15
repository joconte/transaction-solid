package fr.epsi.jconte.service.utility;

import fr.epsi.jconte.model.IPerson;

public class PrintUtiliy {

    private PrintUtiliy() {}

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
