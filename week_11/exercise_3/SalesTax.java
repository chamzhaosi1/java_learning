package exercise_3;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

public class SalesTax extends JFrame {
    private final static int WIDTH = 500;
    private final static int HEIGHT = 300;
    private JPanel mainPanel;
    private JSlider taxRateSlider;
    private JTextField amounTextField;
    private int initalTaxRate = 2;
    private int taxRate = initalTaxRate;
    private GridBagConstraints gbc = new GridBagConstraints();

    SalesTax() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sales Tax Calculator");

        makeMainPanel();
        add(mainPanel);

        setVisible(true);
    }

    private void makeMainPanel() {
        JLabel taxRateLabel = new JLabel("Tax Rate Adjuster (percent)");
        JLabel amountLabel = new JLabel("Please enter your total purchase amount");
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        amounTextField = new JTextField(5);
        amounTextField.addActionListener(new TextFieldListener());
        taxRateSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, initalTaxRate);
        taxRateSlider.setMajorTickSpacing(2);
        taxRateSlider.setMinorTickSpacing(1);
        taxRateSlider.setPaintTicks(true);
        taxRateSlider.setPaintLabels(true);
        taxRateSlider.addChangeListener(new taxRateListener());

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(taxRateLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(taxRateSlider, gbc);
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(amountLabel, gbc);
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(amounTextField, gbc);
    }

    private class taxRateListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            taxRate = taxRateSlider.getValue();
        }
    }

    private class TextFieldListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int purchaseAmount = Integer.parseInt(amounTextField.getText());
                double tax = purchaseAmount * (taxRate / 100.0);

                JOptionPane
                        .showMessageDialog(mainPanel,
                                "Your total amount of purchase is RM " + purchaseAmount + ", so you need to pay RM "
                                        + String.format("%.02f", tax) + " tax.",
                                "Total Tax", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(mainPanel, "Please make sure you are entering number only",
                        "Wrong Data Type", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SalesTax salesTax = new SalesTax();
    }
}
