package Service;

import Entitiy.Client;
import Entitiy.Order;
import Entitiy.Product;
import Repository.IOrder;
import utils.InitialValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImpl implements IOrder {

    @Override
    public Order generateOrder(List<Product> listProducts, Client client) {
        return new Order((int) (Math.random() * 1000), client, listProducts, 0);
    }

    @Override
    public List<Order> deleteOrder(List<Order> listOrder, String[] nroOrder) {
        List<String> listOrdersNotFound = new ArrayList<>();
        Arrays.stream(nroOrder).forEach(nroO -> {
            boolean delete = listOrder.removeIf(o -> o.getNroOrder() == Integer.parseInt(nroO));
            if (!delete) {
                listOrdersNotFound.add(nroO);
            }
        });
        if (listOrdersNotFound.size() > 0) {
            System.out.println("Los siguientes pedidos no se encontraron: " + listOrdersNotFound);
        }
        return listOrder;
    }

    @Override
    public Order getByNroOrder(List<Order> listOrder, int nroOrder) {
        return listOrder.stream().filter(o -> o.getNroOrder() == nroOrder).collect(Collectors.toList()).get(0);
    }

    @Override
    public List<Order> updateStatusOrder(List<Order> listOrder, int nrOrder) {
        listOrder.stream().forEach(o -> {
            if (o.getNroOrder() == nrOrder) {
                o.setState(1);
            }
        });

        return listOrder;
    }

    @Override
    public List<Order> updateAllStatusOrder(List<Order> listOrder) {
        listOrder.stream().forEach(o -> o.setState(1));
        return listOrder;
    }

    @Override
    public double calculateTotalPrice(Order order) {

        double totalPrice = 0;

        switch (order.getClient().getTaxCondition()) {
            case InitialValue.RESPONSABLEINSCRIPTO:
                totalPrice = order.getProduct().stream().mapToDouble(p -> (p.getPrice() + (p.getPrice() * InitialValue.RESPONSABLEINSCRIPTO_IVA) / 100)).sum();
                break;
            case InitialValue.MONOTRIBUTO:
                totalPrice = order.getProduct().stream().mapToDouble(p -> (p.getPrice() + (p.getPrice() * InitialValue.MONOTRIBUTO_IVA) / 100)).sum();
                break;
            case InitialValue.NORESPONSABLE:
                totalPrice = order.getProduct().stream().mapToDouble(p -> (p.getPrice() + (p.getPrice() * InitialValue.NORESPONSABLE_IVA) / 100)).sum();
                break;
            default:
                break;
        }

        return totalPrice;
    }

}
