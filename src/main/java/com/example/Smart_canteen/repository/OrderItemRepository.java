package com.example.Smart_canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Smart_canteen.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
