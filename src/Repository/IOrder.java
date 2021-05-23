package Repository;

import Entitiy.Client;
import Entitiy.Order;
import Entitiy.Product;

import java.util.List;

public interface IOrder {

    Order generateOrder(List<Product> listProducts, Client client);

    List<Order> deleteOrder(List<Order> listOrder, String[] nroOrder);

    Order getByNroOrder(List<Order> listOrder, int nroOrder);

    List<Order> updateStatusOrder(List<Order> listOrder, int nrOrder);

    List<Order> updateAllStatusOrder(List<Order> listOrderr);

    double calculateTotalPrice(Order order);

}
