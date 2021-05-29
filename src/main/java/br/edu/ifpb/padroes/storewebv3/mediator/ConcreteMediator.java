package br.edu.ifpb.padroes.storewebv3.mediator;

import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.payment.StripeApi;

public class ConcreteMediator implements Mediator {

    private StripeApi stripeApi;

    @Override
    public void registerComponent(Component component) {
        component.setMediator(this);

        switch (component.getName()){
            case "Stripe API":
                stripeApi = (StripeApi)component;
        }
    }

    @Override
    public void CreateOrder(Order order) {
        stripeApi.createOrder(order);
    }


}
