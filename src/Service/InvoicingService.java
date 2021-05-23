package Service;

import Entitiy.*;
import Repository.IInvoicing;

import java.util.List;

public class InvoicingService {

    private IInvoicing iInvoicing;

    public InvoicingService(IInvoicing iInvoicing) {
        this.iInvoicing = iInvoicing;
    }

    public List<Invoice> generateInvoicing(List<Order> listOrder) {
        return iInvoicing.generateInvoicing(listOrder);
    }

    public List<Invoice> deleteInvoice(List<Invoice> listInvoice, String[] nroInvoice) {
        return iInvoicing.deleteInvoice(listInvoice, nroInvoice);
    }

    public List<InvoiceDetails> getInvoiceDetails(Order order) {
        return iInvoicing.getInvoiceDetails(order);
    }

    public InvoiceFooter calculateInvoiceFooter(List<InvoiceDetails> listInvoiceDetails) {
        return iInvoicing.calculateInvoiceFooter(listInvoiceDetails);
    }

}
