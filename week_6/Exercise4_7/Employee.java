package Exercise4_7;

import java.util.Scanner;
public class Employee {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        int [] employee_ic = new int[10];
        double [] gross_pay = new double[10];

        System.out.println("Please enter the employee identification number and each of then gross pay: ");
        for (int i=0; i<employee_ic.length; i++){
            System.out.println((i+1)+ " Employee: ");
            System.out.print("Identification Number: ");
            employee_ic[i] = input.nextInt();

            System.out.print("Gross Pay: ");
            gross_pay[i] = input.nextDouble();
            // input.nextLine();
        }

        System.out.println("Each employee detail: ");
        for (int i=0; i<employee_ic.length; i++){
            System.out.println((i+1) + " : " + employee_ic[i] + " has " + gross_pay[i] + " gross pay.");
        }
        input.close();
    }
}
