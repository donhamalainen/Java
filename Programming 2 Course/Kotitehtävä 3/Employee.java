
/* KIRJASTO */
import java.time.Year;

/* KIRJASTO END */
public abstract class Employee extends Person implements Payment {
    /* ATTRIBUUTIT */
    private String empId;
    private int startYear = Year.now().getValue();
    private Payment payment;
    /* ATTRIBUUTIT END */

    /* MUODOSTIN */

    /*
     * The constructor sets the last name and the first name of the
     * Employee plus generates the empId string (see the format
     * above) and sets the default start year. For the empId, utilize the
     * method getRandomId from the Person class.
     */
    public Employee(String lname, String fname) {
        super(lname, fname);
        this.empId = getEmployeeIdString()
                + super.getRandomId(ConstantValues.MIN_EMP_ID, ConstantValues.MAX_EMP_ID);
    }
    /* MUODOSTIN END */

    /* METODIT */

    // The method returns the empId string.
    public String getIdString() {
        return empId;
    }

    // By default, current year (if not set).
    public int getStartYear() {
        return startYear;
    }

    /*
     * The year must be after 2000 and cannot be in the
     * future, i.e., 2000 < startYear <= current year.
     */
    public void setStartYear(final int startYear) {
        if (2000 < startYear && startYear <= Year.now().getValue()) {
            this.startYear = startYear;
        }
    }

    // The method returns the Payment object.
    public Payment getPayment() {
        return payment;
    }

    // The method will set the given payment if it is not null!
    public void setPayment(Payment payment) {
        if (payment != null) {
            this.payment = payment;
        }
    }

    /*
     * The method calculates and returns the amount of the
     * payment (if the attribute payment is not null,
     * otherwise returns 0.0).
     */
    public double calculatePayment() {
        if (payment != null) {
            return payment.calculatePayment();
        }
        return 0.0;
    }
    /* ============ PROTECTED ============ */

    /*
     * Abstract, protected method. The method returns the
     * string for the empId. No functionality.
     */
    protected abstract String getEmployeeIdString();

    /* ============ PROTECTED END ============ */
    /* METODIT END */
}