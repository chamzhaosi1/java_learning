import java.sql.*; 

public class staffdb{  
    private static final String DB_URL = "jdbc:mysql://localhost/";
    private static final String USER = "root";
    private static final String PASS = "";
    private static Connection con;
    private static String DB_NAME = "CH12_STAFFDB";
    private static String TABLE_NAME = "STAFF";

	public staffdb(){ 
        connectDataBase();
        
        if (!checkDataBaseExists()){
            createDataBase(); 

            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Occurred some of the error, when disconnet database..");
            }
        }

        if (!checkTableExists()){
            createTable();
        }
        
    }

    private void connectDataBase(){
        try {
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("Occurred some of the error, when connect database..");
            e.printStackTrace();
        }
    }

    private void createDataBase(){
        try{  
            Statement stmt = con.createStatement();
            
            String sql_createdb = "CREATE DATABASE " + DB_NAME;
            stmt.executeUpdate(sql_createdb);
            System.out.println("Database created succeffuly...");
		  
		}  catch (Exception e){
            System.out.println("Occurred some of the error, when created database..");
            e.printStackTrace();
        }
    }

    private boolean checkDataBaseExists(){

        try {
            ResultSet rs = con.getMetaData().getCatalogs();

            while (rs.next()){
                if("ch12_staffdb".equals(rs.getString(1))){
                    System.out.println("Database already exists...");
                    return true;
                }
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Occurred some of the error, when check database exits or not..");
            e.printStackTrace();
        }

        return false;
    }

    private void createTable(){
        try {
            Statement stmt = con.createStatement();

            String sql_createTable = 
            "CREATE TABLE "+ TABLE_NAME +" (" +
                "id char(9) not null, " +
                "lastName varchar(15),  " +
                "firstName varchar(15),  " +
                "mi char(1), " +
                "address varchar(20),  " +
                "city varchar(20),  " +
                "state char(2),  " +
                "telephone char(10),  " +
                "email varchar(40),  " +
                "primary key (id))";

                // System.out.println(sql_createTable);

            stmt.executeUpdate(sql_createTable);
            System.out.println("Table created succeffuly...");

        } catch (Exception e) {
            System.out.println("Occurred some of the error, when create table..");
            e.printStackTrace();
        }      
    }

    private boolean checkTableExists(){
        try {
            con = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
            ResultSet rs = con.getMetaData().getTables(null, null, TABLE_NAME, null);

            while (rs.next()){
                System.out.println("Table already exists...");
                return true;
            }

        } catch (Exception e) {
            System.out.println("Occurred some of the error, when check table exits or not..");
            e.printStackTrace();
        }

        return false;
    }
}