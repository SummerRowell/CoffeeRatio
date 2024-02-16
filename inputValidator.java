import java.util.Scanner;

public class inputValidator {

    Scanner scnr = new Scanner(System.in);

    public void getInput() {

        System.out.println(
                "\nTo start, enter the number of cups of coffee you would like to brew. One cup is equal to 283 grams / approximately 10oz.");
        System.out.println("If you would prefer to input your water amount by grams, enter G");
        System.out.println("If you would prefer to input the coffee and be given the amount of water, enter C");
        System.out.println("To exit, enter Q.\n");

        String input = scnr.next();
        String choice = input.toUpperCase();
        int numCups;
        int waterGrams;
        int coffeeGrams;

        switch (choice) {
            case "G":
                System.out.println("Enter the amount of water you will be using in grams:");
                String waterInGrams = scnr.next();
                try {
                    waterGrams = Integer.parseInt(waterInGrams);
                    getRatio(waterGrams, 'W');
                } catch (NumberFormatException e) {
                    System.out.print("Invalid Input");
                }
                break;
            case "C":
                System.out.println("Enter the amount of coffee you will be using in grams:");
                String coffeeInGrams = scnr.next();
                try {
                    coffeeGrams = Integer.parseInt(coffeeInGrams);
                    getRatio(coffeeGrams, 'C');
                } catch (NumberFormatException e) {
                    System.out.println("\nInvalid Input. Please try again: ");
                }
                break;
            case "Q":
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
                try {
                    numCups = Integer.parseInt(choice);
                    getRatio((numCups * 283), 'W');
                } catch (NumberFormatException e) {
                    System.out.println("\nInvalid Input. Please try again: ");
                    getInput();
                }
                break;
        }

        System.out.println("Enter Y to calculate a new ratio. Enter any other key to quit.");
        String lastInput = scnr.next();
        System.out.println(lastInput);
        if (lastInput.equalsIgnoreCase("Y")) {
            getInput();
        } else {
            System.out.println("Goodbye!");
            System.exit(0);
        }
    }

    public void getRatio(int grams, char waterOrCoffee) {
        System.out.println(
                "Enter the brewing ratio you would like to use, in the format Grams-of-Coffee:Grams-of-Water. Enter H for info on brewing ratios.");
        String input = scnr.next();
        String[] ratio;
        ratioCalculator rc = new ratioCalculator();

        if (input.equalsIgnoreCase("H")) {
            System.out.println("For a stronger cup, we suggest brewing from 1:14 - 1:15. For a lighter cup, we recommend anywhere between 1:16 to 1:18. What ratio would you like to use?");
                    input = scnr.next();
        }

        if (waterOrCoffee == 'W') {
            if (input.matches("[0-9]:[0-9][0-9]?")) {
                ratio = input.split(":", 0);
                System.out.println("Ratio: ");
                for (String a : ratio) {
                    System.out.println(a);
                }
                System.out.println(rc.calcGivenWater(grams, ratio));
            } else {
                System.out.println("\nInvalid Input. Please try again: ");
                getRatio(grams, 'W');
            }
        }

        if (waterOrCoffee == 'C') {
            if (input.matches("[0-9]:[0-9][0-9]")) {
                ratio = input.split(":", 0);
                System.out.println("Ratio: ");
                for (String a : ratio) {
                    System.out.println(a);
                }
                System.out.println(rc.calcGivenCoffee(grams, ratio));
            } else {
                System.out.println("Invalid input. Try again.");
                getRatio(grams, 'C');
            }
        }
    }
}
