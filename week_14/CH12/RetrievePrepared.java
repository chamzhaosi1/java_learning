import java.sql.*;
class RetrievePrepared{
	public static void main(String args[]){
		try{
		
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo?serverTimezone=UTC","root","root123");

			//PreparedStatement stmt=con.prepareStatement("select * from emp");
			PreparedStatement stmt=con.prepareStatement("select * from emp where name = ? and age = ?");
			stmt.setString(1, "Janet Lee");
            stmt.setInt(2, 21);


			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}
			
			stmt.setString(1, "Jackson Low");
            stmt.setInt(2, 3);


			rs=stmt.executeQuery();
			while(rs.next()){
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}
			

			con.close();

		} catch(Exception e){ 
			System.out.println(e);
		}

	}
}