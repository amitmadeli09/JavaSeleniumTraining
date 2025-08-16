package day14;
import java.sql.*;
public class JdbcPractise2 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/employee"; // Make sure the 'employee' database exists
        String user = "root";
        String password = "Gabru1234@";

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            // Create employee table if it does not exist
            String createTable = "CREATE TABLE IF NOT EXISTS employee (" +
                                 "id INT AUTO_INCREMENT PRIMARY KEY, " +
                                 "name VARCHAR(100), " +
                                 "salary DOUBLE)";
            st.executeUpdate(createTable);
            System.out.println("Created employee table (if not exists).");

            // Insert a new employee (id is auto-incremented)
            String insertQuery = "INSERT INTO employee(name, salary) VALUES('PSubham', 21000)";
            st.executeUpdate(insertQuery);
            System.out.println("Inserted new employee (auto-incremented ID).");

            // Fetch and display all employees
            String selectQuery = "SELECT * FROM employee";
            ResultSet rs = st.executeQuery(selectQuery);
            System.out.println("Employee Records:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
            }

            // Optional: Update an employee by name
            String updateQuery = "UPDATE employee SET salary = 60000 WHERE name = 'Satabdi'";
            st.executeUpdate(updateQuery);
            System.out.println("Updated salary for Satabdi.");
            
            
            // Optional: Delete an employee by name
            String deleteQuery = "DELETE FROM employee WHERE name = 'Satabdi'";
            st.executeUpdate(deleteQuery);
            System.out.println("Deleted employee 'Satabdi'.");

            // Clean up
            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
