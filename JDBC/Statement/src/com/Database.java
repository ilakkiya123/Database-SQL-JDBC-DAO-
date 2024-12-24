package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class Database {
	
	public static Connection getConnection(String url , String uname , String password) throws SQLException {
		Connection conn = DriverManager.getConnection(url, uname, password);
		return conn ;
	}
	
	public static void closeResultSet(ResultSet rs) {
		try {
			if(rs !=null) {
				rs.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closeStatement(Statement statement) {
		try {
			if(statement !=null) {
				statement.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closeConnection(Connection connection) {
		try {
			if(connection !=null) {
				connection.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
