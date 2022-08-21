import java.sql.*; 
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.awt.*;
import java.awt.event.*;

public class Staffgui extends JFrame{
    private static final int WIDTH = 650;
    private static final int HEIGHT = 255;
    private JPanel mainPanel = new JPanel();
    private JTextField idTextField;
    private JTextField lsnTextField;
    private JTextField fsnTextField;
    private JTextField miTextField;
    private JTextField addressTextField;
    private JTextField cityTextField;
    private JTextField stateTextField;
    private JTextField telTextField;
    private JButton viewButton;
    private JButton insertButton;
    private JButton updateButton;
    private JButton clearButton; 
    private JLabel noticeLabel;

    public Staffgui(){
        setTitle("Staff Table");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);

        makePanel();
        add(mainPanel);

        setVisible(true);
    }

    private void makePanel(){
        JLabel staffInformation = new JLabel("Staff Information");

        JLabel idLabel = new JLabel("ID");
        idTextField = new JTextField(15);

        JLabel lsnLabel = new JLabel("Last Name");
        lsnTextField = new JTextField(15);

        JLabel fsnLabel = new JLabel("First Name");
        fsnTextField = new JTextField(15);

        JLabel miLabel = new JLabel("mi");
        miTextField = new JTextField(2);

        JLabel addressLabel = new JLabel("Address");
        addressTextField = new JTextField(20);

        JLabel cityLabel = new JLabel("City");
        cityTextField = new JTextField(15);

        JLabel stateLabel = new JLabel("State");
        stateTextField = new JTextField(2);

        JLabel telLabel = new JLabel("Telephone");
        telTextField = new JTextField(15);
        JPanel abovePanel = new JPanel();
        JPanel belowPanel = new JPanel();
        JPanel belowUpPanel = new JPanel();
        JPanel belowDownPanel = new JPanel();

        GridBagConstraints gbc = new GridBagConstraints();  
        GridBagLayout gbl = new GridBagLayout();  

        abovePanel.setLayout(gbl);
        gbc.fill = GridBagConstraints.HORIZONTAL;  
        gbc.insets = new Insets(0,0,20,0);  //top padding  
        gbc.gridx = 0;
        gbc.gridy = 0;
        abovePanel.add(staffInformation, gbc);
        gbc.insets = new Insets(0,0,0,0);  //top padding  
        gbc.gridx = 0;
        gbc.gridy = 1;
        abovePanel.add(idLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        abovePanel.add(idTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        abovePanel.add(lsnLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        abovePanel.add(lsnTextField, gbc);
        gbc.insets = new Insets(0,5,0,0);  //top padding 
        gbc.gridx = 2;
        gbc.gridy = 2;
        abovePanel.add(fsnLabel, gbc);
        gbc.insets = new Insets(0,0,0,0);  //
        gbc.gridx = 3;
        gbc.gridy = 2;
        abovePanel.add(fsnTextField, gbc);
        gbc.insets = new Insets(0,5,0,0);  //
        gbc.gridx = 5;
        gbc.gridy = 2;
        abovePanel.add(miLabel, gbc);
        gbc.insets = new Insets(0,0,0,0);  //
        gbc.gridx = 6;
        gbc.gridy = 2;
        abovePanel.add(miTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        abovePanel.add(addressLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        abovePanel.add(addressTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        abovePanel.add(cityLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        abovePanel.add(cityTextField, gbc);
        gbc.insets = new Insets(0,5,0,0);
        gbc.gridx = 2;
        gbc.gridy = 4;
        abovePanel.add(stateLabel, gbc);
        gbc.insets = new Insets(0,0,0,0);
        gbc.gridx = 3;
        gbc.gridy = 4;
        abovePanel.add(stateTextField, gbc);
        gbc.insets = new Insets(0,0,5,0);
        gbc.gridx = 0;
        gbc.gridy = 5;
        abovePanel.add(telLabel, gbc);
        gbc.insets = new Insets(0,0,5,0);
        gbc.gridx = 1;
        gbc.gridy = 5;
        abovePanel.add(telTextField, gbc);
        abovePanel.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));

        mainPanel.add(abovePanel, BorderLayout.NORTH);

        viewButton = new JButton("View");
        viewButton.addActionListener(new viewButtonListener());

        insertButton = new JButton("Insert");
        insertButton.addActionListener(new insertButtonListener());

        updateButton = new JButton("Update");
        updateButton.addActionListener(new updateButtonListener());

        clearButton = new JButton("Clear");
        clearButton.addActionListener(new clearButtonListener());

        belowUpPanel.setLayout(new GridLayout(1, 4, 5, 5));
        belowUpPanel.setBorder(new EmptyBorder(5, 100, 5, 100));

        belowUpPanel.add(viewButton);
        belowUpPanel.add(insertButton);
        belowUpPanel.add(updateButton);
        belowUpPanel.add(clearButton);

        belowPanel.setPreferredSize(new Dimension (650, 65));
        belowPanel.setLayout(new BorderLayout());
        
        belowPanel.add(belowUpPanel, BorderLayout.NORTH);

        // Box box = Box.createVerticalBox();

        noticeLabel = new JLabel();
        noticeLabel.setBorder(new EmptyBorder(0, 20, 5, 100));
        noticeLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        belowDownPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        belowDownPanel.add(noticeLabel);

        belowPanel.add(belowDownPanel);

        mainPanel.add(belowPanel,  BorderLayout.SOUTH);

    }

    public class viewButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
        }
    }

    public class insertButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (checkAllTextFiledEmpty()){
                noticeLabel.setText("Some of text field haven't fill in, empty data is not accepted");
                // mainPanel.revalidate();
                // mainPanel.repaint();
            }else{
                Staff staff = new Staff();
                staff.setId(idTextField.getText());
                staff.setLastName(lsnTextField.getText());
                staff.setFirstName(fsnTextField.getText());
                staff.setMi(miTextField.getText());
                staff.setAddress(addressTextField.getText());
                staff.setCity(cityTextField.getText());
                staff.setState(stateTextField.getText());
                staff.setTelephone(telTextField.getText());

                new Staffdb().insertData(staff);
            }


        }
    }

    public class updateButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
        }
    }

    public class clearButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
        }
    }

    private boolean checkAllTextFiledEmpty(){
        if (idTextField.getText().equals("")){
            return true;
        }

        if (lsnTextField.getText().equals("")){
            return true;
        }

        if (fsnTextField.getText().equals("")){
            return true;
        }

        if (miTextField.getText().equals("")){
            return true;
        }

        if (addressTextField.getText().equals("")){
            return true;
        }

        if (cityTextField.getText().equals("")){
            return true;
        }

        if (stateTextField.getText().equals("")){
            return true;
        }

        if (telTextField.getText().equals("")){
            return true;
        }

        return false;
    }
}
