package Demo;

import java.sql.*;

public class Main {
	public static void main(String[] args) throws SQLException {
			
			Connection conn = null ;
			Statement statement = null ;
			ResultSet rs = null ;

			String url = "jdbc:mysql://localhost:3306/testingdemo";
			String uname = "root";
			String password = "1234";
			String sql1 = "CREATE TABLE IF NOT EXISTS flower.flower (id INT NOT NULL AUTO_INCREMENT,name VARCHAR(32) NOT NULL,PRIMARY KEY (id))";//execute(query)
			String sql2 = "INSERT INTO flower.flower (name) Values('jasmine'),('sunflower'),('hibiscus');";//executeUpdate(query)
			String sql3 = "SELECT * FROM testingdemo.employees WHERE age = ?;";//executeQuery(query)
			
			
			try {
				conn = Database.getConnection(url, uname, password);
				System.out.println("Database Connection is Succcessfull ...");
				PreparedStatement ps = conn.prepareStatement(sql3);
				ps.setInt(1, 28);
				rs = ps.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("employee_id");
					String name = rs.getString("name");
					int age = rs.getInt("age");
					
					System.out.println(id + " " + name + " " + age);
				}
			}
			catch(SQLException e) {
				System.out.println(e);
			}finally {
				Database.closeResultSet(rs);
				Database.closeStatement(statement);
				Database.closeConnection(conn);
				
			}
	}
}
