package br.edu.ifpb.padroes.storewebv3.rest;

import br.edu.ifpb.padroes.storewebv3.commands.CreateOrder;
import br.edu.ifpb.padroes.storewebv3.commands.Invoker;
import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.facade.OrderFacade;
import br.edu.ifpb.padroes.storewebv3.mediator.ConcreteMediator;
import br.edu.ifpb.padroes.storewebv3.mediator.Mediator;
import br.edu.ifpb.padroes.storewebv3.payment.StripeApi;
import br.edu.ifpb.padroes.storewebv3.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderResource {

    private final Invoker invoker;

    private final OrderFacade orderFacade;

    private final ApplicationContext context;

    Mediator mediator = new ConcreteMediator();

    public OrderResource(Invoker invoker, OrderFacade orderFacade, ApplicationContext context) {
        this.invoker = invoker;
        this.orderFacade = orderFacade;
        this.context = context;
    }

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        CreateOrder createOrder = this.context.getBean(CreateOrder.class);
        createOrder.serOrder(order);
        invoker.add(createOrder);
        mediator.registerComponent(new StripeApi());

        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @PostMapping("/finalize")
    public ResponseEntity<Void> finalizeOrder() {
        invoker.createOrders();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<Order>> getOrder() {
        List<Order> orders = this.orderFacade.getOrders();

        return ResponseEntity.ok(orders);
    }

}
