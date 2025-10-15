package com.digitiumitservices.boc.entity;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders_list")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private String customer;
    private String product;
    private int quantity;

    @Id
    private String orderId;

    // ✅ Default constructor required by JPA
    public Order() {
    }

    // Parameterized constructor
    public Order(String customer, String product, int quantity, String orderId) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.orderId = orderId;
    }

    // Getters and Setters

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order [customer=" + customer + ", product=" + product + ", quantity=" + quantity + ", orderId=" + orderId + "]";
    }
}
