package com.digitiumitservices.boc.delegate;

import java.util.List;
import java.util.Map;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.digitiumitservices.boc.entity.Order;
import com.digitiumitservices.boc.repo.OrderRepository;

@Component("StoreSuccessfulOrders")
public class StoreSuccessOrdersDelegate implements JavaDelegate {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void execute(DelegateExecution execution) {
		List<Map<String, Object>> successOrders = (List<Map<String, Object>>) execution.getVariable("successOrders");

		if (successOrders != null) {
			for (Map<String, Object> order : successOrders) {
				Order entity = new Order();
				entity.setOrderId((String) order.get("orderId"));
				entity.setCustomer((String) order.get("customer"));
				entity.setProduct((String) order.get("product"));
				entity.setQuantity((int) order.get("quantity"));
				orderRepository.save(entity);
			}
		}

		// Check for failures AFTER storing success
		List<Map<String, Object>> failedOrders = (List<Map<String, Object>>) execution.getVariable("failedOrders");
		if (failedOrders != null && !failedOrders.isEmpty()) {
			throw new BpmnError("OrderValidationError", "Some orders failed validation");
		}
	}
}
