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
    	query = "SELECT * FROM books WHERE name LIKE '%"+name+"%'";
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
    
    public void deleteBook(String id) {
    	query = "DELETE FROM books WHERE id = '"+id+"'";
    	try {
    		stmt.executeUpdate(query);
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void deleteAcct(String id) {
    	query = "DELETE FROM users WHERE id = '"+id+"'";
    	try {
    		stmt.executeUpdate(query);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void addBook(String name, String genre, String availability) {
    	try {
    		preparedStatement = con.prepareStatement("INSERT INTO books(name, genre, availability) VALUES(?,?,?)");
    		preparedStatement.setString(1, name);
    		preparedStatement.setString(2, genre);
    		preparedStatement.setString(3, availability);
    		preparedStatement.executeUpdate();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void addAccount(String username, String password, String privilege) {
    	try {
    		preparedStatement = con.prepareStatement("INSERT INTO users(username, password, privilege) VALUES(?,?,?)");
    		preparedStatement.setString(1, username);
    		preparedStatement.setString(2, password);
    		preparedStatement.setString(3, privilege);
    		preparedStatement.executeUpdate();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void checkPrivilege(String num) {
    	query = "SELECT privilege FROM users WHERE id='"+num+"'";
    	try {
    		executeQuery(query);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void findID(String username) {
    	query = "SELECT id FROM users WHERE username='"+username+"'";
    	try {
    		executeQuery(query);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void findAcctID(String id) {
    	query = "SELECT id FROM users WHERE id='"+id+"'";
    	try {
    		executeQuery(query);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void findBID(String id) {
    	query = "SELECT id FROM books WHERE id ='"+id+"'";
    	try {
    		executeQuery(query);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void showAllUsers() {
    	query = "SELECT id, username, privilege FROM users";
    	try {
    		executeQuery(query);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    
}
