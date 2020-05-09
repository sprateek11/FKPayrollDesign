package payroll;

import java.util.*;
import java.time.LocalDateTime;

public class HourlyClassification implements PaymentClassification{
    public double hourlyRate;
    public HashMap<LocalDateTime,TimeCard> timecards = new HashMap<LocalDateTime,TimeCard>();

    // HourlyRate is the field for Hour based Workers
    public HourlyClassification(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    // For new days
    public void addTimeCard(LocalDateTime date, double workingHours) {
        timecards.put(date, new TimeCard(date, workingHours));
    }

    @Override
    public double calculatePay(Paycheck paycheck) {
        double salary = 0;
        for(LocalDateTime date = paycheck.startDate; date.isBefore((paycheck.payDate).plusDays(1)); date = date.plusDays(1)) {
            if (timecards.get(date) != null) {
                double hours = timecards.get(date).hours;
                // Hours worked times rate
                salary += hourlyRate * hours;
                // If worked more than 8 hours then
                // adding 0.5 times extra pay for extra hours worked
                if (hours > 8.0)
                    salary += hourlyRate * (hours - 8) / 2.0;
            }
        }
        return salary;
    }
}
