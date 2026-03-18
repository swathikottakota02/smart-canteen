package com.example.Smart_canteen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.Smart_canteen.model.Order;
import com.example.Smart_canteen.model.OrderStatus;
import com.example.Smart_canteen.repository.OrderRepository;

@Controller
@RequestMapping("/admin/orders")
public class AdminOrderController {

    private final OrderRepository orderRepository;

    public AdminOrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // View all orders
    @GetMapping
    public String viewAllOrders(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        model.addAttribute("statuses", OrderStatus.values());
        return "admin-orders";
    }

    // Update order status
    @PostMapping("/update")
    public String updateOrderStatus(
            @RequestParam Long orderId,
            @RequestParam String status) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(OrderStatus.valueOf(status));
        orderRepository.save(order);

        return "redirect:/admin/orders";
    }
}

















//package com.example.Smart_canteen.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.Smart_canteen.model.Order;
//import com.example.Smart_canteen.repository.OrderRepository;
//import com.example.Smart_canteen.model.Order;
//import com.example.Smart_canteen.repository.OrderRepository;
//
//@Controller
//@RequestMapping("/admin/orders")
//
//public class AdminOrderController{
//	private final OrderRepository orderRepository;
//	
//	public AdminOrderController(OrderRepository orderRepository) {
//		this.orderRepository = orderRepository;
//	}
//	
//	// ✅ GET → View all orders
//    @GetMapping
//    public String viewAllOrders(Model model) {
//        model.addAttribute("orders", orderRepository.findAll());
//        return "admin-orders";
//    }
//
//    // ✅ POST → Update order status
//    @PostMapping("/update")
//    public String updateOrderStatus(
//            @RequestParam Long orderId,
//            @RequestParam String status) {
//
//        Order order = orderRepository.findById(orderId)
//                .orElseThrow(() -> new RuntimeException("Order not found"));
//
//        order.setStatus(status);
//        orderRepository.save(order);
//
//        return "redirect:/admin/orders";
//    }
//}
//
//
//
//
//
//
//
////package com.example.Smart_canteen.controller;
////
////import java.lang.annotation.Repeatable;
////
////import org.springframework.stereotype.Controller;
////import org.springframework.ui.Model;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RequestParam;
////
////import com.example.Smart_canteen.model.Order;
////import com.example.Smart_canteen.repository.OrderRepository;
////import com.example.Smart_canteen.service.OrderService;
////
////@Controller
////public class AdminOrderController {
////	
////	private final OrderService orderService;
////	// while adding order status
////	private final OrderRepository orderRepository;
////	
////	public AdminOrderController(OrderService orderService,OrderRepository orderRepository) {
////	    this.orderService = orderService;
////	    this.orderRepository = orderRepository;
////	}
////
////	
//////	public AdminOrderController(OrderService orderService) {
//////		this.orderService = orderService;
//////	}
//////	
//////	
//////	public AdminOrderController(OrderRepository orderRepository) {
//////		this.orderRepository = orderRepository;
//////	}
////	
////	
////	
////	@GetMapping("/admin/orders")
////	
////	public String viewAllOrders(Model model) {
////		model.addAttribute("orders", orderService.getAllOrders());
////		return "admin-orders";
////	}
////	
////	//view all orders
////	@GetMapping
////	public String viewOrders(Model model) {
////		model.addAttribute("orders",orderRepository.findAll());
////		return "admin-orders";
////	}
////	
////	// Update order status
////	@PostMapping("/update")
////	public String updateStatus(
////			@RequestParam Long orderId,
////			@RequestParam String status) {
////		
////		Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("order not found"));
////		order.setStatus(status);
////		orderRepository.save(order);
////		
////		return "redirect:/admin/orders";
////		
////	}
////	
////}
