package Service;

import Entitiy.*;
import Repository.IInvoicing;
import utils.InitialValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class InvoicingServiceImpl implements IInvoicing {

    @Override
    public List<Invoice> generateInvoicing(List<Order> listOrder) {

        List<Invoice> listInvoice = new ArrayList<>();

        listOrder.stream().forEach(order -> {
            if (order.getState() == 0) {
                InvoiceHeader invoiceHeader = new InvoiceHeader(new Date(), (int) (Math.random() * 1000), (int) (Math.random() * 100), "Letra " + order.getNroOrder(), order.getClient());
                List<InvoiceDetails> listInvoiceDetails = getInvoiceDetails(order);
                InvoiceFooter invoiceFooter = calculateInvoiceFooter(listInvoiceDetails);

                Invoice invoice = new Invoice(invoiceHeader, listInvoiceDetails, invoiceFooter);


                //Check that no duplication is generated
                while (true) {
                    if (!listInvoice.contains(invoice)) {
                        listInvoice.add(invoice);
                        break;
                    }
                    invoice.setInvoiceHeader(new InvoiceHeader(new Date(), (int) (Math.random() * 1000), (int) (Math.random() * 100), "Letra " + order.getNroOrder(), order.getClient()));
                }
            }
        });
        return listInvoice;
    }

    @Override
    public List<Invoice> deleteInvoice(List<Invoice> listInvoice, String[] listNroInvoices) {

        List<String> listInvoicesNotFound = new ArrayList<>();
        Arrays.stream(listNroInvoices).forEach(nroO -> {
            boolean delete = listInvoice.removeIf(o -> o.getInvoiceHeader().getNroInvoice() == Integer.parseInt(nroO));
            if (!delete) {
                listInvoicesNotFound.add(nroO);
            }
        });
        if (listInvoicesNotFound.size() > 0) {
            System.out.println("Las siguientes facturas no se encontraron: " + listInvoicesNotFound);
        }
        return listInvoice;
    }

    @Override
    public List<InvoiceDetails> getInvoiceDetails(Order order) {

        List<InvoiceDetails> listInvoiceDetails = new ArrayList<>();

        int codeProduct = 0;
        double valueTax = 0;
        double salePrice = 0;
        double amountIVA = 0;
        int countProduct = 1;
        InvoiceDetails invoiceDetails = new InvoiceDetails();

        for (Product p : order.getProduct()) {

            if (codeProduct != p.getCode()) {
                if (order.getProduct().indexOf(p) != 0) {
                    listInvoiceDetails.add(invoiceDetails);
                    invoiceDetails = new InvoiceDetails();
                }
                codeProduct = p.getCode();
                valueTax = 0;
                salePrice = 0;
                amountIVA = 0;
                countProduct = 0;
                valueTax = getTaxConditionValue(order.getClient().getTaxCondition());
            }

            salePrice += (p.getPrice() + ((p.getPrice() * valueTax) / 100));
            amountIVA += (p.getPrice() * valueTax) / 100;
            countProduct++;

            invoiceDetails.setProduct(p.getName());
            invoiceDetails.setUnitPrice(p.getPrice());
            invoiceDetails.setIVA(valueTax);
            invoiceDetails.setCount(countProduct);
            invoiceDetails.setSalePrice(salePrice);
            invoiceDetails.setNetoPrice(p.getPrice() * countProduct);
            invoiceDetails.setAmountIVA(amountIVA);

            if (order.getProduct().indexOf(p) == order.getProduct().size() - 1) {
                listInvoiceDetails.add(invoiceDetails);
            }

        }

        return listInvoiceDetails;
    }

    @Override
    public InvoiceFooter calculateInvoiceFooter(List<InvoiceDetails> listInvoiceDetails) {

        double total = listInvoiceDetails.stream().mapToDouble(iD -> iD.getNetoPrice()).sum();
        double totalIVA = listInvoiceDetails.stream().mapToDouble(iD -> iD.getAmountIVA()).sum();

        return new InvoiceFooter(total, totalIVA);
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
