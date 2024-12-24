7 Steps to configure JDBC 

1)import the package 
2)Load and register the driver 
3)Establish the Connection 
4)Create the Statement 
5)Execute the Query 
6)Process Result 
7)Close 


Here driver refers to a software component that enables java application to interact with database .

Types of JDBC Drivers 
=>JDBC-ODBC Bridge Driver 
=>Native API Driver 
=>Network Protocol Driver 
=>Thin Driver  

The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.

After JDBC 4 java 6 , It is not needed to manually check and load req class .


To Create a Connection :

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
	
	public static void main(String[] args) throws SQLException {
	
		Connection conn = null ;

		String url = "jdbc:mysql://localhost:3306/testingdemo";
		String uname = "root";
		String password = "1234";
		String query = "SELECT course_name FROM testingdemo.courses";
		
		
		try {
			conn = Database.getConnection(url, uname, password);
			System.out.println("Database Connection is Succcessfull ...");
		}
		catch(SQLException e) {
			System.out.println(e);
		}

	}

}
