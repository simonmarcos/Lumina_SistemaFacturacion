package Repository;

import Entitiy.*;

import java.util.List;

public interface ICreditNote {

    List<CreditNote> generateCreditNote(List<Order> listOrder, String[] listNroOrder);

    CreditFooter createCreditNoteFooter(List<Product> listProduct, String taxCondition);

}
