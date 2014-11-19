package cs.question;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Vinod
 */
@ManagedBean(name = "insert")

public final class connectMySql {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
	private Connection conn;
	Statement statement;
        
	public connectMySql(){
	
	}
	
	public Connection getConnectionDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/WAADemoProject", "root", "root");
			conn.createStatement();
			System.out.print("Successfully connected");
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return this.conn;
	}
        
        
       public String logincheck(){
          	try {
                    	getConnectionDB();
                        statement= (Statement) conn.createStatement();
                        String qry="Insert into test(name)"+"values('"+getName()+"')";
                        
		statement.execute(qry);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
                return "index";
	}
           
           return "welcomePrimefaces";
       }
        
}
