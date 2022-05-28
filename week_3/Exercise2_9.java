import java.util.Scanner;

public class Exercise2_9 {
    public static void main(String[] agrs) {
        String password;

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Password rule: ");
            System.out.println("1) A password must have at least eight characters. ");
            System.out.println("2) A password consists of only letters and digits. ");
            System.out.println("3) A password must contain at least two digits. ");

            System.out.println("\n Please enter a new password: ");

            password = input.nextLine();

        } while (isValidPassword(password));

        input.close();
    }

    public static boolean isValidPassword(String password) {
        if (passwordLenght(password)) {
            System.out.println("################### Invalid password ##############");
            System.out.println("A password must have at least eight characters");
            System.out.println("################### Invalid password ##############");
            return true;
        } else if (letter_digit(password)) {
            System.out.println("################### Invalid password ##############");
            System.out.println("A password consists of only letters and digits.");
            System.out.println("################### Invalid password ##############");
            return true;
        } else if (two_digits(password)) {
            System.out.println("################### Invalid password ##############");
            System.out.println("A password must contain at least two digits.");
            System.out.println("################### Invalid password ##############");
            return true;
        }

        System.out.println("You entered a valid password!!! Thanks you");
        return false;
    }

    public static boolean passwordLenght(String password) {
        if (password.length() < 8) {
            return true;
        }
        return false;
    }

    public static boolean letter_digit(String password) {
        int letter = 0, digits = 0;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isLetter(password.charAt(i))) {
                letter++;
            } else if (Character.isDigit(password.charAt(i))) {
                digits++;
            }

            if ((letter + digits) == password.length() && letter > 0 && digits > 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean two_digits(String password) {
        int digits = 0;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                digits++;
            }

            if (digits > 2) {
                return false;
            }
        }
        return true;
    }
}
