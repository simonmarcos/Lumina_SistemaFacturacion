package Repository;

import Entitiy.Invoice;
import Entitiy.InvoiceDetails;
import Entitiy.InvoiceFooter;
import Entitiy.Order;

import java.util.List;

public interface IInvoicing {

    List<Invoice> generateInvoicing(List<Order> listOrder);

    List<Invoice> deleteInvoice(List<Invoice> listInvoice, String[] nroInvoice);

    List<InvoiceDetails> getInvoiceDetails(Order order);

    InvoiceFooter calculateInvoiceFooter(List<InvoiceDetails> listInvoiceDetails);


}
