package Entitiy;

public class InvoiceDetails {

    private String product;
    private double unitPrice;
    private double IVA;
    private int count;
    private double salePrice;
    private double netoPrice;
    private double amountIVA;

    public InvoiceDetails(String product, double unitPrice, double IVA, int count, double salePrice, double netoPrice, double amountIVA) {
        this.product = product;
        this.unitPrice = unitPrice;
        this.IVA = IVA;
        this.count = count;
        this.salePrice = salePrice;
        this.netoPrice = netoPrice;
        this.amountIVA = amountIVA;
    }

    public InvoiceDetails() {
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getNetoPrice() {
        return netoPrice;
    }

    public void setNetoPrice(double netoPrice) {
        this.netoPrice = netoPrice;
    }

    public double getAmountIVA() {
        return amountIVA;
    }

    public void setAmountIVA(double amountIVA) {
        this.amountIVA = amountIVA;
    }

    @Override
    public String toString() {
        return "InvoiceDetails{" +
                "product='" + product + '\'' +
                ", unitPrice=" + unitPrice +
                ", IVA=" + IVA +
                ", count=" + count +
                ", salePrice=" + salePrice +
                ", netoPrice=" + netoPrice +
                ", amountIVA=" + amountIVA +
                '}';
    }
}
