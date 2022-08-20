import java.sql.*;
class DeletePrepared{
	public static void main(String args[]){
		try{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo?serverTimezone=UTC","root","root123");


			PreparedStatement stmt=con.prepareStatement("delete from emp where id=?");
			stmt.setInt(1,301);

			int i=stmt.executeUpdate();
			System.out.println(i+" records deleted");
			
			stmt.setInt(1,101);

			i=stmt.executeUpdate();
			System.out.println(i+" records deleted");

			con.close();

		} catch(Exception e){ 
			System.out.println(e);
		}

	}
}