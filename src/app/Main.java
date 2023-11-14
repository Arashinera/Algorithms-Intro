package app;

import java.util.Scanner;
import java.util.Locale;

//Імпортуємо бібліотеку Random :
import java.util.Random;

//Протягом семи днів фіксувалась щоденна різна ціна товару.
//За допомогою алгоритму Bubble sort реалізуйте функціонал,
//який сортує значення цін в зростаючому порядку.
//Також реалізуйте функціонал, який розраховує середню ціну
//за весь період.

public class Main {

    //Створюємо змінні класу :
    static int days;
    static int[] daysValueArray;
    static int count;
    static int choice;
    static int totalSum;
    static int valueAverage;
    public static final String CURRENCY = "EUR";

    public static void main(String[] args) {

        //Налаштовуємо сканер, рандом та локейл :
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        input.useLocale(Locale.ENGLISH);

        //Вводимо значення довжини масиву:
        System.out.println("Please, input the number of days\n"
                + "when the price of the laptop had been changing : ");
        days = input.nextInt();

        //Задаємо довжину масиву :
        daysValueArray = new int[days];

        //Налаштовуємо лічильник :
        count = 0;
        totalSum = 0;

        //Заповнюємо автоматично наш масив значеннями від 500 до 570 завдяки рандому :
        for (int i = 0; i < days; i++) {
            daysValueArray[i] = random.nextInt(70) + 500;
            totalSum = totalSum + daysValueArray[i];
        }

        //Виводимо масив на екран :
        for (int j = 0; j < days; j++) {
            count++;
            System.out.printf("%d) = %s %s.%n", count, CURRENCY, daysValueArray[j]);
        }

        //Даємо користувачу вибір :
        do {
            System.out.println("\nWhat do you want to do? :\n1) - Sort price.\n2) - Check total sum and average.");
            choice = input.nextInt();
        } while (choice < 1 || choice > 2);

        //Налаштовуємо лічильник :
        count = 0;

        switch (choice) {
            case 1:

                //Сортуємо масив методом Bubble :
                for (int i = 0; i < days; i++) {
                    for (int j = 1; j < (days - i); j++) {
                        if (daysValueArray[j - 1] > daysValueArray[j]) {
                            int temp = daysValueArray[j - 1];
                            daysValueArray[j - 1] = daysValueArray[j];
                            daysValueArray[j] = temp;
                        }
                    }
                }

                //Виводимо відсортований масив :
                System.out.println("Sorted price : ");
                for (int i = 0; i < days; i++) {
                    count++;
                    System.out.printf("%d) = %s %s.%n", count, CURRENCY, daysValueArray[i]);
                }
                break;
            case 2:

                //Виводимо арифмемтичні дії :
                for (int i = 0; i < days; i++) {
                    if (i == days - 1) {
                        System.out.printf("%d.", daysValueArray[i]);
                        break;
                    }
                    System.out.printf("%d + ", daysValueArray[i]);
                }

                //Визначаємо середню ціну продажу за весь період :
                valueAverage = totalSum / days;

                //Виводимо загальну суму та середнє значення :
                System.out.printf("%nTotal sum is : %s %d", CURRENCY, totalSum);
                System.out.printf("%nValue average is : %s %d", CURRENCY, valueAverage);
                break;
        }
    }
}
