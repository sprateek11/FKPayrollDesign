package payroll;

import java.util.*;
import java.time.LocalDateTime;

public class PayDayTransact implements Transact {
    // payDate
    private final LocalDateTime payDate;
    // paychecks of all the employees which needs to be paid on payDate date.
    private HashMap<Integer, Paycheck> paychecks = new HashMap<Integer, Paycheck>();
    // Database of all employees
    private Database db;

    public PayDayTransact(LocalDateTime payDate, Database db) {
        this.payDate = payDate;
        this.db = db;
    }

    @Override
    public void execute() {
        Collection<Employee> employees = db.getAllEmployees();
        
        for (Employee e : employees) {
            if (e.isPayDate(payDate)) {
                LocalDateTime startDate = e.getPayStartDate(payDate);
                // Creating an empty paycheck for employee e.
                Paycheck pc = new Paycheck(startDate, payDate);
                paychecks.put(e.empId, pc);
                // Below line calculates pay for the employee e.
                e.payDay(pc);
            }
        }
    }

    public Paycheck getPaycheck(int empId) {
        return paychecks.get(empId);
    }

}
