package test;

import java.time.LocalDateTime;
import payroll.*;

public class EmployeeTest {
	public static void main(String[] args) {
		int empId = 1010;
		String name = "Prateek";
		String address = "Holand";
		// Schedule schedule = Schedule.Monthly;

		Employee e = new Employee(empId, name, address);
		
		System.out.println(e.empId);	
		System.out.println(e.name);	
		System.out.println(e.address);	
		System.out.println(e.schedule);	
	}
}

