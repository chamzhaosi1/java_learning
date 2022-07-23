import javax.swing.*;

public class Salary{
    public static void main(String[] args) {
        int again = 0;

        do{
            try{
                String name = JOptionPane.showInputDialog(null, "What is your name?");
                exit_trigger(name);
                String hoursStr = JOptionPane.showInputDialog(null, "How many hours did your work this week?");
                double hour = Double.parseDouble(hoursStr);
    
                String rateStr = JOptionPane.showInputDialog(null, "What is your hourly pay rate?");
                double rate = Double.parseDouble(rateStr);
    
                String message = "Hello " + name + ", Your total salary is RM" + String.format("%.02f", hour*rate);
                JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);

                again = 0;

            } catch (Exception e){
                exit_trigger(e.getMessage());
                again = 1;
                JOptionPane.showMessageDialog(null, "Please enter a correct data type", "Wrong data type", JOptionPane.WARNING_MESSAGE);
            }
        }while(again > 0);
    }

    private static void exit_trigger(String name){
        if (name==null){
            System.exit(0);
        }
    }
}