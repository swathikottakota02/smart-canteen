//package com.example.Smart_canteen.controller;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import com.example.Smart_canteen.service.MenuService;
//
//import jakarta.servlet.http.HttpSession;
//
//@Controller
//public class StudentMenuController {
//	private final MenuService menuService;
//	
//	public StudentMenuController(MenuService menuService) {
//		this.menuService=menuService;
//	}
//	
//	// Step-1 show menu to student/faculty
//	@GetMapping("/menu")
//	public String showMenu(Model model) {
//		model.addAttribute("menuItems", menuService.getAllMenuItems());
//		return "student-menu";
//	}
//	
//	//step-2 add item to cart
////	@GetMapping("/cart/add/{id}")
////	public String addToCart(@PathVariable Long id,HttpSession session) {
//		
////		//get cart from session
////		Map<Long, Integer> cart = 
////				(Map<Long, Integer>) session.getAttribute("cart");
//		
//		//if cart is empty ,create new cart
//		if (cart == null) {
//			cart = new HashMap<>();
//		}
//		
//		//Increase the quantity
//		cart.put(id, cart.getOrDefault(id, 0)+1);
//		
//		// save cart back to the session
//		session.setAttribute("cart", cart);
//		
//		return "redirect:/menu";
//	}
//}


package com.example.Smart_canteen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Smart_canteen.model.CanteenStatus;
import com.example.Smart_canteen.repository.CanteenStatusRepository;
import com.example.Smart_canteen.service.MenuService;

@Controller
public class StudentMenuController {

    private final MenuService menuService;
    
    private final CanteenStatusRepository canteenStatusRepo;

    
    public StudentMenuController(
            MenuService menuService,
            CanteenStatusRepository canteenStatusRepo) {
        this.menuService = menuService;
        this.canteenStatusRepo = canteenStatusRepo;
    }
    
    @GetMapping("/student/dashboard")
    public String studentDashboard() {
        return "student-dashboard";
        }

    // STEP-1: Show menu to student/faculty
//    @GetMapping("/menu")
//    public String showMenu(Model model) {
//        model.addAttribute("menuItems", menuService.getAllMenuItems());
//        return "student-menu";
//    }
    
    @GetMapping("/menu")
    public String showMenu(Model model) {

        CanteenStatus status = canteenStatusRepo.findById(1)
                .orElse(new CanteenStatus());

        if (!status.isOpen()) {
        	model.addAttribute("message", "Canteen is currently closed");
            return "canteen-closed";
        }

        model.addAttribute("menuItems", menuService.getAllMenuItems());
        return "student-menu";
    }
}