package Entitiy;

public class InvoiceFooter {

    private double total;
    private double totalIVA;

    public InvoiceFooter(double total, double totalIVA) {
        this.total = total;
        this.totalIVA = totalIVA;
    }

    public InvoiceFooter() {
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalIVA() {
        return totalIVA;
    }

    public void setTotalIVA(double totalIVA) {
        this.totalIVA = totalIVA;
    }

    @Override
    public String toString() {
        return "InvoiceFooter{" +
                "total=" + total +
                ", totalIVA=" + totalIVA +
                '}';
    }
}
