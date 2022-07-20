import javax.swing.*;
import javax.swing.JOptionPane;

public class Salary{
    public static void main(String[] args) {
        int again = 0;

        do{
            try{
                String name = JOptionPane.showInputDialog(null, "What is your name?");
                String hoursStr = JOptionPane.showInputDialog(null, "How many hours did your work this week?");
                double hour = Double.parseDouble(hoursStr);
    
                String rateStr = JOptionPane.showInputDialog(null, "What is your hourly pay rate?");
                double rate = Double.parseDouble(rateStr);
    
                String message = "Hello " + name + ", Your total salary is RM" + String.format("%.02f", hour*rate);
                JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);

                again = 0;
    
            } catch (Exception e){
                again = 1;
                JOptionPane.showMessageDialog(null, "Please enter a correct data type", "Wrong data type", JOptionPane.WARNING_MESSAGE);
            }
        }while(again > 0);
    }
}