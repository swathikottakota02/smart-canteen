//package com.example.Smart_canteen.controller;
//
//import java.awt.MenuItem;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//
//
//@Controller
//@SessionAttributes("cart")
//public class CartController {
//	
//	//view cart page
//	@GetMapping("/cart/view")
//	public String viewCart(Model model) {
//		Map<MenuItem, Integer> cart=
//				(Map<MenuItem, Integer>) model.getAttribute("cart");
//		
//		if(cart==null) {
//			cart = new HashMap<>();
//			model.addAttribute("cart", cart);
//		}
//		
//		model.addAttribute("cartItems", cart);
//		return "cart";
//	}
//
//}






package com.example.Smart_canteen.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.Smart_canteen.model.MenuItem;
import com.example.Smart_canteen.service.MenuService;

@Controller
@SessionAttributes("cart")
public class CartController {

    private final MenuService menuService;

    public CartController(MenuService menuService) {
        this.menuService = menuService;
    }

    // ---------------- ADD TO CART ----------------
    @GetMapping("/cart/add/{id}")
    public String addToCart(@PathVariable Long id, Model model) {

        // Get cart from session
        Map<MenuItem, Integer> cart =
                (Map<MenuItem, Integer>) model.getAttribute("cart");

        // If cart does not exist, create new
        if (cart == null) {
            cart = new HashMap<>();
        }

        // Get menu item from DB
        MenuItem item = menuService.getMenuItemById(id);

        // Add item or increase quantity
        cart.put(item, cart.getOrDefault(item, 0) + 1);

        // Save cart back to session
        model.addAttribute("cart", cart);

        // Redirect back to menu page
        return "redirect:/menu";
    }

    // ---------------- VIEW CART ----------------
    @GetMapping("/cart/view")
    public String viewCart(Model model) {

        Map<MenuItem, Integer> cart =
                (Map<MenuItem, Integer>) model.getAttribute("cart");

        double total = 0;

        if (cart != null) {
            for (Map.Entry<MenuItem, Integer> entry : cart.entrySet()) {
                total += entry.getKey().getPrice() * entry.getValue();
            }
        }

        model.addAttribute("cartItems", cart);
        model.addAttribute("totalAmount", total);

        return "cart";
    }
    
    // ---------------- remove CART ----------------

    @GetMapping("/cart/remove/{id}")
    public String removeFromCart(@PathVariable Long id, Model model) {

        Map<MenuItem, Integer> cart =
                (Map<MenuItem, Integer>) model.getAttribute("cart");

        if (cart != null) {
            cart.entrySet().removeIf(entry ->
                    entry.getKey().getId().equals(id));
        }

        model.addAttribute("cart", cart);

        return "redirect:/cart/view";
    }
}
