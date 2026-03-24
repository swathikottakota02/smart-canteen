package com.example.Smart_canteen.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OtpService {

    public String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }
}


//package com.example.Smart_canteen.service;
//
//import java.util.Random;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class OtpService {
//	public String generateOtp() {
//		Random random = new Random();
//		int otp = 100000 + random.nextInt(900000);
//		return String.valueOf(otp) ;
//	}
//
//}
