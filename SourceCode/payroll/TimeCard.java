package payroll;

import java.time.LocalDateTime;

// Stores working hours and date for hourly based workers
public class TimeCard {
    public final double hours;
    public final LocalDateTime date;

    public TimeCard(LocalDateTime date, double hours) {
        this.date = date;
        this.hours = hours;
    }
}