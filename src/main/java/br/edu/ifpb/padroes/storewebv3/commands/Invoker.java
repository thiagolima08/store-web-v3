package br.edu.ifpb.padroes.storewebv3.commands;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class Invoker {

    private List<OrderCommand> commands = new LinkedList<>();

      public void add(OrderCommand c) {
          commands.add(c);
      }

      public OrderCommand remove() {
          return commands.remove(0);
      }

      public boolean isEmpty() {
         return commands.isEmpty();
     }

     public void createOrders() {
          while (!isEmpty()) {
              OrderCommand orderCommand = remove();
              orderCommand.execute();
          }
     }

}
