package Service;

import Entitiy.*;
import Repository.ICreditNote;
import utils.InitialValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CreditiNoteServiceImpl implements ICreditNote {

    @Override
    public List<CreditNote> generateCreditNote(List<Order> listOrder, String[] listNroOrder) {

        List<CreditNote> listCreditNote = new ArrayList<>();

        Arrays.stream(listNroOrder).forEach(nro -> {
            listOrder.stream().forEach(o -> {
                if (o.getNroOrder() == Integer.parseInt(nro)) {
                    CreditHeader creditHeader = this.createCreditHeader(o.getClient());
                    CreditFooter creditFooter = this.createCreditNoteFooter(o.getProduct(), o.getClient().getTaxCondition());
                    listCreditNote.add(new CreditNote(creditHeader, creditFooter));
                }
            });
        });
        return listCreditNote;
    }

    @Override
    public CreditFooter createCreditNoteFooter(List<Product> listProduct, String taxCondition) {
        double total = listProduct.stream().mapToDouble(p -> (p.getPrice() + ((p.getPrice() * getTaxConditionValue(taxCondition)) / 100))).sum();
        return new CreditFooter(total);
    }


    private CreditHeader createCreditHeader(Client client) {
        return new CreditHeader(new Date(), (int) (Math.random() * 10000), (int) (Math.random() * 1000), "Letra", client);
    }

    private double getTaxConditionValue(String taxCondition) {

        double valueTax = 0;

        switch (taxCondition) {
            case InitialValue.RESPONSABLEINSCRIPTO:
                valueTax = InitialValue.RESPONSABLEINSCRIPTO_IVA;
                break;

            case InitialValue.MONOTRIBUTO:
                valueTax = InitialValue.MONOTRIBUTO_IVA;
                break;
            case InitialValue.NORESPONSABLE:
                valueTax = InitialValue.NORESPONSABLE_IVA;
                break;
            default:
                break;
        }

        return valueTax;
    }
}
