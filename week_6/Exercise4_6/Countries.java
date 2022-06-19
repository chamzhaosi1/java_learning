package Exercise4_6;

import java.util.Scanner;

public class Countries {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] countries = new String[12];
        int[] population = new int[12];

        System.out.println("Please enter the country name and its population: ");
        for (int i = 0; i < countries.length; i++) {
            System.out.println((i + 1) + " country: ");
            System.out.print("Country Name: ");
            countries[i] = input.nextLine();

            System.out.print("population: ");
            population[i] = input.nextInt();
            input.nextLine();
        }

        System.out.println("Each country detail: ");
        for (int i = 0; i < countries.length; i++) {
            System.out.println((i + 1) + " : " + countries[i] + " has " + population[i] + " population.");
        }
        input.close();
    }
}
