package payroll;

import java.time.LocalDateTime;

public interface PaymentClassification {
	double calculatePay(Paycheck paycheck);
}