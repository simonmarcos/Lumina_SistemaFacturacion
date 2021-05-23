package Controller;

import Entitiy.Client;
import Entitiy.CreditNote;
import Entitiy.Order;
import Entitiy.Product;
import Mocks.Mocks;
import Repository.ICreditNote;
import Repository.IOrder;
import Service.CreditiNoteServiceImpl;
import Service.OrderServiceImpl;

import java.util.*;
import java.util.stream.Collectors;

public class OrderController {

    private IOrder iOrder;
    private ICreditNote iCreditNote;
    private Mocks mocks;

    public OrderController() {
        this.iOrder = new OrderServiceImpl();
        this.iCreditNote = new CreditiNoteServiceImpl();
        mocks = new Mocks();
    }

    public List<Order> addOrder(List<Product> listProduct, List<Order> listOrder) {

        Client client = mocks.addClient();
        System.out.println("------------- Buenos días cliente " + client.getDni() + " -------------");

        System.out.println("------------- LISTA DE PEDIDOS ------------- ");
        listProduct.stream().forEach(p -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Código Producto ").append(p.getCode()).append(" -  Nombre ").append(p.getName()).append(" - Precio " + p.getPrice());
            System.out.println(stringBuilder);
        });

        Scanner sn = new Scanner(System.in);
        int option;

        System.out.println("Ingrese los códigos de los productos a agregar al pedido, separados por coma.");
        String listNroOrder = sn.next();

        List<Product> listProductsSelected = new ArrayList<>();
        String[] productsArray = listNroOrder.trim().split(",");

        //Add selected products to the new list
        Arrays.stream(productsArray).forEach(product -> {
            listProductsSelected.add(listProduct.stream().filter(p -> p.getCode() == Integer.parseInt(product)).collect(Collectors.toList()).get(0));
        });

        Order order = iOrder.generateOrder(listProductsSelected, client);
        listOrder.add(order);

        double totalPrice = iOrder.calculateTotalPrice(order);
        System.out.println("El total bruto a pagar es: " + totalPrice + ". \nEl número del pedido es: " + order.getNroOrder());

        return listOrder;
    }

    public List<Order> cancelOrder(List<Order> listOrder, List<CreditNote> listCreditNote, String listNroOrder) {

        //Delete Order of ListOrder
        listOrder = iOrder.deleteOrder(listOrder, listNroOrder.trim().split(","));
        //Delete Invoice of ListInvoice
        //listInvoice = iInvoicing.deleteInvoice(listInvoice, listNroOrder.trim().split(","));

        System.out.println("----------- SE ANULARON CORRECTAMENTE LOS PEDIDOS -----------");
        return listOrder;
    }

    public List<Order> listOrder(List<Order> listOrder) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("---------- Lista de pedidos ----------");
        listOrder.stream().forEach(o -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Nro Pedido ").append(o.getNroOrder()).append(" -  DNI Cliente ").append(o.getClient().getDni()).append(" - Estado: ").append(o.getState() == 0 ? "Pendiente" : "Facturado");
            System.out.println(stringBuilder);
        });

        return listOrder;
    }
}
