package payroll;

import java.time.LocalDateTime;

public class Paycheck {
	public LocalDateTime payDate;
	public LocalDateTime startDate;
	public double grossPay; // calculated payment without deductions
	public double deductions; 
	public double netPay; // payment after deductions

	public Paycheck(LocalDateTime startDate, LocalDateTime payDate) {
		this.startDate = startDate;
		this.payDate = payDate;
	}

	// Testing of above code.
	// LocalDateTime date = LocalDateTime.of(int year, Month month,
	// 			int dayOfMonth, int hour, int min, int second, int nanoOfSecond)

}
