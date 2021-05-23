package Entitiy;

public class CreditFooter {

    private double total;

    public CreditFooter(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CreditFooter{" +
                "total=" + total +
                '}';
    }
}
