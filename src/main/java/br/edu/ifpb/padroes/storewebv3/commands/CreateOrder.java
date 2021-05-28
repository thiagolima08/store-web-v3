package br.edu.ifpb.padroes.storewebv3.commands;

import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class CreateOrder implements OrderCommand{

    private Order order;

    private OrderService orderService = new OrderService();

    public CreateOrder(Order order){
        this.order = order;
    }

    @Override
    public void execute() {
        orderService.createOrder(this.order);
    }
}
