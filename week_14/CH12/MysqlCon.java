import java.sql.*;

class MysqlCon{
public static void main(String args[]){
try{
//Class.forName("com.mysql.jdbc.Driver");

Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo?serverTimezone=UTC","root","");
//here sonoo is the database name, root is the username and root is the password
Statement stmt=con.createStatement();

ResultSet rs=stmt.executeQuery("select * from emp");

while(rs.next())
	System.out.println(rs.getInt("id") +"  "+rs.getString("Age")+"  "+rs.getString("Name"));

	con.close();

}catch(Exception e){ 
	System.out.println("Error: " + e.getMessage());
}

}
}