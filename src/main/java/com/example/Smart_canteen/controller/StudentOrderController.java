package com.example.Smart_canteen.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Smart_canteen.model.Order;
import com.example.Smart_canteen.repository.OrderRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentOrderController {
	 private final OrderRepository orderRepository;

	    public StudentOrderController(OrderRepository orderRepository) {
	        this.orderRepository = orderRepository;
	    }
	    
	    @GetMapping("/student/orders")
	    public String viewStudentOrders(Model model, HttpSession session) {

	        String studentEmail = (String) session.getAttribute("email");

	        List<Order> orders = orderRepository.findByUserEmail(studentEmail);

	        model.addAttribute("orders", orders);

	        return "student-orders";
	    }

}


