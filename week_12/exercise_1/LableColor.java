package exercise_1;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;


public class LableColor extends JLabel implements Serializable{}
class MyFrame extends JFrame{
    private final static int WIDTH = 350;
    private final static int HEIGHT = 150;
    private JPanel panel;
    private JTextField textField;
    private JComboBox<String> combo;
    private JButton button;

    MyFrame(){
        setTitle("Save Object");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        makePanel();
        add(panel);

        setVisible(true);
    }

    private void makePanel(){
        String color[] = {"RED","GREEN", "BLUE", "YELLOW", "MAGENTA", "CYAN", "WHITE", "BLACK", "GRAY", "LIGHT_GRAY", "DARK_GRAY", "PINK", "ORANGE"};
        JLabel lable_1 = new JLabel("Insert Text for Label");
        JLabel lable_2 = new JLabel("Choose color for label display text");
        textField = new JTextField(15);
        panel = new JPanel();
        combo = new JComboBox<>(color);
        button = new JButton("OK");
        button.addActionListener(new ButtonListener());

        panel.add(lable_1);
        panel.add(textField);
        panel.add(lable_2);
        panel.add(combo);
        panel.add(button);
    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            LableColor labelcolor = new LableColor();
            labelcolor.setText(textField.getText());

            switch (combo.getSelectedIndex()){
                case 0: labelcolor.setForeground(Color.RED); break;
                case 1: labelcolor.setForeground(Color.GREEN); break;
                case 2: labelcolor.setForeground(Color.BLUE); break;
                case 3: labelcolor.setForeground(Color.YELLOW); break;
                case 4: labelcolor.setForeground(Color.MAGENTA); break;
                case 5: labelcolor.setForeground(Color.CYAN); break;
                case 6: labelcolor.setForeground(Color.WHITE); break;
                case 7: labelcolor.setForeground(Color.BLACK); break;
                case 8: labelcolor.setForeground(Color.GRAY); break;
                case 9: labelcolor.setForeground(Color.LIGHT_GRAY); break;
                case 10: labelcolor.setForeground(Color.DARK_GRAY); break;
                case 11: labelcolor.setForeground(Color.PINK); break;
                case 12: labelcolor.setForeground(Color.ORANGE); break;
            }
        
        try {
            FileOutputStream outputStream = new FileOutputStream("exercise_1\\Objects.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(labelcolor);
            objectOutputStream.close();

            System.out.println("fsdfs");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erroc Occuranced", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        }   
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
