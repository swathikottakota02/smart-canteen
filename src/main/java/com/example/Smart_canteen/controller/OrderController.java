package com.example.Smart_canteen.controller;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.Smart_canteen.model.CanteenStatus;
import com.example.Smart_canteen.model.MenuItem;
import com.example.Smart_canteen.model.Order;
import com.example.Smart_canteen.model.OrderItem;
import com.example.Smart_canteen.model.OrderStatus;
import com.example.Smart_canteen.repository.CanteenStatusRepository;
import com.example.Smart_canteen.repository.OrderRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("cart")
public class OrderController {
	private final OrderRepository orderRepository;
	private final CanteenStatusRepository canteenStatusRepo;
	
	public OrderController(OrderRepository orderRepository,
			CanteenStatusRepository canteenStatusRepo) {
		this.orderRepository=orderRepository;
		this.canteenStatusRepo = canteenStatusRepo;

		
		
	}
	@GetMapping("/order-success")
	public String orderSuccess(HttpSession session, Model model){

		String name = (String) session.getAttribute("name");

		if(name == null || name.isEmpty()){
		    name = "Hungry Hero";
		}

		model.addAttribute("name", name);

	    return "order-success";
	}  
	
//	
//	
//	@PostMapping("/order/place")
//	public String placeOrder(
//	        HttpSession session)
//	         {
//		// 🔍 Check if canteen is open
//	    CanteenStatus status = canteenStatusRepo.findById(1).orElse(null);
//
//	    if (status == null || !status.isOpen()) {
//	        return "redirect:/canteen-closed";
//	    }
//		
//		
//		
//		
//	    String email = (String) session.getAttribute("email");
//	    String role = (String) session.getAttribute("role");
//
//	    Order order = new Order();
//	    order.setUserEmail(email);
//	    order.setRole(role);
//	       
//	    order.setStatus(OrderStatus.PLACED);
//	    order.setOrderTime(LocalDateTime.now()); 
//
//	    orderRepository.save(order);
//
//	    return "redirect:/order/success";
//	}
	@PostMapping("/order/place")
	public String placeOrder(HttpSession session) {

	    System.out.println("SESSION EMAIL = " + session.getAttribute("email"));
	    System.out.println("SESSION ROLE = " + session.getAttribute("role"));

	    String email = (String) session.getAttribute("email");
	    String role = (String) session.getAttribute("role");

	    if (email == null) {
	        return "redirect:/login";
	    }

	    CanteenStatus status = canteenStatusRepo.findById(1).orElse(null);

	    if (status == null || !status.isOpen()) {
	        return "redirect:/canteen-closed";
	    }

	    Order order = new Order();
	    order.setUserEmail(email);
	    order.setRole(role);
	    order.setOrderTime(LocalDateTime.now());
	    order.setStatus(OrderStatus.PLACED);

	    orderRepository.save(order);

	    return "redirect:/order-success";
	}
	
	
}