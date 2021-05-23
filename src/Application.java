import Controller.CreditNoteController;
import Controller.InvoiceController;
import Controller.OrderController;
import Entitiy.*;
import Mocks.Mocks;
import Repository.ICreditNote;
import Repository.IInvoicing;
import Repository.IOrder;
import Service.CreditiNoteServiceImpl;
import Service.InvoicingServiceImpl;
import Service.OrderServiceImpl;
import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Application {
    private static Mocks mocks;
    private static List<Order> listOrder;
    private static List<Product> listProduct;
    private static List<Invoice> listInvoice;
    private static List<CreditNote> listCreditNote;

    private static OrderController orderController;
    private static InvoiceController invoiceController;
    private static CreditNoteController creditNoteController;

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        boolean exit = false;
        int option;

        orderController = new OrderController();
        invoiceController = new InvoiceController();
        creditNoteController = new CreditNoteController();

        mocks = new Mocks();
        listOrder = new ArrayList<>();
        listProduct = new ArrayList<>();
        listInvoice = new ArrayList<>();
        listCreditNote = new ArrayList<>();

        listProduct = mocks.getListProduct();

        while (!exit) {
            System.out.println("1. Agregar Pedidos");
            System.out.println("2. Realizar Facturación");
            System.out.println("3. Anular Pedidos");
            System.out.println("4. Generar archivo de texto diario");
            System.out.println("5. Listar Pedidos");
            System.out.println("6. Listar Facturas");
            System.out.println("7. Listar Notas de Créditos");

            System.out.println("Escribe una de las opciones... ");
            option = sn.nextInt();

            try {
                switch (option) {
                    case 1:
                        listOrder = orderController.addOrder(listProduct, listOrder);
                        break;
                    case 2:
                        invoiceController.setListInvoice(listInvoice);
                        invoiceController.setListOrder(listOrder);
                        Thread thread = new Thread(invoiceController);
                        thread.start();
                        thread.join();
                        listInvoice = invoiceController.getListInvoice();
                        break;
                    case 3:
                        Scanner sn1 = new Scanner(System.in);
                        int option1;
                        String listNroOrder;
                        System.out.println("Ingrese la lista de números de pedidos a cancelar, separados por coma.");
                        listNroOrder = sn.next();

                        listCreditNote = creditNoteController.createCreditNote(listOrder, listCreditNote, listNroOrder);
                        listOrder = orderController.cancelOrder(listOrder, listCreditNote, listNroOrder);
                        break;
                    case 4:
                        System.out.println("-------------- GENERAMOS EL REPORTE --------------");
                        StringBuilder stringBuilder = new StringBuilder();

                        stringBuilder.append(invoiceController.generateReport(listInvoice));
                        stringBuilder.append(creditNoteController.generateReport(listCreditNote));

                        try {
                            String router = Paths.get("./dailyReport.txt").toString();
                            Files.write(Paths.get("./dailyReport.txt"), stringBuilder.toString().getBytes());
                            System.out.println("Se generó sastifactoriamente el reporte en la siguiente ruta: " + router);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        break;
                    case 5:
                        orderController.listOrder(listOrder);
                        break;
                    case 6:
                        invoiceController.listInvoices(listInvoice);
                        break;
                    case 7:
                        creditNoteController.listCreditNote(listCreditNote);
                        break;
                    case 8:
                        exit = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 7");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

