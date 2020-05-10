package test;

import payroll.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Testing {
	public static void addSalariedEmployees(Database db) {
		// Employees data
		int empId = 1001;
		String name = "Bot1";
		String address = "Home1";
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
		String name = "Bot2";
		String address = "Home2";
		Schedule schedule = Schedule.Weekly;
		PaymentMethod method = PaymentMethod.Postal_Address;
		double hourlyRate = 15;

		Employee e1 = new Employee(empId,name,address);
		e1.schedule = schedule;
		e1.method = method;
		e1.classification = new HourlyClassification(hourlyRate);

		PaymentClassification pc1 = e1.classification;
		HourlyClassification hc1 = (HourlyClassification) pc1;
		LocalDateTime date = LocalDateTime.of(2020,5,1,0,0);

		hc1.addTimeCard(date.plusDays(0), 8);
		hc1.addTimeCard(date.plusDays(1), 8);
		hc1.addTimeCard(date.plusDays(2), 8);
		hc1.addTimeCard(date.plusDays(3), 8);
		hc1.addTimeCard(date.plusDays(4), 9);
		hc1.addTimeCard(date.plusDays(5), 10);
		hc1.addTimeCard(date.plusDays(6), 8);
		hc1.addTimeCard(date.plusDays(7), 8);
		hc1.addTimeCard(date.plusDays(8), 8);
		hc1.addTimeCard(date.plusDays(9), 9);
		hc1.addTimeCard(date.plusDays(10), 10);
		hc1.addTimeCard(date.plusDays(11), 8);
		hc1.addTimeCard(date.plusDays(12), 8);
		hc1.addTimeCard(date.plusDays(13), 8);
		hc1.addTimeCard(date.plusDays(14), 9);
		hc1.addTimeCard(date.plusDays(15), 10);
		hc1.addTimeCard(date.plusDays(16), 8);
		hc1.addTimeCard(date.plusDays(17), 8);
		hc1.addTimeCard(date.plusDays(18), 8);
		hc1.addTimeCard(date.plusDays(19), 9);
		hc1.addTimeCard(date.plusDays(20), 10);
		hc1.addTimeCard(date.plusDays(21), 10);
		hc1.addTimeCard(date.plusDays(22), 10);
		hc1.addTimeCard(date.plusDays(23), 10);
		hc1.addTimeCard(date.plusDays(24), 10);
		hc1.addTimeCard(date.plusDays(25), 10);
		hc1.addTimeCard(date.plusDays(26), 10);
		hc1.addTimeCard(date.plusDays(27), 10);
		hc1.addTimeCard(date.plusDays(28), 10);
		hc1.addTimeCard(date.plusDays(29), 10);
		hc1.addTimeCard(date.plusDays(30), 10);
		hc1.addTimeCard(date.plusDays(31), 10);



		db.addEmployee(empId,e1);

		// ---------------------------------------------------------------------------
		empId = 1003;
		name = "Bot3";
		address = "Home3";
		schedule = Schedule.BiWeekly;
		method = PaymentMethod.Postal_Address;
		hourlyRate = 20;

		Employee e2 = new Employee(empId,name,address);
		e2.schedule = schedule;
		e2.method = method;
		e2.classification = new HourlyClassification(hourlyRate);

		PaymentClassification pc2 = e2.classification;
		HourlyClassification hc2 = (HourlyClassification) pc2;
		hc2.addTimeCard(date.plusDays(0), 8);
		hc2.addTimeCard(date.plusDays(1), 8);
		hc2.addTimeCard(date.plusDays(2), 8);
		hc2.addTimeCard(date.plusDays(3), 8);
		hc2.addTimeCard(date.plusDays(4), 9);
		hc2.addTimeCard(date.plusDays(5), 10);
		hc2.addTimeCard(date.plusDays(6), 8);
		hc2.addTimeCard(date.plusDays(7), 8);
		hc2.addTimeCard(date.plusDays(8), 8);
		hc2.addTimeCard(date.plusDays(9), 9);
		hc2.addTimeCard(date.plusDays(10), 10);
		hc2.addTimeCard(date.plusDays(11), 8);
		hc2.addTimeCard(date.plusDays(12), 8);
		hc2.addTimeCard(date.plusDays(13), 8);
		hc2.addTimeCard(date.plusDays(14), 9);
		hc2.addTimeCard(date.plusDays(15), 10);
		hc2.addTimeCard(date.plusDays(16), 8);
		hc2.addTimeCard(date.plusDays(17), 8);
		hc2.addTimeCard(date.plusDays(18), 8);
		hc2.addTimeCard(date.plusDays(19), 9);
		hc2.addTimeCard(date.plusDays(20), 10);
		hc2.addTimeCard(date.plusDays(21), 10);
		hc2.addTimeCard(date.plusDays(22), 10);
		hc2.addTimeCard(date.plusDays(23), 10);
		hc2.addTimeCard(date.plusDays(24), 10);
		hc2.addTimeCard(date.plusDays(25), 10);
		hc2.addTimeCard(date.plusDays(26), 10);
		hc2.addTimeCard(date.plusDays(27), 10);
		hc2.addTimeCard(date.plusDays(28), 10);
		hc2.addTimeCard(date.plusDays(29), 10);
		hc2.addTimeCard(date.plusDays(30), 10);
		hc2.addTimeCard(date.plusDays(31), 10);


		db.addEmployee(empId,e2);
		// ---------------------------------------------------------------------------

	}

	public static void addCommissionedEmployees(Database db){
		int empId = 1004;
		String name = "Bot4";
		String address = "Home4";
		Schedule schedule = Schedule.BiWeekly;
		PaymentMethod method = PaymentMethod.Hold_By_Master;
		
		double baseRate = 100_000;
		// double salary = baseRate;
		double commission = 5; // 5 percent commission

		Employee e1 = new Employee(empId,name,address);
		e1.schedule = schedule;
		e1.method = method;

		e1.classification = new CommissionedClassification(baseRate, commission);
		PaymentClassification pc1 = e1.classification;
		CommissionedClassification cc1 = (CommissionedClassification) pc1;
		LocalDateTime date = LocalDateTime.of(2020,5,18,0,0);
              		     /*date*/ /*amout*/
		cc1.addSalesReceipt(date.plusDays(0), 10000 );
		cc1.addSalesReceipt(date.plusDays(3), 10000 );
		cc1.addSalesReceipt(date.plusDays(10), 10000 );
		cc1.addSalesReceipt(date.plusDays(20), 10000 );
		cc1.addSalesReceipt(date.plusDays(15), 10000 );
		cc1.addSalesReceipt(date.plusDays(13), 10000 );
		cc1.addSalesReceipt(date.plusDays(23), 10000 );
		cc1.addSalesReceipt(date.plusDays(7), 10000 );

		db.addEmployee(empId,e1);

	}

	public static LocalDate getDatePart(final LocalDateTime dateTime) {
		return dateTime.toLocalDate();
	}

	public static void execute(LocalDateTime start, LocalDateTime end, Collection<Employee> employees,Database db){

		for(LocalDateTime payDate = start; payDate.isBefore(end.plusDays(1)); payDate = payDate.plusDays(1)){
			PayDayTransact payDayTransact= new PayDayTransact(payDate,db);

			for(Employee e : employees){
				if(e.isPayDate(payDate)){
					System.out.println("\n\n");
					System.out.println("Payments done to employees on: " + getDatePart(payDate));
					break;
				}
			}

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
					if(startDate == null){
						startDate = payDate.withDayOfMonth(1);
					}
					System.out.println("Pay Period: \t" + getDatePart(startDate) + "\t" + getDatePart(payDate));
					System.out.println("paying amount:      	" + pc.netPay);
				}
			}
		}

	}


	public static void main(String[] args) {
		Database db = new Database();
		addSalariedEmployees(db);
		addHourlyEmployees(db);
		addCommissionedEmployees(db);

		Collection<Employee> employees = db.getAllEmployees();
		// for(Employee e : employees){
		// 	System.out.println("-----------------------------------------------------------------");
		// 	System.out.println("empId:       " + e.empId);
		// 	System.out.println("name:        " + e.name);
		// 	System.out.println("address:     " + e.address);
		// 	System.out.println("schedule:    " + e.schedule);
		// 	System.out.println("method:      " + e.method);
		// }

		LocalDateTime start = LocalDateTime.of(2020,5,1,0,0);
		LocalDateTime end = LocalDateTime.of(2020,5,31,0,0);
		System.out.println("Summary of all payments done in month of May\n");
		execute(start,end,employees,db);
	}
}