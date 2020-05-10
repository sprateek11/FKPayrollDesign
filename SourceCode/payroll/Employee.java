package payroll;

public class Employee {
	public int empId;
	public String name;
	public String address; // Postal address to send paychecks
	public PaymentClassification classification; // hourly, salary or commissioned


	public Schedule schedule;

	//------------------------To-do------------------------
	// public PaymentSchedule;
		// weekly, biweekly or monthly

	// public PaymentMethod;
		// postal address, held by paymaster or bank transfer


	public Employee(int empId, String name, String address, Schedule schedule){
		this.empId = empId;
		this.name = name;
		this.address = address;
		this.schedule = schedule;
	}

}