package Entitiy;

import java.util.Date;
import java.util.Objects;

public class InvoiceHeader {

    private Date date;
    private int nroInvoice;
    private int codEmission;
    private String letter;
    private Client client;

    public InvoiceHeader(Date date, int nroInvoice, int codEmission, String letter, Client client) {
        this.date = date;
        this.nroInvoice = nroInvoice;
        this.codEmission = codEmission;
        this.letter = letter;
        this.client = client;
    }

    public InvoiceHeader() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNroInvoice() {
        return nroInvoice;
    }

    public void setNroInvoice(int nroInvoice) {
        this.nroInvoice = nroInvoice;
    }

    public int getCodEmission() {
        return codEmission;
    }

    public void setCodEmission(int codEmission) {
        this.codEmission = codEmission;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "InvoiceHeader{" +
                "date=" + date +
                ", nroInvoice=" + nroInvoice +
                ", codEmission=" + codEmission +
                ", letter='" + letter + '\'' +
                ", client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceHeader that = (InvoiceHeader) o;
        return nroInvoice == that.nroInvoice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nroInvoice);
    }
}
