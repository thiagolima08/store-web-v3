package br.edu.ifpb.padroes.storewebv3.service;

import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void createOrder(Order order){
        order.setProcessed(true);
        orderRepository.add(order);
        System.out.println(order.getId().toString());
    }

}
