package org.pausd.gunn.badminton;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class SqlHelper {
	static Connection c;
	static Statement stmt = null;
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
	public static void closeConnection(){
		try {
			c.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static String get(String column, String database,String where){
		String result = null;
		try{
			stmt = initializeDB();
			String query = "SELECT " + column +
							" FROM " + database + 
							" WHERE " + where;
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				result = rs.getString(1);
			}
			rs.close();
			closeConnection();
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		return result;
	}
	public static void set(String database, String set,String where){
		try{
			stmt = initializeDB();
			String update = "UPDATE " + database +
							" SET " + set +
							" WHERE " + where;
			stmt.executeUpdate(update);
			closeConnection();
		} catch(SQLException e){
			JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}
}
