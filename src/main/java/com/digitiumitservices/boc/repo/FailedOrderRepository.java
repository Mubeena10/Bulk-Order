package com.digitiumitservices.boc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.digitiumitservices.boc.entity.FailedOrder;

public interface FailedOrderRepository extends JpaRepository<FailedOrder, String> {
    // No need to declare save() method here; Spring Data JPA provides it automatically.
}
