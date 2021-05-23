package Entitiy;

public class CreditNote {

    private CreditHeader creditHeader;
    private CreditFooter creditFooter;

    public CreditNote(CreditHeader creditHeader, CreditFooter creditFooter) {
        this.creditHeader = creditHeader;
        this.creditFooter = creditFooter;
    }

    public CreditHeader getCreditHeader() {
        return creditHeader;
    }

    public void setCreditHeader(CreditHeader creditHeader) {
        this.creditHeader = creditHeader;
    }

    public CreditFooter getCreditFooter() {
        return creditFooter;
    }

    public void setCreditFooter(CreditFooter creditFooter) {
        this.creditFooter = creditFooter;
    }

    @Override
    public String toString() {
        return "CreditNote{" +
                "creditHeader=" + creditHeader +
                ", creditFooter=" + creditFooter +
                '}';
    }
}
