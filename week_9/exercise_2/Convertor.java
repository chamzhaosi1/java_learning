import javax.swing.*;
import java.awt.event.*;

public class Convertor extends JFrame{
    private int frameWidth = 265; 
    private int frameHeight = 110; 
    private JPanel panel;
    private JLabel lableTitle;
    private JLabel lableResult = new JLabel();
    private JTextField textField; 

    Convertor(){
        setTitle("Temperature Converter");
        setSize(frameWidth,frameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        createPanel();
        add(panel);

        setVisible(true);
    }

    private void createPanel(){
        lableTitle = new JLabel("Enter Fahrenheit Temperature: ");
        textField = new JTextField(15);
        textField.addActionListener(new CalculatorCelsius());

        panel = new JPanel() ;
        panel.add(lableTitle);
        panel.add(textField);
    }

    public static void main(String[] args) {
        Convertor converter =  new Convertor();
    }

    private class CalculatorCelsius implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                String tempStr = textField.getText();
                textField.setText("");

                Double temp = Double.parseDouble(tempStr);
                Double celsius = (5.0 / 9.0) * ( temp - 32);

                String resultMsg = "Temperature in Celsius is : " + String.format("%.02f", celsius);
                lableResult.setText(resultMsg);
                panel.add(lableResult);
                panel.revalidate();
                panel.repaint();

            }catch(Exception ex){
                lableResult.setText("Temperature in Celsius is : Invalid data type");
                panel.add(lableResult);
                panel.revalidate();
                panel.repaint();
            }
        }
    }
}

