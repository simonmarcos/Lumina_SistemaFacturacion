package Mocks;

import Entitiy.Client;
import Entitiy.Order;
import Entitiy.Product;
import utils.InitialValue;

import java.util.ArrayList;
import java.util.List;

public class Mocks {

    List<Order> listOrder = null;
    List<Product> listProduct = null;

    public Mocks() {
        this.listOrder = new ArrayList<>();
        this.listProduct = new ArrayList<>();
    }

    public List<Order> getLisOrder() {

        int count = 0;
        while (count != 5) {

            Client client = new Client((int) Math.random(), "Calle " + (count + 1), "Monotributista", "DNI", (int) (Math.random() * 10000000));

            List<Product> listProduct = new ArrayList<>();
            listProduct.add(new Product(count + 1, "Producto 1", 100));
            listProduct.add(new Product(count + 2, "Producto 2", 200));
            listProduct.add(new Product(count + 3, "Producto 3", 300));
            listProduct.add(new Product(count + 4, "Producto 4", 400));
            listProduct.add(new Product(count + 5, "Producto 5", 500));

            Order order = new Order(count + 1, client, listProduct, 0);

            listOrder.add(order);
            count++;
        }

        return listOrder;
    }

    public List<Product> getListProduct() {
        int count = 0;
        List<Product> listProduct = new ArrayList<>();
        while (count != 5) {
            listProduct.add(new Product(count + 1, "Producto " + (count + 1), (int) (Math.random() * 10000)));
            count++;
        }

        return listProduct;
    }

    public Client addClient() {
        int nroClient = (int) (Math.random() * 1000);
        return new Client(nroClient, "Calle 1", InitialValue.RESPONSABLEINSCRIPTO, "DNI", 37456001);

    }

}
