package payroll;
	
public class SalariedClassification implements PaymentClassification {
	public double salary;

	// This type of employee has salary as the only field 
	// which needs to be payed every last working day of the month.
	public SalariedClassification(double salary) {
		this.salary = salary;
	}

	@Override
	public double calculatePay(Paycheck paycheck) {
		return salary;
	}
}
