/* Programmed by Anthony Ellinos
   Assignment: Project 2
   MileageDemo Driver */

package Project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MileageDemo {
    public static void main(String args[]) throws FileNotFoundException {
        ArrayList<Mileage> ulist = getMileageAmounts(); // reads the file, builds 12 Mileage objects and stores the list
        // if the file has incorrect data stop the program
        if (ulist == null) {
            return;
        }

        System.out.println(); // added so its easier to read top line in terminal

        Mileage.displayLowestMonth(ulist);
        Mileage.displayHighestMonth(ulist);
        Mileage.displayTotalAndAverage(ulist);

        System.out.println("\nMileage by month (lowest to highest)");

        Mileage.sortAscending(ulist);
        // for each Mileage m in ulist print m
        for (Mileage m : ulist) {
            System.out.println(m);
        }
    }

    private static ArrayList<Mileage> getMileageAmounts() throws FileNotFoundException {
        ArrayList<Mileage> list = new ArrayList<>(); // starts with an empty list
        Scanner input = new Scanner(new File("monthly_mileage.txt")); // opens the file

        int month = 1;
        // loop reads until the file has no numbers left
        while (input.hasNextDouble()) {
            double miles = input.nextDouble();
            if (miles < 0) {
                System.out.println("Error: mileage can't be negative.");
                input.close(); // close input if negative
                return null;
            }

            list.add(new Mileage(month, miles)); // creates a new Mileage object for this month and adds it to the list
            month++; // move to the next month
        }
        input.close(); // closes when done

        if (list.size() != 12) {
            System.out.println("Error: file must have exactly 12 records.");
            return null;
        }
        return list;
    }
}