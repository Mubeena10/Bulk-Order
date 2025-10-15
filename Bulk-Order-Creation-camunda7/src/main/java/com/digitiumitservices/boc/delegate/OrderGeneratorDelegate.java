package com.digitiumitservices.boc.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("orderGenerator")
public class OrderGeneratorDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        List<Map<String, Object>> orders = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Map<String, Object> order = new HashMap<>();
            order.put("orderId", "ORD" + i);
            order.put("customer", "Customer" + i);
            order.put("product", "Product" + (i % 5));
            order.put("quantity", new Random().nextInt(6) - 1); 
            orders.add(order);
        }
        execution.setVariable("orders", orders);
    }
}
