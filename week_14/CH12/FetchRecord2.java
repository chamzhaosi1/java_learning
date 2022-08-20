import java.sql.*;  

class FetchRecord2{  
	public static void main(String args[])throws Exception{  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo?serverTimezone=UTC","root","root123");
		Statement stmt=con.createStatement();  
		  
		stmt.executeUpdate("insert into emp values(33,'Irfan',50000)");  
		int result=stmt.executeUpdate("update emp set name='Vimal',age=30 where id=33");  
		System.out.println(result+" records affected");  
		int result2=stmt.executeUpdate("delete from emp where id=34");  
		System.out.println(result2+" records affected");  
		con.close();  
		}
}  