package Service;

import Entitiy.Client;
import Entitiy.Order;
import Entitiy.Product;
import Repository.IOrder;

import java.util.List;

public class OrderService {

    private IOrder iOrder;

    public OrderService(IOrder iOrder) {
        this.iOrder = iOrder;
    }

    public Order generateOrder(List<Product> listProducts, Client client) {
        return iOrder.generateOrder(listProducts, client);
    }

    public List<Order> deleteOrder(List<Order> listOrder, String[] nroOrder) {
        return iOrder.deleteOrder(listOrder, nroOrder);
    }

    public Order getByNroOrder(List<Order> listOrder, int nroOrder) {
        return iOrder.getByNroOrder(listOrder, nroOrder);
    }

    public List<Order> updateStatusOrder(List<Order> listOrder, int nrOrder) {
        return iOrder.updateStatusOrder(listOrder, nrOrder);
    }

    public List<Order> updateAllStatusOrder(List<Order> listOrder) {
        return iOrder.updateAllStatusOrder(listOrder);
    }

    public double calculateTotalPrice(Order order) {
        return iOrder.calculateTotalPrice(order);
    }

}
