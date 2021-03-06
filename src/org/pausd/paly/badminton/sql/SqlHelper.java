package org.pausd.paly.badminton.sql;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
/**
 * 
 * @author michaelchau
 * class for executing sql commands on the mysql database
 */
public class SqlHelper {
	//MAY NEED TO REVISE SQLHELPER METHODS TO MAKE MORE SENSE/MORE CONCISE WHEN CALLING METHODS
	static Connection c;//connection to database
	static Statement stmt = null;//used to run command on database
	
	/**
	 * 
	 * @return statement to run commands on database
	 * initialize connection to database
	 */
	public static Statement initializeDB(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "";
			String un = "";
			String pw = "";//FILL OUT LATER WHEN DATABASE SET UP
			c = (Connection) DriverManager.getConnection(url,un,pw);
			stmt = (Statement) c.createStatement();
			System.out.println(1);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		return stmt;
	}
	
	/**
	 * close off connection to database
	 */
	public static void closeConnection(){
		try {
			c.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * 
	 * @param column- which column in database
	 * @param database- which table in mysql to interact with
	 * @param where- "where" clause in sql 
	 * @return- data returend as a result of database query
	 * get a specific value from database
	 */
	public static String get(String column, String database,String where){
		String result = null;
		try{
			stmt = initializeDB();//connect to database
			String query = "SELECT " + column +
							" FROM " + database + 
							" WHERE " + where;//query to execute
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				result = rs.getString(1);//get data
			}
			rs.close();
			closeConnection();//close connectionto database
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		return result;//return desired data as a string
	}
	
	/**
	 * 
	 * @param database- which table to interact with
	 * @param set- what to set the value to
	 * @param where- "Where" statement in sql language
	 * set a specific piece of data to desired value in database
	 */
	public static void set(String database, String set,String where){
		try{
			stmt = initializeDB();//connect to database
			String update = "UPDATE " + database +
							" SET " + set +
							" WHERE " + where;//query to execute
			stmt.executeUpdate(update);
			closeConnection();//close connection to database
		} catch(SQLException e){
			JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * 
	 * @return a full list of all ids in the database
	 */
	public static ArrayList<String> getAllIds(){
		ArrayList<String> ids = new ArrayList<>();
		try{
			stmt = initializeDB();//connect to database
			String query = "SELECT id " + 
							"FROM players";//query to execute
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				ids.add(rs.getString(1));//get ids from database
			}
			rs.close();
			closeConnection();//close connection to database
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		return ids;//return array of ids
	}
}
