package br.edu.ifpb.padroes.storewebv3.service;

import br.edu.ifpb.padroes.storewebv3.domain.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public void createOrder(Order order){
        System.out.println(order.getId().toString());
    }

}
