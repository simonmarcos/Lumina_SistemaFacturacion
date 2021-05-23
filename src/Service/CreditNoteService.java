package Service;

import Entitiy.*;
import Repository.ICreditNote;

import java.util.List;

public class CreditNoteService {

    private ICreditNote iCreditNote;

    public CreditNoteService(ICreditNote iCreditNote) {
        this.iCreditNote = iCreditNote;
    }

    public List<CreditNote> generateCreditNote(List<Order> listOrder, String[] listNroOrder) {
        return iCreditNote.generateCreditNote(listOrder, listNroOrder);
    }

    public CreditFooter createCreditNoteFooter(List<Product> listProduct, String taxCondition) {
        return iCreditNote.createCreditNoteFooter(listProduct, taxCondition);
    }
}
