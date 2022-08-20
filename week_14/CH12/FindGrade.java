
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;    
import java.sql.*;


public class FindGrade extends JFrame {
  // Statement for executing queries
  private Statement stmt;
  private JTextField tfSSN = new JTextField(6);
  private JTextField tfCourseId = new JTextField(6);
  private JLabel lblStatus = new JLabel();
  
  
  public FindGrade() {
    // Initialize database connection and create a Statement object
    initializeDB();

    JButton btShowGrade = new JButton("Show Grade");
    JPanel panel = new JPanel();
    panel.add(new JLabel("SSN"));
    panel.add(tfSSN);
    panel.add( new JLabel("Course ID"));
	panel.add(tfCourseId);
	panel.add(btShowGrade);

    JPanel panel2 = new JPanel();
    panel2.add(panel);
	panel2.add(lblStatus);
    
	btShowGrade.addActionListener(new ButtonListener());

	
    add(panel2);
  
	setTitle("FindGrade");
    // Set the size of the window.
    setSize(420, 380);
    // Specify an action for the close button.
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Display the window.
    setVisible(true);
	
  }

  private void initializeDB() {
    try {
      // Load the JDBC driver
     // Class.forName("com.mysql.jdbc.Driver");
//      Class.forName("oracle.jdbc.driver.OracleDriver");
     // System.out.println("Driver loaded");

      // Establish a connection
      Connection connection = DriverManager.getConnection
        ("jdbc:mysql://localhost/sonoo?serverTimezone=UTC", "scott", "tiger");
//    ("jdbc:oracle:thin:@liang.armstrong.edu:1521:orcl",
//     "scott", "tiger");
      System.out.println("Database connected");

      // Create a statement
      stmt = connection.createStatement();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
	  
    String ssn = tfSSN.getText();
    String courseId = tfCourseId.getText();
    try {
      String queryString = "select firstName, mi, " +
        "lastName, title, grade from Student, Enrollment, Course " +
        "where Student.ssn = '" + ssn + "' and Enrollment.courseId "
        + "= '" + courseId +
        "' and Enrollment.courseId = Course.courseId " +
        " and Enrollment.ssn = Student.ssn";
	  
	  System.out.println(queryString);
      ResultSet rset = stmt.executeQuery(queryString);

      if (rset.next()) {
        String lastName = rset.getString(1);
        String mi = rset.getString(2);
        String firstName = rset.getString(3);
        String title = rset.getString(4);
        String grade = rset.getString(5);

        // Display result in a label
        lblStatus.setText(firstName + " " + mi +
          " " + lastName + "'s grade on course " + title + " is " +
          grade);
      } else {
        lblStatus.setText("Not found");
      }
    }
    catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
  }


  public static void main(String[] args) {
    new FindGrade();
  }
}