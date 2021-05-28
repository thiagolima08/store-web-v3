package br.edu.ifpb.padroes.storewebv3.repository;

import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.domain.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderRepository {

    private List<Order> orderList = new ArrayList<>();

    private static OrderRepository instance;

    public static OrderRepository getInstance() {
        if (instance == null) {
            instance = new OrderRepository();
        }

        return instance;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void add(Order element) {
        orderList.add(element);
    }

    public boolean remove(Order product) {
        return orderList.remove(product);
    }
}
