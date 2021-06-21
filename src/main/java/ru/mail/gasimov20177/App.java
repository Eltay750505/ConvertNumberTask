package ru.mail.gasimov20177;

import ru.mail.gasimov20177.exception.ConvertNumberException;
import ru.mail.gasimov20177.numberconverter.NumberConverter;

import java.util.Scanner;



public class App {
    public static void main(String[] args) throws ConvertNumberException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите число: ");
        long number = sc.nextLong();

        String wordsFromNum = NumberConverter.getWordsFromNum(number, 1);
        System.out.println(wordsFromNum);
    }
}
