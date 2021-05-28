package br.edu.ifpb.padroes.storewebv3.rest;

import br.edu.ifpb.padroes.storewebv3.commands.CreateOrder;
import br.edu.ifpb.padroes.storewebv3.commands.Invoker;
import br.edu.ifpb.padroes.storewebv3.domain.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderResource {

    private Invoker invoker;

    public OrderResource(Invoker invoker) {
        this.invoker = invoker;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createOrder(@RequestBody Order order) {
        CreateOrder createOrder = new CreateOrder(order);
        invoker.add(createOrder);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/finalize")
    public ResponseEntity<Void> finalizeOrder() {
        invoker.createOrders();
        return ResponseEntity.ok().build();
    }

}
