package br.edu.ifpb.padroes.storewebv3.rest;

import br.edu.ifpb.padroes.storewebv3.commands.CreateOrder;
import br.edu.ifpb.padroes.storewebv3.commands.Invoker;
import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderResource {

    private Invoker invoker;

    private OrderService orderService = new OrderService();

    public OrderResource(Invoker invoker) {
        this.invoker = invoker;
    }

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        CreateOrder createOrder = new CreateOrder(order);
        invoker.add(createOrder);

        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @PostMapping("/finalize")
    public ResponseEntity<Void> finalizeOrder() {
        invoker.createOrders();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<Order>> getOrder() {
        List<Order> orders = this.orderService.getOrderList();

        return ResponseEntity.ok(orders);
    }

}
