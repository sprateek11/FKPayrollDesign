package payroll;

import java.time.LocalDateTime;
import java.time.*;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.time.temporal.TemporalAdjusters;

public class Employee {
	public int empId;
	public String name;
	public String address; // Postal address to send paychecks
	public PaymentClassification classification; // hourly, salary or commissioned

	public Schedule schedule;

	// public PaymentMethod;
		// postal address, held by paymaster or bank transfer


	public Employee(int empId, String name, String address, Schedule schedule){
		this.empId = empId;
		this.name = name;
		this.address = address;
		this.schedule = schedule;
	}

	public boolean isPayDate(LocalDateTime payDate){
		if(schedule == Schedule.Weekly){
			return (DayOfWeek.from(payDate).getValue() == 5);
		}
		if(schedule == Schedule.BiWeekly){
			WeekFields weekFields = WeekFields.of(Locale.getDefault()); 
			int weekNumber = payDate.get(weekFields.weekOfWeekBasedYear());
			return (DayOfWeek.from(payDate).getValue() == 5 && weekNumber%2 == 0);
		}
		// if(schedule == Schedule.Monthly){
		// Monthly Payment cases
		else{
			LocalDateTime day = payDate.with(TemporalAdjusters.lastDayOfMonth());
			return (day == payDate);
		}

	}

	public LocalDateTime getPayStartDate(LocalDateTime payDate){
		if(schedule == Schedule.Weekly){
			return (payDate.minusDays(DayOfWeek.from(payDate).getValue() - 1));
		}
		if(schedule == Schedule.BiWeekly){
			return (payDate.minusDays(DayOfWeek.from(payDate).getValue() - 1 + 7));
		}
		// if(schedule == Schedule.Monthly){
		// Monthly Payment cases
		else{
			return null;
		}
	}

	public void payDay(Paycheck paycheck) {
		double grossPay = classification.calculatePay(paycheck);
		double deductions = 0;
		double netPay = grossPay - deductions;
		paycheck.grossPay = grossPay;
		paycheck.deductions = deductions;
		paycheck.netPay = netPay;
		// Method of payment to follow
	}


}