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
                Arrays.toString(biggerThan(new int[]{2, 4, 7, 2, 0, 0, 2, -3, -12, 3, 5, 9, 11}, input()))
        );

        msg("Exercise 4: ");
        donations(input());

        msg("Exercise 5: ");
        System.out.println(donationsMax(input(), input()));

        msg("Exercise 6: ");
        printSentence(inputString());
    }

    static void msg(String message) {
        System.out.println(message);
        System.out.println();
    }

    static int input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    static String inputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    static int[] makeWholeNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                numbers[i] = 0;
            }
        }
        return numbers;
    }

    static int numbersSum(int[] numbers) {
        int sum = 0;
        int[] wholeNumbers = makeWholeNumbers(numbers);

        for (int n : wholeNumbers) {
            sum += n;
        }
        return sum;
    }

    static int oddNumbers(int[] numbers) {
        int odds = 0;
        int[] wholeNumbers = makeWholeNumbers(numbers);

        for (int n : wholeNumbers) {
            if (n % 2 != 0) {
                odds++;
            }
        }
        return odds;
    }

    static int[] biggerThan(int[] numbers, int number) {
        int count = 0;
        int index = 0;
        int[] wholeNumbers = makeWholeNumbers(numbers);

        for (int n : wholeNumbers) {
            if (n > number) {
                count++;
            }
        }

        int[] biggerThanNumbers = new int[count];
        for (int n : wholeNumbers) {
            if (n > number) {
                biggerThanNumbers[index] = n;
                index++;
            }
        }
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
        String success;

        for (int i = 0; i < maxDonations; i++) {
            donations += random.nextInt(1, target);
            if (donations >= target) {
                return success = "Success, the donations amount is now: " + donations + " $";
            }
        }
        return success =
                "The Campaign has been closed as we reached " + maxDonations + " donations\n" +
                        "The donations amount is now: " + donations + " $";
    }

    static void printSentence(String phrase) {
        String[] sentences = phrase.split("[.]");
        System.out.println(Arrays.toString(sentences));

        for (String n : sentences) {
            System.out.println(n);
        }
    }
}
