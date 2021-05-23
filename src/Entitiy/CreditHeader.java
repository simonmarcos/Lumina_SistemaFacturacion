package Entitiy;

import java.util.Date;

public class CreditHeader {

    private Date date;
    private int nroCreditNote;
    private int codEmission;
    private String letter;
    private Client client;

    public CreditHeader(Date date, int nroCreditNote, int codEmission, String letter, Client client) {
        this.date = date;
        this.nroCreditNote = nroCreditNote;
        this.codEmission = codEmission;
        this.letter = letter;
        this.client = client;
    }

    public CreditHeader() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNroCreditNote() {
        return nroCreditNote;
    }

    public void setNroCreditNote(int nroCreditNote) {
        this.nroCreditNote = nroCreditNote;
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
        return "CreditHeader{" +
                "date=" + date +
                ", nroCreditNote=" + nroCreditNote +
                ", codEmission=" + codEmission +
                ", letter='" + letter + '\'' +
                ", client=" + client +
                '}';
    }
}
