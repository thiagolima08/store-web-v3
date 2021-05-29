package br.edu.ifpb.padroes.storewebv3.service;

import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.domain.OrderItem;
import br.edu.ifpb.padroes.storewebv3.domain.Product;
import br.edu.ifpb.padroes.storewebv3.repository.OrderRepository;
import br.edu.ifpb.padroes.storewebv3.visitor.DiscountVisitor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository = OrderRepository.getInstance();

    public void createOrder(Order order){
        order.setProcessed(true);
        orderRepository.add(order);

        for (OrderItem item: order.getItems()) {
            Product product = item.getProduct();
            product.accept(new DiscountVisitor());
        }

        System.out.println(order.getId().toString());
    }

    public List<Order> getOrderList() {
        return orderRepository.getOrderList();
    }

}
