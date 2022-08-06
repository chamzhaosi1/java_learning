package exercise_1;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import java.awt.*;
import java.awt.event.*;

public class ReadLableColor extends JFrame {
    private JButton button;
    private JLabel lable;
    private JPanel panel;
    private final static int WIDTH = 350;
    private final static int HEIGHT = 150;

    ReadLableColor(){
        setTitle("Load Object");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);

        makePanel();
        add(panel);

        setVisible(true);
    }

    private void makePanel(){
        button = new JButton("OK");
        button.addActionListener(new ButtonListener());
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.add(button, BorderLayout.SOUTH);
    }

    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                FileInputStream inStream = new FileInputStream("Objects.dat");
                ObjectInputStream objectInputStream = new ObjectInputStream(inStream);
                LableColor readlable = (LableColor) objectInputStream.readObject();
                objectInputStream.close();

                panel.add(readlable, BorderLayout.EAST);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erroc Occuranced", "Warning", JOptionPane.WARNING_MESSAGE);
            }

            
        }

    }

    public static void main(String[] args) {
        new ReadLableColor();
    }
}
