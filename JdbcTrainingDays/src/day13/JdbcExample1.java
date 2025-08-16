package day13;
import java.sql.*;

public class JdbcExample1 {

	public static void main(String[] args) throws Exception{
		
		String url = "jdbc:mysql://localhost:3306/college";
		String username = "root";
		String password = "Gabru1234@";
		String query = "select * from students";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,username,password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
//		rs.next();
		while (rs.next()) {
			int id = rs.getInt(1);
			String name=rs.getString(2);
			System.out.println("ID is "+id+" name is :"+name);
		}
		
		st.close();
		con.close();
	}
}
