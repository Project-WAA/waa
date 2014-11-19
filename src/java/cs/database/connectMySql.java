package cs.database;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Vinod
 */
@ManagedBean(name = "sqlHelper")

public final class connectMySql {

	private static Connection conn;
	Statement statement;
        
	public connectMySql(){
	
	}
	
	public static Connection getConnectionDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/WAADemoProject", "root", "root");
			conn.createStatement();
			System.out.print("Successfully connected");
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return connectMySql.conn;
	}
        
        public static int insetAndGetID(String qry)
        {
            try
            {
                getConnectionDB();
                Statement statement= (Statement) conn.createStatement();
                //String qry="Insert into test(name)"+"values('"+getName()+"')";
                        
		statement.execute(qry);
                System.out.println("inset pass");   
            }
            catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        System.out.println("debug:"+e.getMessage());
                        
                }
           ResultSet rs = null;
            try {
                Statement statement= (Statement) conn.createStatement();
                rs= statement.executeQuery("select LAST_INSERT_ID()");
            } catch (SQLException ex) {
                Logger.getLogger(connectMySql.class.getName()).log(Level.SEVERE, null, ex);
            }
           
           int questionID = -1;
           try
           {
                if(rs.next())
                    questionID = rs.getInt(1);
                System.out.println(questionID);
           }
           catch(Exception ex){}
           
           return questionID;
        }
        
        public static boolean insert(String qry)
        {
            try
            {
                getConnectionDB();
                Statement statement= (Statement) conn.createStatement();
                //String qry="Insert into test(name)"+"values('"+getName()+"')";
                        
		statement.execute(qry);
                System.out.println("inset pass");   
            }
            catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        System.out.println("debug:"+e.getMessage());
                        return false;
                }
                    
           return true;
                                   
        }
     
        public static ResultSet select(String qry)
        {
            
            try
            {
                Statement statement = (Statement) conn.createStatement();

                ResultSet result = statement.executeQuery(qry);
                return result;
            }
            catch(Exception ex){}
            
            return null;
        }
//        
//       public String logincheck(){
//          	try {
//                    	getConnectionDB();
//                        statement= (Statement) conn.createStatement();
//                        String qry="Insert into test(name)"+"values('"+getName()+"')";
//                        
//		statement.execute(qry);
//		
//                } catch (SQLException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                        return "index";
//                }
//           
//           return "welcomePrimefaces";
//       }
        
}
