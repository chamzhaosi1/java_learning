import java.sql.*; 

public class Staffdb{  
    private static final String DB_URL = "jdbc:mysql://localhost/";
    private static final String USER = "root";
    private static final String PASS = "";
    private static Connection con;
    private static String DB_NAME = "CH12_STAFFDB";
    private static String TABLE_NAME = "STAFF";

	public Staffdb(){ 
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
            dataBaseClose();
        }
    }

    private void connectDataBaseWithDB(){
        try {
            con = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
        } catch (Exception e) {
            System.out.println("Occurred some of the error, when connect database..");
            e.printStackTrace();
            dataBaseClose();
        }
    }

    private void createDataBase(){
        try{  
            Statement stmt = con.createStatement();
            
            String sql_createdb = "CREATE DATABASE " + DB_NAME;
            stmt.executeUpdate(sql_createdb);
            dataBaseClose();
            System.out.println("Database created succeffuly...");
		  
		}  catch (Exception e){
            System.out.println("Occurred some of the error, when created database..");
            e.printStackTrace();
            dataBaseClose();
        }
    }

    private boolean checkDataBaseExists(){

        try {
            ResultSet rs = con.getMetaData().getCatalogs();

            while (rs.next()){
                if("ch12_staffdb".equals(rs.getString(1))){
                    System.out.println("Database already exists...");
                    dataBaseClose();
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Occurred some of the error, when check database exits or not..");
            e.printStackTrace();
            dataBaseClose();
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
                "telephone char(15),  " +
                "email varchar(40),  " +
                "primary key (id))";

                // System.out.println(sql_createTable);

            stmt.executeUpdate(sql_createTable);
            System.out.println("Table created succeffuly...");
            dataBaseClose();

        } catch (Exception e) {
            System.out.println("Occurred some of the error, when create table..");
            e.printStackTrace();
            dataBaseClose();
        }      
    }

    private boolean checkTableExists(){
        try {
            connectDataBaseWithDB();
            ResultSet rs = con.getMetaData().getTables(null, null, TABLE_NAME, null);

            while (rs.next()){
                System.out.println("Table already exists...");
                dataBaseClose();
                return true;
            }

        } catch (Exception e) {
            System.out.println("Occurred some of the error, when check table exits or not..");
            e.printStackTrace();
            dataBaseClose();
        }

        return false;
    }

    private void dataBaseClose(){
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Occurred some of the error, when close the database connection..");
            e.printStackTrace();
        }
    }

    public void insertData(Staff staff){
        connectDataBaseWithDB();
        String sql_insert = "INSERT INTO " + TABLE_NAME + " (id, lastName, firstName, mi, address, city, state, telephone) values (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStmt = con.prepareStatement(sql_insert);
            preparedStmt.setString(1, staff.getId());
            preparedStmt.setString(2, staff.getLastName());
            preparedStmt.setString(3, staff.getFirstName());
            preparedStmt.setString(4, staff.getMi());
            preparedStmt.setString(5, staff.getAddress());
            preparedStmt.setString(6, staff.getCity());
            preparedStmt.setString(7, staff.getState());
            preparedStmt.setString(8, staff.getTelephone());

            preparedStmt.execute();
            
        } catch (Exception e) {
            System.out.println("Occurred some of the error, when inserting data..");
            e.printStackTrace();

        } finally{
            dataBaseClose();
        }
    }

    public Staff selectData(String idNumber){
        String sql_select = "SELECT * FROM "+ TABLE_NAME +" WHERE id = ?";

        try {
            connectDataBaseWithDB();
            PreparedStatement preparedStmt = con.prepareStatement(sql_select);
            preparedStmt.setString(1, idNumber);

            ResultSet rs = preparedStmt.executeQuery();


            while (rs.next()){
                Staff staff = new Staff();
                staff.setId(rs.getString("id"));
                staff.setLastName(rs.getString("lastName"));
                staff.setFirstName(rs.getString("firstName"));
                staff.setMi(rs.getString("mi"));
                staff.setAddress(rs.getString("address"));
                staff.setCity(rs.getString("city"));
                staff.setState(rs.getString("state"));
                staff.setTelephone(rs.getString("telephone"));
                staff.setEmail(rs.getString("email"));

                dataBaseClose();

                return staff;
            }

            return null;


        } catch (Exception e) {
            System.out.println("Occurred some of the error, when selecting data..");
            e.printStackTrace();

        }finally{
            dataBaseClose();
        }

        return null;
    }

    public void updateData(Staff staff){
        String sql_update = "UPDATE "+ TABLE_NAME +" SET lastName = ?, firstName = ?, mi = ?, address = ?, city = ?, state = ?, telephone = ? WHERE id = ?";

        try {
            connectDataBaseWithDB();
            PreparedStatement preparedStmt = con.prepareStatement(sql_update);

            preparedStmt.setString(1, staff.getLastName());
            preparedStmt.setString(2, staff.getFirstName());
            preparedStmt.setString(3, staff.getMi());
            preparedStmt.setString(4, staff.getAddress());
            preparedStmt.setString(5, staff.getCity());
            preparedStmt.setString(6, staff.getState());
            preparedStmt.setString(7, staff.getTelephone());
            preparedStmt.setString(8, staff.getId());

            preparedStmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Occurred some of the error, when inserting data..");
            e.printStackTrace();

        } finally{
            dataBaseClose();
        }
    }
}