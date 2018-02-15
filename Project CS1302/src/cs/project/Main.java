package cs.project;

import java.util.Scanner;

public class Main {
    private static boolean running = true;

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        while (running) {
            System.out.print("Enter the year: ");
            Year year = new Year(s.nextInt());

            System.out.print("Enter the gender: ");
            char gender = s.next().charAt(0);

            System.out.print("Enter the name: ");
            String name = s.next();

            int rank = year.getRank(gender, name);

            if (year.getYear() == 0) {
                System.out.println("There isn't any baby name data for the year " + year.getYear());
            } else if (rank == 0) {
                System.out.println("The name " + name + " is not ranked in the year " + year.getYear());
            } else {
                System.out.println(name + " is ranked #" + rank + " in year " + year.getYear());
            }

            System.out.print("\nWould you like to run again? (y/n): ");
            running = s.next().toLowerCase().charAt(0) == 'y';
            System.out.println("");
            s.nextLine();
        }
        s.close();
    }
}
