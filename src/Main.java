import model.Employee;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();

        Employee emp = new Employee("John Doe", 30, "Developer", 5000.0);

        dao.addEmployee(emp);

        Employee fromDB = dao.getEmployeeById(1);
        if (fromDB != null) {
            System.out.println("Отриманий співробітник: " + fromDB);
        }
    }
}
