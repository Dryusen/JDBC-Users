import model.Employee;
import java.sql.*;

public class EmployeeDAO {

    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employees(name, age, position, salary) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, employee.getName());
            pstmt.setInt(2, employee.getAge());
            pstmt.setString(3, employee.getPosition());
            pstmt.setDouble(4, employee.getSalary());
            pstmt.executeUpdate();

            System.out.println("Співробітник успішно доданий!");

        } catch (SQLException e) {
            System.out.println("Помилка при додаванні: " + e.getMessage());
        }
    }

    public Employee getEmployeeById(int id) {
        String sql = "SELECT name, age, position, salary FROM employees WHERE id = ?";
        Employee employee = null;

        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String position = rs.getString("position");
                double salary = rs.getDouble("salary");

                employee = new Employee(id, name, age, position, salary);
            }

        } catch (SQLException e) {
            System.out.println("Помилка при читанні: " + e.getMessage());
        }

        return employee;
    }
}