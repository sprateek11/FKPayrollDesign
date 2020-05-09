package payroll;

public class Employee {
	public int empId;
	public String name;
	public String address; // Postal address to send paychecks
	
	//------------------------To-do------------------------
	// public PaymentClassification;
		// hourly, salary or commissioned

	// public PaymentSchedule;
		// weekly, biweekly or monthly

	// public PaymentMethod;
		// postal address, held by paymaster or bank transfer


	public Employee(int empId, String name, String address){
		this.empId = empId;
		this.name = name;
		this.address = address;
	}
}