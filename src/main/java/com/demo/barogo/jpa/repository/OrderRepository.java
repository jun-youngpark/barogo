package com.demo.barogo.jpa.repository;

import com.demo.barogo.jpa.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long>   {


}


