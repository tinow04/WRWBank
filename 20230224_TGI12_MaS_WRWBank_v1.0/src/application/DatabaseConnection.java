package application;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.QueryReturnType;


public class DatabaseConnection {

	public Connection databaseLink;
	
	public Connection getConnection() {
		String databaseName = "pocbase";
		String databaseUser = "root";
		String databasePassword = "SQL187M1e38!";
		String url = "jdbc:mysql://localhost/" + databaseName;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			databaseLink = DriverManager.getConnection(url,databaseUser, databasePassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return databaseLink;
	}
	
}
