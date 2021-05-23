package Entitiy;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Invoice {

    private InvoiceHeader invoiceHeader;
    private List<InvoiceDetails> invoiceDetails;
    private InvoiceFooter invoiceFooter;

    public Invoice(InvoiceHeader invoiceHeader, List<InvoiceDetails> invoiceDetails, InvoiceFooter invoiceFooter) {
        this.invoiceHeader = invoiceHeader;
        this.invoiceDetails = invoiceDetails;
        this.invoiceFooter = invoiceFooter;
    }

    public Invoice() {
    }

    public InvoiceHeader getInvoiceHeader() {
        return invoiceHeader;
    }

    public void setInvoiceHeader(InvoiceHeader invoiceHeader) {
        this.invoiceHeader = invoiceHeader;
    }

    public List<InvoiceDetails> getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(List<InvoiceDetails> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public InvoiceFooter getInvoiceFooter() {
        return invoiceFooter;
    }

    public void setInvoiceFooter(InvoiceFooter invoiceFooter) {
        this.invoiceFooter = invoiceFooter;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceHeader=" + invoiceHeader +
                ", invoiceDetails=" + invoiceDetails +
                ", invoiceFooter=" + invoiceFooter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(invoiceHeader, invoice.invoiceHeader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceHeader);
    }
}
