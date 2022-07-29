package exercise_2;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class HotelTravel extends JFrame{
    private final static int WIDTH = 700;
    private final static int HEIGHT = 500;
    private JPanel mainPanel;
    private JPanel tablePanel;
    private JPanel roomTyPanel;
    private JPanel tripPanel;
    private JPanel operationPanel;
    private JPanel roomTypeComboPanel;
    private JPanel tripComboPanle;
    private JScrollPane roomTyScrollPane;
    private JScrollPane tripScrollPane;
    private JComboBox<String> tripComboBox;
    private JComboBox<String> roomTypeComboBox;
    private JTextField numCustTextField;
    private GridBagConstraints gbc = new GridBagConstraints();  
    
    HotelTravel(){
        setTitle("Hotel Fees Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);

        makeMainPanel();
        add(mainPanel);

        setVisible(true);
    }

    private void makeMainPanel(){
        tablePanel = new JPanel();
        mainPanel = new JPanel();

        buildHotelPanel();
        tablePanel.add(roomTyPanel);
        buildTripPanel();
        tablePanel.add(tripPanel);

        mainPanel.add(tablePanel, BorderLayout.NORTH);

        buildOperationPanel();
        mainPanel.add(operationPanel, BorderLayout.CENTER);

    }

    private void buildHotelPanel(){
        String data[][] = {{"Standard Room","RM 150.00"}, {"Deluxe Room", "RM 250.00"}, {"Superior Room", "RM 350.00"}};
        String header[] = {"Room Type", "Price per day"};

        roomTyPanel = new JPanel();
        JLabel roomTyLabel = new JLabel("Hotel rooms type table");
        JTable roomTypTable = new JTable(data, header);
        roomTyScrollPane = new JScrollPane(roomTypTable);
        roomTyScrollPane.setPreferredSize(new Dimension(250, 100));

        roomTyPanel.setLayout(new GridBagLayout());

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        roomTyPanel.add(roomTyLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        roomTyPanel.add(roomTyScrollPane,gbc);
    }

    private void buildTripPanel(){
        String data[][] = {{"Kajang","RM 100.00"}, {"Klang", "RM 200.00"}, {"Kuala Lumpur", "RM 250.00"}};
        String header[] = {"Area", "Price per person"};

        tripPanel = new JPanel();
        JLabel TripLabel = new JLabel("1 day trip");
        JTable tripTable = new JTable(data, header);
        tripScrollPane = new JScrollPane(tripTable);
        tripScrollPane.setPreferredSize(new Dimension(250, 100));

        tripPanel.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        tripPanel.add(TripLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        tripPanel.add(tripScrollPane, gbc);
    }

    public void buildOperationPanel(){
        operationPanel = new JPanel();

        buildRoomComboPanel();
        operationPanel.add(roomTypeComboPanel);
        buildTripComboPanel();
        operationPanel.add(tripComboPanle);
    }

    public void buildRoomComboPanel(){
        String roomType[] = {"Standard Room", "Deluxe Room", "Superior Room"};
        
        JLabel roomTypeComboLabel =  new JLabel("Please select room type");
        roomTypeComboBox = new JComboBox<>(roomType);
        roomTypeComboPanel = new JPanel();

        roomTypeComboPanel.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.VERTICAL;  
        gbc.insets = new Insets(0,0,0,50);
        gbc.ipadx = 10;  
        gbc.gridx = 0;
        gbc.gridy = 0;
        roomTypeComboPanel.add(roomTypeComboLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        roomTypeComboPanel.add(roomTypeComboBox, gbc);
    }

    public void buildTripComboPanel(){
        String tripArea[] = {"Kajang", "Klang", "Kuala Lumpur"};
        
        JLabel tripComboLabel =  new JLabel("Please select area for trip");
        tripComboBox = new JComboBox<>(tripArea);
        JLabel numCustomerLabel =  new JLabel("Please enter number of customer ");
        numCustTextField = new JTextField(5);
        numCustTextField.addActionListener(new TextFieldActionListener());

        tripComboPanle = new JPanel();

        tripComboPanle.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.VERTICAL; 
        gbc.insets = new Insets(0,0,0,0); 
        gbc.ipadx = 0;  
        gbc.gridx = 0;
        gbc.gridy = 0;
        tripComboPanle.add(tripComboLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        tripComboPanle.add(tripComboBox, gbc);
        gbc.insets = new Insets(10,0,0,0); 
        gbc.gridx = 0;
        gbc.gridy = 2;
        tripComboPanle.add(numCustomerLabel, gbc);
        gbc.insets = new Insets(0,0,0,0); 
        gbc.ipady = 5;
        gbc.gridx = 0;
        gbc.gridy = 3;
        tripComboPanle.add(numCustTextField ,gbc);
    }

    private class TextFieldActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int roomTypeIndex, tripAreaIndex, numCuts = 0, roomPrice = 0, tripPrice = 0, totalFees;
            String roomTypeName = null, tripAreaName= null;  
            if (roomTypeComboBox.getSelectedIndex() <= 2){
                roomTypeIndex = roomTypeComboBox.getSelectedIndex();
                switch(roomTypeIndex){
                    case 0: roomPrice = 150; roomTypeName="Standard"; break;
                    case 1: roomPrice = 250; roomTypeName="Deluxe"; break;
                    case 2: roomPrice = 350; roomTypeName="Superior"; break;
                }
            }

            if (tripComboBox.getSelectedIndex() <= 2){
                tripAreaIndex = tripComboBox.getSelectedIndex();
                switch(tripAreaIndex){
                    case 0: tripPrice = 100; tripAreaName="Kajang"; break;
                    case 1: tripPrice = 200; tripAreaName="Klang"; break;
                    case 2: tripPrice = 250; tripAreaName="Kuala Lumpur"; break;
                }
            }

            try{
                if (numCustTextField.getText() != null){
                    numCuts = Integer.parseInt(numCustTextField.getText());
                }
                // System.out.print(tripPrice);
                totalFees = roomPrice + (tripPrice * numCuts);
                JOptionPane.showMessageDialog(operationPanel, "You have been select the " + roomTypeName + " room and " + numCuts + " person for 1 day trip around " + tripAreaName + ". Total fees is RM " + totalFees, "Total Fees", JOptionPane.INFORMATION_MESSAGE);

            }catch (Exception ex){
                JOptionPane.showMessageDialog(operationPanel, "Please make sure you are entering number only",
                            "Wrong Data Type", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        HotelTravel hotelTravel = new HotelTravel();
    }

    
}