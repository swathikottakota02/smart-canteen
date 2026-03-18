package com.example.Smart_canteen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Smart_canteen.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findByUserEmail(String userEmail);
	
	List<Order> findAllByOrderByOrderTimeDesc();
}

