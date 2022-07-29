import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LongDistance extends JFrame {
    private final static int WIDTH = 550;
    private final static int HEIGHT = 250;
    private JRadioButton dayTimeBtn;
    private JRadioButton eveningBtn;
    private JRadioButton offPeakBtn;
    private ButtonGroup btnGroup;
    private JTextField inputMinsField;
    private JPanel tabelPanel;
    private JPanel calculatorPanel;
    private double rate = 0;

    LongDistance() {
        setTitle("Long Distance Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);

        makeTablePanel();
        makeCalculatePanel();
        add(tabelPanel, BorderLayout.NORTH);
        add(calculatorPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void makeCalculatePanel() {
        btnGroup = new ButtonGroup();
        dayTimeBtn = new JRadioButton("Day Time");
        eveningBtn = new JRadioButton("Evening");
        offPeakBtn = new JRadioButton("Off-Peak");

        dayTimeBtn.addActionListener(new RadioButtonListener());
        eveningBtn.addActionListener(new RadioButtonListener());
        offPeakBtn.addActionListener(new RadioButtonListener());

        JPanel insidePanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        btnGroup.add(dayTimeBtn);
        btnGroup.add(eveningBtn);
        btnGroup.add(offPeakBtn);

        buttonPanel.add(dayTimeBtn);
        buttonPanel.add(eveningBtn);
        buttonPanel.add(offPeakBtn);

        JPanel inputJPanel = new JPanel();
        JLabel minLabel = new JLabel("Enter the number of minutes of the call");
        inputMinsField = new JTextField(5);
        inputMinsField.addActionListener(new TextFieldListener());

        inputJPanel.add(minLabel);
        inputJPanel.add(inputMinsField);

        insidePanel.setLayout(new GridLayout(2, 1));
        insidePanel.add(buttonPanel);
        insidePanel.add(inputJPanel);

        calculatorPanel = new JPanel();
        calculatorPanel.add(insidePanel);
    }

    private void makeTablePanel() {
        String data[][] = { { "Daytime", "6:00 A.M through 5:59 P.M.", "RM0.07" },
                { "Evening", "6:00 P.M through  11:59 P.M.", "RM0.12" },
                { "Off-Peak", "12:00 A.M through  5:59 A.M.", "RM0.05" } };
        String column[] = { "Rate Category", "Period", "Rate per Minute" };
        JTable priceTable = new JTable(data, column);

        tabelPanel = new JPanel();
        JScrollPane sp = new JScrollPane(priceTable);
        sp.setPreferredSize(new Dimension(500, 100));

        tabelPanel.add(sp);
    }

    private class RadioButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == dayTimeBtn) {
                rate = 0.07;
            } else if (e.getSource() == eveningBtn) {
                rate = 0.12;
            } else {
                rate = 0.05;
            }
        }
    }

    private class TextFieldListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (rate == 0) {
                JOptionPane.showMessageDialog(calculatorPanel, "Please select one of the service plan", "Rate Missing",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    double min = Double.parseDouble(inputMinsField.getText());
                    double totalFees = min * rate;

                    JOptionPane.showMessageDialog(calculatorPanel,
                            "The total fee of the call is RM" + String.format("%.02f", totalFees), "Total Call Fees",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(calculatorPanel, "Please make sure you are entering number only",
                            "Wrong Data Type", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    public static void main(String[] args) {
        LongDistance longDistance = new LongDistance();
    }
}