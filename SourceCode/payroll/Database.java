package payroll;
import java.util.*;


public class Database {

    private static HashMap<Integer,Employee> employees = new HashMap<Integer,Employee>();
    private static HashMap<Integer,Employee> members = new HashMap<Integer, Employee>();

    public void addEmployee(int id, Employee employee) {
        employees.put(id, employee);
    }

    public Employee getEmployee(int empId) {
        return employees.get(empId);
    }

    public void deleteEmployee(int id) {
        employees.remove(id);
    }

    public Collection<Employee> getAllEmployees() {
      return employees.values();
    }
}
