import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.DriverManager;
import java.sql.Driver;
import java.sql.*;

public class Connect {
	public Statement stmt; 
    public PreparedStatement preparedStatement;
    public ResultSet rs;
    public ResultSetMetaData md;
    public Connection con;
    String query;
    
	public Connect() {
		try{  
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
            stmt = con.createStatement();  
            
            System.out.println("Connected to the database..");
        }catch(Exception e){ 
            System.out.println(e);
        }  
	}

    public ResultSet executeQuery(String query){ 
        try{
            rs = stmt.executeQuery(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return rs;
    }

    public void callLogin(String username, String password) {
    	query = "SELECT * FROM users WHERE username = '"+username+"' AND password = '"+password+"' ";
    	try {
    		executeQuery(query);	
		} catch (Exception e) {
			e.printStackTrace();
		}	
    }
    
    public void searchBook(String name) {
    	query = "SELECT * FROM books WHERE name= '"+name+"'";
    	try {
    		executeQuery(query);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void showAll() {
    	query = "SELECT * FROM books";
    	try {
    		executeQuery(query);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
}
