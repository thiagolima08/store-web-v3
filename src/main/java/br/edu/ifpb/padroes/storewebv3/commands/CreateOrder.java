package br.edu.ifpb.padroes.storewebv3.commands;

import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.facade.OrderFacade;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CreateOrder implements OrderCommand{

    private Order order;

    private final OrderFacade orderFacade;

    public CreateOrder(OrderFacade orderFacade){
        this.orderFacade = orderFacade;
    }

    @Override
    public void execute() {
        this.orderFacade.createOrder(this.order);
    }

    public void serOrder(Order order) {
        this.order = order;
    }


}
