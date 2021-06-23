package ru.mail.gasimov20177.numberconverter;

import ru.mail.gasimov20177.exception.ConvertNumberException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class NumberConverter {
    public static final String SEPARATOR = ",";
    public static final String ZERO = "ноль";
    public static final String PATH = "src\\main\\resources\\data\\guide.txt";
    public static final String SPACE = " ";
    public static final int STRING_CAPACITY;
    public static int level;

    private NumberConverter() {
    }

    static {
        level = 1;
        STRING_CAPACITY = 50;
    }

    public static String getWordsFromNum(long number) throws ConvertNumberException {
        long num = Math.abs(number);
        StringBuilder words = new StringBuilder(STRING_CAPACITY);
        String[][] guide = getGuide();
        if (num == 0) {
            return ZERO;
        }
        int currentSegment = (int) (num % 1000);
        int temp = currentSegment % 100;
        int currentDigit100 = currentSegment / 100;
        if (currentDigit100 > 0) {
            words.append(guide[3][currentDigit100 - 1]).append(SPACE);
        }
        int currentDigit10 = temp / 10;
        int currentUnit = temp % 10;

        printDigit10(words, guide, currentDigit10, currentUnit);

        if (currentDigit10 == 1)
            currentUnit = 0;

        printUnit(level, words, guide, currentUnit);

        printNumClassName(level, words, guide, currentUnit);

        long nextNum = num / 1000;
        if (nextNum > 0) {
            level++;
            return (getWordsFromNum(nextNum) + " " + words.toString()).trim();
        } else {
            level = 1;
            return words.toString().trim();
        }

    }

    private static void printNumClassName(int level, StringBuilder words, String[][] guide, int currentUnit) {
        if (level == 1) {
            return;
        }
        // if ((currentSegment != 0) || ((currentSegment == 0) && (level == 1)))
        //     words.append(guide[5][1]);

        switch (currentUnit) {
            case 1: {
                words.append(guide[level + 2][1]);
                break;
            }
            case 2:
            case 3:
            case 4: {
                words.append(guide[level + 2][2]);
                break;
            }
            default: {
                words.append(guide[level + 2][0]);
            }
        }
    }

    private static void printUnit(int level, StringBuilder words, String[][] guide, int currentUnit) {
        switch (currentUnit) {
            case 0:
                break;
            case 1: {
                if (level == 2) {
                    words.append(guide[0][0]).append(SPACE);
                } else {
                    words.append(guide[0][guide[0].length - 2]).append(SPACE);
                }
                break;
            }
            case 2: {
                if (level == 2) {
                    words.append(guide[0][1]).append(SPACE);
                } else {
                    words.append(guide[0][guide[0].length - 1]).append(SPACE);
                }
                break;
            }
            default: {
                words.append(guide[0][currentUnit - 1]).append(SPACE);
                break;
            }
        }
    }

    private static void printDigit10(StringBuilder words, String[][] guide, int currentDigit10, int currentUnit) {
        switch (currentDigit10) {
            case 0: {
                break;
            }
            case 1: {
                words.append(guide[1][currentUnit]).append(SPACE);
                break;
            }
            default: {
                words.append(guide[2][currentDigit10 - 2]).append(SPACE);
                break;
            }
        }
    }

    private static String[][] getGuide() throws ConvertNumberException {
        String path = PATH;
        String s = readFromFile(path);
        return getArrayOfGuides(s);
    }

    private static String readFromFile(String filePath) throws ConvertNumberException {
        try {
            Path path = Path.of(filePath);

            return Files.readString(path);
        } catch (InvalidPathException | IOException e) {
            throw new ConvertNumberException("Unable to open file: " + filePath, e);
        }
    }

    private static String[][] getArrayOfGuides(String text) {
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
