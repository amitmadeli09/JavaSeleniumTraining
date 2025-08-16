package day14;

import java.sql.*;

public class JdbcPractise1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:mysql://localhost:3306/employee";
		String username = "root";
		String password = "Gabru1234@";
		String query = "SELECT * FROM employee";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,username,password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while (rs.next()) {
			int id = rs.getInt(1);
			String name=rs.getString(2);
			int salary = rs.getInt(3);
			System.out.println("ID: "+id+" ,Name: "+name+",Salary: "+salary);
		}
		
		st.close();
		con.close();

	}

}
