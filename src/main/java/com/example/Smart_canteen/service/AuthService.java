//package com.example.Smart_canteen.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.example.Smart_canteen.controller.OtpService;
//import com.example.Smart_canteen.model.User;
//import com.example.Smart_canteen.repository.UserRepository;
//
//@Controller
//public class AuthController {
//
//    @Autowired
//    private OtpService otpService;
//
//    @Autowired
//    private EmailService emailService;
//
//    @PostMapping("/send-otp")
//    public String sendOtp(@RequestParam String email) {
//
//        String otp = otpService.generateOtp();
//
//        emailService.sendOtp(email, otp);
//
//        return "verify-otp";
//    }
//
//@Service
//public class AuthService {
//	private final UserRepository repo;
//	private OtpService otpService;
//	public AuthService(UserRepository repo) {
//		this.repo=repo;
//	}
//	public User authenticate(String email,String password) {
//		User user = repo.findByEmail(email);
//		if(user != null && user.getPassword().equals(password)) {
//			return user;
//		}
//		return null;
//		
//	}
//	@PostMapping("/send-otp")
//	public String sendOtp(@RequestParam String email) {
//
//	    String otp = OtpService.generateOtp();
//
//	    System.out.println("Generated OTP: " + otp);
//
//	    // here you will save OTP in DB or send email
//
//	    return "verify-otp";
//	}
//	



package com.example.Smart_canteen.service;

import org.springframework.stereotype.Service;

import com.example.Smart_canteen.model.User;
import com.example.Smart_canteen.repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository repo;

    public AuthService(UserRepository repo) {
        this.repo = repo;
    }

    public User authenticate(String email, String password) {

        User user = repo.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }
}