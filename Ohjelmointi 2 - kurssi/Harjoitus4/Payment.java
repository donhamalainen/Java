public class Payment {

    // ATTRIBUUTIT
    private double amount;

    // MUODOSTIMET
    public Payment(double amount) {
        this.amount = amount;
    }
    // METODIT

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void printPaymentDetails() {
        System.out.println("Payment Details: " + amount + "€");
    }
}
