package com.example.Smart_canteen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Smart_canteen.model.User;
import com.example.Smart_canteen.service.AuthService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private AuthService authService;
	
	@GetMapping("/")
	public String landing() {
	    return "landing";
	}

	@GetMapping("/login")
	public String loginPage() {
	    return "index";
	}
	
//	@GetMapping("/")
//	public String home() {
//		return "index";
//	}
//	
	@GetMapping("/admin/login")
	public String adminLogin() {
		return "admin-login";
	}
	
	@GetMapping("/faculty/login")
	public String facultyLogin() {
		return "faculty-login";
	}
	
	@GetMapping("/student/login")
	public String studentLogin() {
		return "student-login";
	}
	
	@GetMapping("/admin/dashboard")
	public String adminDashboard() {
	    return "admin-dashboard";
	}
	
	 // Admin credentials for testing:
    // username: admin@canteen.com
    // password: admin123

	
	@PostMapping("/admin/login")
	public String adminLoginSubmit(
	        @RequestParam String username,
	        @RequestParam String password,
	        Model model) {

//	    System.out.println("USERNAME = [" + username + "]");
//	    System.out.println("PASSWORD = [" + password + "]");

	    if ("admin@canteen.com".equals(username)
	        && "admin123".equals(password)) {

	        model.addAttribute("adminName", "Admin");
	        return "admin-dashboard";

	    } else {
	        model.addAttribute("error", "Invalid admin credentials");
	        return "admin-login";
	    }
	}

//	@PostMapping("/admin/login")
//	public String adminLoginSubmit(
//	        @RequestParam String username,
//	        @RequestParam String password,
//	        Model model) {
//
//	    if ("admin@canteen.com".equals(username)
//	        && "admin123".equals(password)) {
//
//	        model.addAttribute("adminName", "Admin");
//	        return "admin-dashboard";
//
//	    } else {
//	        model.addAttribute("error", "Invalid admin credentials");
//	        return "admin-login";
//	    }
//	}

	
    // Faculty: accept any non-empty username/password for now
	@PostMapping("/faculty/login")
	public String facultyLoginSubmit(
	        @RequestParam String username,
	        @RequestParam String password,
	        HttpSession session,
	        Model model) {

	    if(username != null && !username.isBlank()) {

	    	session.setAttribute("email", username);
	    	session.setAttribute("role", "STUDENT");

	        return "faculty-dashboard";
	    } else {
	        model.addAttribute("error", "Invalid credentials");
	        return "faculty-login";
	    }
	}
	
	//Student:
    // Faculty: accept any non-empty username/password for now
	@PostMapping("/student/login")
	public String studentLoginSubmit(
	        @RequestParam String username,
	        @RequestParam String password,
	        HttpSession session,
	        Model model) {

	    if(username != null && !username.isBlank()) {

	    	session.setAttribute("email", username);
	    	session.setAttribute("role", "STUDENT");

	        return "student-dashboard";
	    } else {
	        model.addAttribute("error", "Invalid credentials");
	        return "student-login";
	    }
	}
	
}
