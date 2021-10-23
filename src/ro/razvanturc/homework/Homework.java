package ro.razvanturc.homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        msg("Exercise 1:");
        System.out.println(numbersSum(new int[]{2, 2, 0, 0, 2, -3, -12}));

        msg("Exercise 2:");
        System.out.println(oddNumbers(new int[]{2, 2, 0, 0, 2, -3, -12, 3, 5, 9, 11}));

        msg("Exercise 3:");
        System.out.println(
                Arrays.toString(biggerThan(new int[]{2, 4, 7, 2, 0, 0, 2, -3, -12, 3, 5, 9, 11},
                        input("Introduceti numarul dorit: ")))
        );

        msg("Exercise 4: ");
        donations(input("Introduceti va rog suma target: "));

        msg("Exercise 5: ");
        System.out.println(donationsMax(
                input("Introduceti va rog suma target: "),
                input("Introduceti va rog numarul maxim de donatii: "))
        );

        msg("Exercise 6: ");
        printSentence(inputString("Scrieti o fraza:"));
    }

    static void msg(String message) {
        System.out.print(message);
        System.out.println();
    }

    static int input(String message) {
        Scanner scanner = new Scanner(System.in);
        msg(message);
        return scanner.nextInt();
    }

    static String inputString(String message) {
        Scanner scanner = new Scanner(System.in);
        msg(message);

        return scanner.nextLine();
    }

    static int numbersSum(int[] numbers) {
        int sum = 0;

        for (int n : numbers) {
            sum += n;
        }
        return sum;
    }

    static int oddNumbers(int[] numbers) {
        int odds = 0;

        for (int n : numbers) {
            if (n % 2 != 0) {
                odds++;
            }
        }
        return odds;
    }

    static int[] biggerThan(int[] numbers, int number) {
        int index = 0;
        int[] biggerArray = new int[numbers.length];

        for (int n : numbers) {
            if (n > number) {
                biggerArray[index] = n;
                index++;
            }
        }

        int[] biggerThanNumbers = new int[index];
        System.arraycopy(biggerArray, 0, biggerThanNumbers, 0, index);

        return biggerThanNumbers;
    }

    static void donations(int target) {
        int donations = 0;
        Random random = new Random();

        while (donations < target) {
            donations += random.nextInt(1, target);
            System.out.println(donations + " $");
        }

        System.out.println("Success, the donations amount is now: " + donations + " $");
    }


    static String donationsMax(int target, int maxDonations) {
        int donations = 0;
        Random random = new Random();

        for (int i = 0; i < maxDonations; i++) {
            donations += random.nextInt(1, target);
            if (donations >= target) {
                return "Success, the donations amount is now: " + donations + " $";
            }
        }
        return "The Campaign has been closed as we reached " + maxDonations + " donations\n" +
                        "The donations amount is now: " + donations + " $";
    }

    static void printSentence(String phrase) {
        String[] sentences = phrase.split("[.]");
        System.out.println(Arrays.toString(sentences));

        for (String s : sentences) {
            System.out.println(s.trim());
        }
    }
}
