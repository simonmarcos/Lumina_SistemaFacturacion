package Entitiy;

import java.util.List;
import java.util.Objects;

public class Order {

    private int nroOrder;
    private Client client;
    private List<Product> product;
    private int state;


    public Order(int nroOrder, Client client, List<Product> product, int state) {
        this.nroOrder = nroOrder;
        this.client = client;
        this.product = product;
        this.state = state; //State 0 is pending, state 1 is invoiced
    }

    public Order() {
    }

    public int getNroOrder() {
        return nroOrder;
    }

    public void setNroOrder(int nroOrder) {
        this.nroOrder = nroOrder;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "nroOrder=" + nroOrder +
                ", client=" + client +
                ", product=" + product +
                ", state=" + state +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return nroOrder == order.nroOrder;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nroOrder);
    }
}
