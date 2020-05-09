package test;

import java.time.LocalDateTime;

import payroll.Paycheck;

public class PaycheckTest {
	public static void main(String[] args) {

		LocalDateTime startDate = LocalDateTime.of(2020, 5, 10, 0, 0);
		LocalDateTime payDate = LocalDateTime.of(2020, 5, 20, 0, 0);
		Paycheck paycheck = new Paycheck(startDate, payDate);
		 // = Paycheck(startDate, payDate);
		System.out.println(startDate);
		System.out.println(payDate.plusDays(1));
		System.out.println(paycheck.startDate);
		System.out.println(paycheck.payDate);
	}
}

// Testing of above code.
// LocalDateTime date = LocalDateTime.of(int year, Month month,
// 			int dayOfMonth, int hour, int min, int second, int nanoOfSecond)