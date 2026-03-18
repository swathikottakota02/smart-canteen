package com.example.Smart_canteen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Smart_canteen.model.Order;
import com.example.Smart_canteen.repository.OrderRepository;

@Service
public class OrderService {
	
	private final OrderRepository orderRepository; 
	
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
		
	}
	
	public List<Order> getAllOrders(){
		return orderRepository.findAllByOrderByOrderTimeDesc();
	}
}
