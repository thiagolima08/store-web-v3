package br.edu.ifpb.padroes.storewebv3.repository;

import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.domain.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderRepository {

    private List<Order> orderList = new ArrayList<>();

    public List<Order> getOrderList() {
        return orderList;
    }

    public boolean add(Order element) {
        return orderList.add(element);
    }

    public boolean remove(Order product) {
        return orderList.remove(product);
    }
}
