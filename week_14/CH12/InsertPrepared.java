import java.sql.*;  
class InsertPrepared{  

	public static void main(String args[]){  
		try{  
		
		  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo?serverTimezone=UTC","root","root123");
		  
		PreparedStatement stmt=con.prepareStatement("insert into Emp values(?,?,?)");  
		stmt.setInt(1,101);//1 specifies the first parameter in the query  
		stmt.setString(2,"Ratan");  
		stmt.setInt(3,29);//
		
		int i=stmt.executeUpdate();  
		System.out.println(i+" records inserted");  
		
		
        stmt.setInt(1,301);//1 specifies the first parameter in the query  
		stmt.setString(2,"Ratan2");  
		stmt.setInt(3,27);//		
		
			
		i=stmt.executeUpdate();  
		System.out.println(i+" records inserted");  
		  
		con.close();  
		  
		}catch(Exception e){ System.out.println(e);}  
		  
		}  
}