package com.demo.barogo.jpa.repository;

import com.demo.barogo.jpa.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long>   {
    List<Delivery> findByDeliveryAtBetweenAndOrdererId(LocalDateTime deliveryAtStart, LocalDateTime deliveryAtEnd, String ordererId);

}


