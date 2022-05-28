import java.util.Scanner;

public class Exercise2_10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter three number: ");
        System.out.print("1: ");
        float num1 = input.nextFloat();
        System.out.print("2: ");
        float num2 = input.nextFloat();
        System.out.print("3: ");
        float num3 = input.nextFloat();

        input.close();

        minimum(num1, num2, num3);
    }

    public static void minimum(float num1, float num2, float num3) {
        float first_min = Math.min(num1, num2);

        System.out.println("The minimun number is " + Math.min(first_min, num3));
    }
}
