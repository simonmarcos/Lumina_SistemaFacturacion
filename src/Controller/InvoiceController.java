package Controller;

import Entitiy.Invoice;
import Entitiy.Order;
import Repository.IInvoicing;
import Repository.IOrder;
import Service.InvoicingServiceImpl;
import Service.OrderServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class InvoiceController implements Runnable {

    private IInvoicing iInvoicing;
    private IOrder iOrder;

    private List<Order> listOrder;
    private List<Invoice> listInvoice;

    public InvoiceController() {
        iInvoicing = new InvoicingServiceImpl();
        iOrder = new OrderServiceImpl();
        listInvoice = new ArrayList<>();
    }

    public List<Invoice> addInvoices(List<Invoice> listInvoice, List<Order> listOrder) {
        System.out.println("------------- PROCESO DE FACTURACION -------------");

        //Generate Invoice
        listInvoice = iInvoicing.generateInvoicing(listOrder);
        if (listInvoice != null) {
            //Update status Order
            listOrder = iOrder.updateAllStatusOrder(listOrder);
            System.out.println("LAS FACTURAS GENERADAS SON: ");
            System.out.println(listInvoice);
        }
        return listInvoice;
    }

    public List<Invoice> listInvoices(List<Invoice> listInvoice) {
        System.out.println("------------- LISTA DE FACTURAS -------------");
        listInvoice.stream().forEach(i -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Factura número: ").append(i.getInvoiceHeader().getNroInvoice()).append(" - DNI Client: ").append(i.getInvoiceHeader().getClient().getDni());
            System.out.println(stringBuilder);
        });

        return listInvoice;
    }

    public StringBuilder generateReport(List<Invoice> listInvoice) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append(" --------------------- FACTURAS GENERADAS ---------------------").append("\n");
        listInvoice.stream().forEach(i -> {
            stringBuilder
                    .append("Cliente ").append(i.getInvoiceHeader().getClient().getNroClient()).append(" - Tipo de Documento ").append(i.getInvoiceHeader().getClient().getDocumentType())
                    .append(" - Letra ").append(i.getInvoiceHeader().getLetter()).append(" - Fecha Emisión ").append(i.getInvoiceHeader().getDate())
                    .append(" - Monto ").append(i.getInvoiceFooter().getTotal() + i.getInvoiceFooter().getTotalIVA()).append("\n");
        });

        return stringBuilder;
    }

    @Override
    public void run() {
        listInvoice = addInvoices(listInvoice, listOrder);
    }

    public List<Order> getListOrder() {
        return listOrder;
    }

    public void setListOrder(List<Order> listOrder) {
        this.listOrder = listOrder;
    }

    public List<Invoice> getListInvoice() {
        return listInvoice;
    }

    public void setListInvoice(List<Invoice> listInvoice) {
        this.listInvoice = listInvoice;
    }
}
