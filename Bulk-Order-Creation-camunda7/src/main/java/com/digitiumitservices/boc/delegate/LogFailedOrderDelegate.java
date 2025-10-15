package com.digitiumitservices.boc.delegate;

import java.util.List;
import java.util.Map;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.digitiumitservices.boc.entity.FailedOrder;
import com.digitiumitservices.boc.repo.FailedOrderRepository;

@Component("logFailedOrder")
public class LogFailedOrderDelegate implements JavaDelegate {

    @Autowired
    private FailedOrderRepository failedOrderRepo;

    @Override
    public void execute(DelegateExecution execution) {

        List<Map<String, Object>> failedOrders = (List<Map<String, Object>>) execution.getVariable("failedOrders");

        if (failedOrders != null) {
            for (Map<String, Object> order : failedOrders) {
                try {
                    FailedOrder entity = new FailedOrder(
                        (String) order.get("orderId"),
                        (String) order.get("customer"),
                        (String) order.get("product"),
                        (int) order.get("quantity")
                    );

                    failedOrderRepo.save(entity);
                    System.out.println("Saved failed order: " + entity);
                } catch (Exception e) {
                    System.err.println("Error saving failed order: " + e.getMessage());
                }
            }
        } else {
            System.err.println("No failedOrders variable found in execution context.");
        }
    }
}
