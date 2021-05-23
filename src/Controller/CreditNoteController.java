package Controller;

import Entitiy.CreditNote;
import Entitiy.Invoice;
import Entitiy.Order;
import Repository.ICreditNote;
import Repository.IOrder;
import Service.CreditiNoteServiceImpl;
import Service.OrderServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class CreditNoteController {

    private ICreditNote iCreditNote;
    private IOrder iOrder;

    public CreditNoteController() {
        this.iCreditNote = new CreditiNoteServiceImpl();
        this.iOrder = new OrderServiceImpl();
    }

    public List<CreditNote> createCreditNote(List<Order> listOrder, List<CreditNote> listCreditNote, String listNroOrder) {
        //Generate Credit Note
        //Delete Order with status Pending
        List<Order> listOrderWithStateInvoice = new ArrayList<>(listOrder);
        listOrderWithStateInvoice.removeIf(o -> o.getState() == 0);
        listCreditNote = iCreditNote.generateCreditNote(listOrderWithStateInvoice, listNroOrder.trim().split(","));
        if (listOrderWithStateInvoice.size() > 0) {
            System.out.println("----------- SE CREARON NOTAS DE CREDITOS -----------");
        }

        return listCreditNote;
    }

    public List<CreditNote> listCreditNote(List<CreditNote> listCreditNote) {
        System.out.println("------------- LISTA DE NOTAS DE CRÉDITOS -------------");
        listCreditNote.stream().forEach(cN -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Número Nota Crédito: ").append(cN.getCreditHeader().getNroCreditNote()).append(" - DNI Client: ").append(cN.getCreditHeader().getClient().getDni());
            System.out.println(stringBuilder);
        });

        return listCreditNote;
    }

    public StringBuilder generateReport(List<CreditNote> listCreditNote) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append(" --------------------- NOTAS DE CREDITOS GENERADAS ---------------------").append("\n");
        listCreditNote.stream().forEach(nC -> {
            stringBuilder
                    .append("Cliente ").append(nC.getCreditHeader().getClient().getNroClient()).append(" - Tipo de Documento ").append(nC.getCreditHeader().getClient().getDocumentType())
                    .append(" - Letra ").append(nC.getCreditHeader().getLetter()).append(" - Fecha Emisión ").append(nC.getCreditHeader().getDate())
                    .append(" - Monto ").append(nC.getCreditFooter().getTotal()).append("\n");
        });

        return stringBuilder;
    }
}
