import java.awt.Color;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.event.*;


public class GUI_practices {
    
    // public static void main(String[] args) {
    //     // JOptionPane.showMessageDialog(null, "Hello World");
    //     // JOptionPane.showMessageDialog(null, 8.9, "title message", JOptionPane.PLAIN_MESSAGE);


    //     /*ERROR_MESSAGE
    //      * INFORMATION_MESSAGE
    //      * WARNING_MESSAGE
    //      * QUESTION_MESSAGE
    //      * PLAIN_MEDDAGE
    //      */

    //     String age;

    //     age = JOptionPane.showInputDialog(null, "Enter your age");

    //     try{
    //         JOptionPane.showMessageDialog(null, "Next year you will be " + (Integer.parseInt(age)+1), "Next year age", JOptionPane.INFORMATION_MESSAGE);
    //     }catch(Exception e){
    //         System.out.println(e);
    //         JOptionPane.showMessageDialog(null, "Please enter number only withou letter", "WARNING", JOptionPane.WARNING_MESSAGE);
    //     }
        
    //     System.out.println(age);
    // }

    private JLabel label;
    private JTextField textField;
    private JButton button;

    public GUI_practices() {
        final int WINDONW_WIdTH = 300;
        final int WINDOWN_HEIGHT = 500;

        JFrame window =  new JFrame();
        JPanel panel = new JPanel();
        label = new JLabel("Enter a distance in kilometers");
        textField = new JTextField(10);
        button = new JButton("Calculator");

        button.addActionListener(new CalcButtonListener());
        
        window.setTitle("Test window frame");
        window.setSize(WINDONW_WIdTH, WINDOWN_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        Color color = Color.DARK_GRAY;
        label.setForeground(color);
        panel.add(label);
        panel.add(textField);
        panel.add(button);

        window.add(panel);
    }

    private class CalcButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String input;
            double miles;
            input =  textField.getText();
            miles = Double.parseDouble(input) * 0.6214;

            JOptionPane.showMessageDialog(null, miles+" miles", "converter", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e.getActionCommand());
        }
    }

    public static void main(String[] args) {
        GUI_practices test =  new GUI_practices();
    }
}
