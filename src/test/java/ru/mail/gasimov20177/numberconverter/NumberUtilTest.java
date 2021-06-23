package ru.mail.gasimov20177.numberconverter;

import org.junit.Test;
import ru.mail.gasimov20177.exception.ConvertNumberException;

import static org.junit.Assert.*;

public class NumberUtilTest {
    public static final String MESSAGE = "Something wrong, actual is not equal to expected";

    @Test
    public void testFindNumber() throws ConvertNumberException {
        int actualNum = 56631761;
        String expected = "пятьдесят шесть миллионов шестьсот тридцать одна тысяча семьсот шестьдесят один";

        String actual = NumberConverter.getWordsFromNum(actualNum);

        assertEquals(MESSAGE, expected, actual);
    }

    @Test
    public void testZero() throws ConvertNumberException {
        int zero = 0;
        String expected = "ноль";

        String actual = NumberConverter.getWordsFromNum(zero);

        assertEquals(MESSAGE, actual, expected);
    }

    @Test
    public void testUnit() throws ConvertNumberException {

        String[] expectedWords = new String[]{"один", "два", "три", "четыре",
                "пять", "шесть", "семь", "восемь", "девять", "десять", "одиннадцать", "двенадцать", "тринадцать",
                "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};

        for (int i = 1; i < 20; i++) {
            String actual = NumberConverter.getWordsFromNum(i);
            assertEquals(MESSAGE, actual, expectedWords[i - 1]);
        }
    }

    @Test
    public void testTens() throws ConvertNumberException {
        String[] expectedWords = new String[]{"двадцать шесть", "двадцать семь", "тридцать шесть", "пятьдесят девять",
                "семьдесят", "восемьдесят один", "восемьдесят семь", "девяносто", "девяносто два"};
        int actual[] = new int[]{26, 27, 36, 59, 70, 81, 87, 90, 92};

        for (int i = 1; i < 9; i++) {
            String actualWords = NumberConverter.getWordsFromNum(actual[i]);
            assertEquals(MESSAGE, expectedWords[i], actualWords);
        }
    }
}