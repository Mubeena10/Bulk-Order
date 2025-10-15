package com.digitiumitservices.boc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitiumitservices.boc.entity.Order;


public interface OrderRepository extends JpaRepository<Order, String> {

	Order save(Order order);}