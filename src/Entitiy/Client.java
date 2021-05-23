package Entitiy;

import java.util.Objects;

public class Client implements Comparable<Client> {

    private int nroClient;
    private String address;
    private String taxCondition;
    private String documentType;
    private int dni;

    public Client(int nroClient, String address, String taxCondition, String documentType, int dni) {
        this.nroClient = nroClient;
        this.address = address;
        this.taxCondition = taxCondition;
        this.documentType = documentType;
        this.dni = dni;
    }

    public Client() {
    }

    public int getNroClient() {
        return nroClient;
    }

    public void setNroClient(int nroClient) {
        this.nroClient = nroClient;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTaxCondition() {
        return taxCondition;
    }

    public void setTaxCondition(String taxCondition) {
        this.taxCondition = taxCondition;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nroClient=" + nroClient +
                ", address='" + address + '\'' +
                ", taxCondition='" + taxCondition + '\'' +
                ", documentType='" + documentType + '\'' +
                ", dni=" + dni +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return nroClient == client.nroClient &&
                dni == client.dni;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nroClient, dni);
    }

    @Override
    public int compareTo(Client o) {
        return String.valueOf(this.getDni()).compareTo(String.valueOf(o.getDni()));
    }
}
