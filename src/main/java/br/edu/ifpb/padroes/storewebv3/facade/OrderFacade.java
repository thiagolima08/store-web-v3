package br.edu.ifpb.padroes.storewebv3.facade;

import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.domain.Product;
import br.edu.ifpb.padroes.storewebv3.repository.ProductRepository;
import br.edu.ifpb.padroes.storewebv3.service.OrderService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderFacade {

    private final OrderService orderService;

    public OrderFacade(OrderService orderService, ProductRepository productRepository) {
        this.orderService  = orderService;
    }

    public void createOrder(Order order) {
        this.orderService.createOrder(order);
    }

    public List<Order> getOrders() {
        return orderService.getOrderList();
    }

}
