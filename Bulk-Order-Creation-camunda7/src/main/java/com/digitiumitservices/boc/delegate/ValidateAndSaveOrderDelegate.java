package com.digitiumitservices.boc.delegate;

//1. Java Delegate: Validate and Save Each Order


import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("ValidateAndSaveOrder")
public class ValidateAndSaveOrderDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        Map<String, Object> order = (Map<String, Object>) execution.getVariable("order");

        List<Map<String, Object>> successOrders = (List<Map<String, Object>>) execution.getVariable("successOrders");
        List<Map<String, Object>> failedOrders = (List<Map<String, Object>>) execution.getVariable("failedOrders");

        if (successOrders == null) successOrders = new ArrayList<>();
        if (failedOrders == null) failedOrders = new ArrayList<>();

        int quantity = (int) order.get("quantity");

        System.out.println("Validating Order ID: " + order.get("orderId") + ", Quantity: " + quantity);
        if (quantity > 0) {
            System.out.println("✅ Success");
            successOrders.add(order);
        } else {
            System.out.println("❌ Failed");
            failedOrders.add(order);
        }

        execution.setVariable("successOrders", successOrders);
        execution.setVariable("failedOrders", failedOrders);

            }
}
