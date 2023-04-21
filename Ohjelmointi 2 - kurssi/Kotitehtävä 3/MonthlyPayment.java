public class MonthlyPayment implements Payment {
    /* ATTRIBUUTIT */
    private double salary;
    /* ATTRIBUUTIT END */

    /* METODIT */

    // The method returns the salary.
    public double getSalary() {
        return salary;
    }

    // The method sets the salary if the value is > 0.0
    public void setSalary(double salary) {
        if (salary > 0.0) {
            this.salary = salary;
        }
    }

    // The method returns the salary.
    @Override
    public double calculatePayment() {
        return salary;
    }

    /* METODIT END */
}
