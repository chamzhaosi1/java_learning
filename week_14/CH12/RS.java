import java.sql.*;  
import java.io.*;  

class RS{  
	public static void main(String args[])throws Exception{  
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo?serverTimezone=UTC","root","root123"); 
		  
		PreparedStatement ps=con.prepareStatement("insert into emp values(?,?,?)");  
		  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		  
		do{  
			System.out.println("enter id:");  
			int id=Integer.parseInt(br.readLine());  
			System.out.println("enter name:");  
			String name=br.readLine();  
			System.out.println("enter age:");  
			int age=Integer.parseInt(br.readLine());  
			//float salary=Float.parseFloat(br.readLine());  
  
			ps.setInt(1,id);  
			ps.setString(2,name);  
			//ps.setFloat(3,salary);  
			ps.setInt(3,age);  
			int i=ps.executeUpdate();  
			System.out.println(i+" records affected");  
			  
			System.out.println("Do you want to continue: y/n");  
			String s=br.readLine();  
			
			if(s.startsWith("n")){  
				break;  
			}  
		}	while(true);  
		  
		con.close();  
	}
}