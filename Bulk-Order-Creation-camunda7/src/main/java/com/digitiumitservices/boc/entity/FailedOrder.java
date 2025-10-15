package com.digitiumitservices.boc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "failed_order")
public class FailedOrder {

    @Id
    private String orderId;
    private String customer;
    private String product;
    private int quantity;

   
    public FailedOrder() {
    }

    // Constructor with parameters
    public FailedOrder(String orderId, String customer, String product, int quantity) {
        this.orderId = orderId;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }

    // Getters and setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "FailedOrder [orderId=" + orderId + ", customer=" + customer + ", product=" + product + ", quantity=" + quantity + "]";
    }
}
