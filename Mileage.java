/* Programmed by Anthony Ellinos
   Assignment: Project 2
   Mileage Class */

package Project2;

import java.util.ArrayList;

public class Mileage {
    // ensures that all Mileage objects share one list of month names
    private static String[] monthNames = { "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December" };
    private int month;
    private double miles;

    public Mileage(int month, double miles) {
        this.month = month;
        this.miles = miles;
    }

    // copy constructor
    public Mileage(Mileage obj) {
        this.month = obj.getMonth();
        this.miles = obj.getMiles();
    }

    public int getMonth() {
        return month;
    }

    public String getMonthName() {
        return getMonthName(month);
    }

    // converts month number to name, -1 since array starts at 0
    public static String getMonthName(int month) {
        return monthNames[month - 1];
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getMiles() {
        return miles;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }

    // toString override
    @Override
    public String toString() {
        return String.format("%s : %.2f mi", getMonthName(), miles);
    }

    public static void displayLowestMonth(ArrayList<Mileage> list) {
        Mileage lowest = list.get(0);

        // for each m in list, update lowest object if less than the current month
        for (Mileage m : list) {
            // compares the miles of each object
            if (m.getMiles() < lowest.getMiles()) {
                lowest = m;
            }
        }
        // Displays the lowest month
        System.out.printf("Lowest mileage: %s with %.2f mi%n", lowest.getMonthName(), lowest.getMiles());
    }

    public static void displayHighestMonth(ArrayList<Mileage> list) {
        Mileage highest = list.get(0);

        // for each m in list, update highest object if higher than the current month
        for (Mileage m : list) {
            // compares the miles of each object
            if (m.getMiles() > highest.getMiles()) {
                highest = m;
            }
        }
        // Displays the highest month
        System.out.printf("Highest mileage: %s with %.2f mi%n", highest.getMonthName(), highest.getMiles());
    }

    public static double getTotalMiles(ArrayList<Mileage> list) {
        double totalMiles = 0;

        // for each m in list add to total miles
        for (Mileage m : list) {
            totalMiles += m.getMiles();
        }

        return totalMiles;
    }

    public static void displayTotalAndAverage(ArrayList<Mileage> list) {
        double total = getTotalMiles(list);
        // takes the total and divides it by the number of months: 12
        double average = total / list.size();
        System.out.printf("Total miles driven for the year: %.2f mi%n", total);
        System.out.printf("Average miles driven per month: %.2f mi%n", average);
    }

    public static void sortAscending(ArrayList<Mileage> list) {
        // each pass of the outer loop moves the next biggest month to the end
        for (int i = 0; i < list.size() - 1; i++) {
            // compare each pair of neighbors
            for (int j = 0; j < list.size() - 1 - i; j++) {
                // if the left one has more miles, swap them
                if (list.get(j).getMiles() > list.get(j + 1).getMiles()) {
                    // hold the left month in a temp variable so it doesn't get lost
                    Mileage temp = list.get(j);
                    list.set(j, list.get(j + 1)); // right one moves left
                    list.set(j + 1, temp); // temp variable moves right
                }
            }
        }
    }

}
