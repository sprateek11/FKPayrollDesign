package test;

import payroll.*;
import java.util.*;
import java.time.LocalDateTime;


public class Testing {
	public static void addSalariedEmployees(Database db) {
		// Employees data
		int empId = 1001;
		String name = "Prateek Soni";
		String address = "bangaluru";
		Schedule schedule = Schedule.Monthly;
		PaymentMethod method = PaymentMethod.Bank_Transfer;
		double salary = 100_000;

		// Creation of the Employee
		Employee e = new Employee(empId,name,address);
		e.schedule = schedule;
		e.method = method;
		e.classification = new SalariedClassification(salary);

		db.addEmployee(empId,e);
	}

	public static void addHourlyEmployees(Database db) {
		// ---------------------------------------------------------------------------
		int empId = 1002;
		String name = "Rohan Malik";
		String address = "Gurgaon";
		Schedule schedule = Schedule.Weekly;
		PaymentMethod method = PaymentMethod.Postal_Address;
		double hourlyRate = 15;

		Employee e1 = new Employee(empId,name,address);
		e1.schedule = schedule;
		e1.method = method;
		e1.classification = new HourlyClassification(hourlyRate);

		PaymentClassification pc1 = e1.classification;
		HourlyClassification hc1 = (HourlyClassification) pc1;
		hc1.addTimeCard(LocalDateTime.of(2020,5,4,0,0), 8);
		hc1.addTimeCard(LocalDateTime.of(2020,5,5,0,0), 8);
		hc1.addTimeCard(LocalDateTime.of(2020,5,6,0,0), 8);
		hc1.addTimeCard(LocalDateTime.of(2020,5,7,0,0), 9);
		hc1.addTimeCard(LocalDateTime.of(2020,5,8,0,0), 10);
		hc1.addTimeCard(LocalDateTime.of(2020,5,11,0,0), 8);
		hc1.addTimeCard(LocalDateTime.of(2020,5,12,0,0), 8);
		hc1.addTimeCard(LocalDateTime.of(2020,5,13,0,0), 8);
		hc1.addTimeCard(LocalDateTime.of(2020,5,14,0,0), 9);
		hc1.addTimeCard(LocalDateTime.of(2020,5,15,0,0), 10);
		hc1.addTimeCard(LocalDateTime.of(2020,5,18,0,0), 8);
		hc1.addTimeCard(LocalDateTime.of(2020,5,19,0,0), 8);
		hc1.addTimeCard(LocalDateTime.of(2020,5,20,0,0), 8);
		hc1.addTimeCard(LocalDateTime.of(2020,5,21,0,0), 9);
		hc1.addTimeCard(LocalDateTime.of(2020,5,22,0,0), 10);
		hc1.addTimeCard(LocalDateTime.of(2020,5,25,0,0), 8);
		hc1.addTimeCard(LocalDateTime.of(2020,5,26,0,0), 8);
		hc1.addTimeCard(LocalDateTime.of(2020,5,27,0,0), 8);
		hc1.addTimeCard(LocalDateTime.of(2020,5,28,0,0), 9);
		hc1.addTimeCard(LocalDateTime.of(2020,5,29,0,0), 10);



		db.addEmployee(empId,e1);

		// ---------------------------------------------------------------------------
		empId = 1003;
		name = "Rajan Rajwansh";
		address = "Bokaaro";
		schedule = Schedule.BiWeekly;
		method = PaymentMethod.Postal_Address;
		hourlyRate = 20;

		Employee e2 = new Employee(empId,name,address);
		e2.schedule = schedule;
		e2.method = method;
		e2.classification = new HourlyClassification(hourlyRate);

		PaymentClassification pc2 = e2.classification;
		HourlyClassification hc2 = (HourlyClassification) pc2;
		hc2.addTimeCard(LocalDateTime.of(2020,5,4,0,0), 8);
		hc2.addTimeCard(LocalDateTime.of(2020,5,5,0,0), 8);
		hc2.addTimeCard(LocalDateTime.of(2020,5,6,0,0), 8);
		hc2.addTimeCard(LocalDateTime.of(2020,5,7,0,0), 9);
		hc2.addTimeCard(LocalDateTime.of(2020,5,8,0,0), 10);
		hc2.addTimeCard(LocalDateTime.of(2020,5,11,0,0), 8);
		hc2.addTimeCard(LocalDateTime.of(2020,5,12,0,0), 8);
		hc2.addTimeCard(LocalDateTime.of(2020,5,13,0,0), 8);
		hc2.addTimeCard(LocalDateTime.of(2020,5,14,0,0), 9);
		hc2.addTimeCard(LocalDateTime.of(2020,5,15,0,0), 10);
		hc2.addTimeCard(LocalDateTime.of(2020,5,18,0,0), 8);
		hc2.addTimeCard(LocalDateTime.of(2020,5,19,0,0), 8);
		hc2.addTimeCard(LocalDateTime.of(2020,5,20,0,0), 8);
		hc2.addTimeCard(LocalDateTime.of(2020,5,21,0,0), 9);
		hc2.addTimeCard(LocalDateTime.of(2020,5,22,0,0), 10);
		hc2.addTimeCard(LocalDateTime.of(2020,5,25,0,0), 8);
		hc2.addTimeCard(LocalDateTime.of(2020,5,26,0,0), 8);
		hc2.addTimeCard(LocalDateTime.of(2020,5,27,0,0), 8);
		hc2.addTimeCard(LocalDateTime.of(2020,5,28,0,0), 9);
		hc2.addTimeCard(LocalDateTime.of(2020,5,29,0,0), 10);


		db.addEmployee(empId,e2);
		// ---------------------------------------------------------------------------

	}

	public static void addCommissionedEmployees(){
		int empId = 1002;
		String name = "Rohan Malik";
		String address = "Gurgaon";
		Schedule schedule = Schedule.Monthly;
		PaymentMethod method = PaymentMethod.Bank_Transfer;

		Employee e3 = new Employee(empId,name,address);
	}


	public static void main(String[] args) {
		Database db = new Database();
		addSalariedEmployees(db);
		addHourlyEmployees(db);

		Collection<Employee> employees = db.getAllEmployees();
		// for(Employee e : employees){
		// 	System.out.println("-----------------------------------------------------------------");
		// 	System.out.println("empId:       " + e.empId);
		// 	System.out.println("name:        " + e.name);
		// 	System.out.println("address:     " + e.address);
		// 	System.out.println("schedule:    " + e.schedule);
		// 	System.out.println("method:      " + e.method);
		// }

		LocalDateTime payDate = LocalDateTime.of(2020,5,29,0,0);
		PayDayTransact payDayTransact= new PayDayTransact(payDate,db);

		// get paychecks
		Paycheck pc;
		LocalDateTime startDate;

		for(Employee e : employees){
			if(e.isPayDate(payDate)){
				System.out.println("-----------------------------------------------------------------");
				System.out.println("empId:       		" + e.empId);
				System.out.println("name:        		" + e.name);
				System.out.println("address:     		" + e.address);
				System.out.println("schedule:    		" + e.schedule);
				System.out.println("method:      		" + e.method);

				startDate = e.getPayStartDate(payDate);
				pc = new Paycheck(startDate,payDate);
				e.payDay(pc);

				System.out.println("paying amount:      	" + pc.netPay);
			}
		}
	}
			// System.out.println("-----------------------------------------------------------------");
			// System.out.println("empId:       " + e.empId);
			// System.out.println("name:        " + e.name);
			// System.out.println("address:     " + e.address);
			// System.out.println("schedule:    " + e.schedule);
			// System.out.println("method:      " + e.method);
}