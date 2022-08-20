import java.sql.*;
class UpdatePrepared{
public static void main(String args[]){
	try{

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo?serverTimezone=UTC","root","root123");

		PreparedStatement stmt=con.prepareStatement("update emp set name=? where id=?");
		stmt.setString(1,"Sonoo");//1 specifies the first parameter in the query i.e. name
		stmt.setInt(2,201);
		//update emp set name="Sonoo" where id=201

		int i=stmt.executeUpdate();
		System.out.println(i+" records updated");

		con.close();

		} catch(Exception e){ 
			System.out.println(e);
		}

	}
}