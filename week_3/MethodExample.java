public class MethodExample {
    public static void main(String[] args) {
        displayMessage();
        displayMessage("Cham");
        displayMessage(Integer.toString(sum(1, 5)));
        displayMessage(Double.toString(sumDbl(60, 312)));
        displayResult();
        displayResult(1);
        displayResult(3, 5.0);
        displayResult(6.9, 3);
        MyMethod.sum(4,5);
        MyMethod.multiply(5, 5);
        MyMethod.divison(10, 5);
        new MyMethod().divison2(8, 2);
        MyMethod my = new MyMethod();
        my.divison2(254, 12);
    }

    public static void displayMessage() {
        System.out.println("Hello World");
    }

    public static void displayMessage(String data) {
        System.out.println("Hello World, " + data);
    }

    public static int sum(int num1, int num2) {
        return num1 + num2;
    } 

    public static double sumDbl(int num1, int num2) {
        return num1 + num2;
    }

    public static void displayResult(){
        System.out.println("Emtpy arguments");
    }

    public static void displayResult(int num1){
        System.out.println("Single int number: " + num1);
    }

    public static void displayResult(int num1, double num2){
        System.out.println("One integer number: "+ num1 + " and one double number " + num2);
    }
    
    public static void displayResult(double num1, int num2){
        System.out.println("One doubler number: "+ num1 + " and one integer number " + num2);
    }
}

class MyMethod{
    public static void sum(int num1, int num2){
        System.out.println("Sum is "+ (num1 + num2));
    }

    public static void multiply(int num1, int num2){
        System.out.println("Multiply is " + (num1 * num2));
    }

    public static void divison(int num1, int num2){
        System.out.println("Division is " +(num1/num2));
    }

    public void divison2(int num1, int num2){
        System.out.println("Division2 is " +(num1/num2));
    }
}