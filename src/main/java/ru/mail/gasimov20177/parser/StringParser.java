package ru.mail.gasimov20177.parser;

public class StringParser {
    public static final String SEPARATOR = ",";

    public String[][] getArrayOfGuides(String text) {
        String[] splitStrings = text.split("\n");

        String[] digit1 = splitStrings[0].split(SEPARATOR);
        String[] digit10 = splitStrings[1]
                .strip()
                .split(SEPARATOR);
        String[] digit20 = splitStrings[2].strip().split(SEPARATOR);
        String[] digit100 = splitStrings[3].strip().split(SEPARATOR);
        String[] class1 = splitStrings[4].strip().split(SEPARATOR);
        String[] class2 = splitStrings[5].strip().split(SEPARATOR);
        String[] class3 = splitStrings[6].strip().split(SEPARATOR);
        String[] class4 = splitStrings[7].strip().split(SEPARATOR);
        String[] class5 = splitStrings[8].strip().split(SEPARATOR);
        String[] class6 = splitStrings[9].strip().split(SEPARATOR);

        String[][] result = {
                digit1,
                digit10,
                digit20,
                digit100,
                class1,
                class2,
                class3,
                class4,
                class5,
                class6
        };
        return result;
    }
}
