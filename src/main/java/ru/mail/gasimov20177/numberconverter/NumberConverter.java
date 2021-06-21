package ru.mail.gasimov20177.numberconverter;

import ru.mail.gasimov20177.exception.ConvertNumberException;
import ru.mail.gasimov20177.parser.StringParser;
import ru.mail.gasimov20177.reader.CustomFileReader;

public class NumberConverter {
    public static String getWordsFromNum(long num, int level) throws ConvertNumberException {
        StringBuilder words = new StringBuilder(50);
        String[][] guide = getGuide();
        if (num == 0) {
            return "ноль";
        }
        int currentSegment = (int) (num % 1000);
        int temp = currentSegment % 100;
        int currentDigit100 = currentSegment / 100;
        if (currentDigit100 > 0) words.append(guide[3][currentDigit100 - 1]).append(" ");
        int currentDigit10 = temp / 10;
        int currentUnit = temp % 10;
        switch (currentDigit10) {
            case 0: {
                break;
            }
            case 1: {
                words.append(guide[1][currentUnit]).append(" ");
                break;
            }
            default: {
                words.append(guide[2][currentDigit10 - 2]).append(" ");
                break;
            }
        }
        if (currentDigit10 == 1)
            currentUnit = 0;
        switch (currentUnit) {
            case 0:
                break;
            case 1: {
                if (level != 2) {
                    words.append(guide[0][guide[0].length - 2]).append(" ");
                }
                break;
            }
            case 2: {
                words.append(guide[0][guide[0].length - 1]).append(" ");
                break;
            }
            default: {
                words.append(guide[0][currentUnit - 1]).append(" ");
                break;
            }
        }
        switch (level) {
            case 1:
                break;
            case 2: {
                switch (currentUnit) {
                    case 1: {
                        words.append(guide[4][1]);
                        break;
                    }
                    case 2:
                    case 3:
                    case 4: {
                        words.append(guide[4][2]);
                        break;
                    }
                    default: {
                        words.append(guide[4][0]);
                    }
                }
                break;
            }
            case 3: {
                switch (currentUnit) {
                    case 1: {
                        words.append(guide[5][1]);
                        break;
                    }
                    case 2:
                    case 3:
                    case 4: {
                        words.append(guide[5][2]);
                        break;
                    }
                    default: {
                        words.append(guide[5][0]);
                    }
                }
                break;
            }
            case 4: {
                switch (currentUnit) {
                    case 1: {
                        words.append(guide[6][1]);
                        break;
                    }
                    case 2:
                    case 3:
                    case 4: {
                        words.append(guide[6][2]);
                        break;
                    }
                    default: {
                        words.append(guide[6][0]);
                    }
                }
                break;
            }
            case 5: {
                switch (currentUnit) {
                    case 1: {
                        words.append(guide[7][1]);
                        break;
                    }
                    case 2:
                    case 3:
                    case 4: {
                        words.append(guide[7][2]);
                        break;
                    }
                    default: {
                        words.append(guide[7][0]);
                    }
                }
                break;
            }
            case 6: {
                switch (currentUnit) {
                    case 1: {
                        words.append(guide[8][1]);
                        break;
                    }
                    case 2:
                    case 3:
                    case 4: {
                        words.append(guide[8][2]);
                        break;
                    }
                    default: {
                        words.append(guide[8][0]);
                    }
                }
                break;
            }
            case 7: {
                switch (currentUnit) {
                    case 1: {
                        words.append(guide[9][1]);
                        break;
                    }
                    case 2:
                    case 3:
                    case 4: {
                        words.append(guide[9][2]);
                        break;
                    }
                    default: {
                        words.append(guide[9][0]);
                    }
                }
                break;
            }
            default: {
                if ((currentSegment != 0) || ((currentSegment == 0) && (level == 1)))
                    words.append(guide[5][1]);
                break;
            }
        }

        long nextNum = num / 1000;
        if (nextNum > 0) {
            return (getWordsFromNum(nextNum, level + 1) + " " + words.toString()).trim();
        } else {
            return words.toString().trim();
        }

    }

    private static String[][] getGuide() throws ConvertNumberException {
        String path = "src\\main\\resources\\data\\guide.txt";
        CustomFileReader reader = new CustomFileReader();
        String s = reader.readFromFile(path);
        StringParser parser = new StringParser();
        String[][] arrayOfGuides = parser.getArrayOfGuides(s);
        return arrayOfGuides;
    }

}
