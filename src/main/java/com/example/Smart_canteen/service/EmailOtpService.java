package com.example.Smart_canteen.service;

import com.example.Smart_canteen.model.EmailOtp;
import com.example.Smart_canteen.repository.EmailOtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EmailOtpService {

    @Autowired
    private EmailOtpRepository repository;

    public void saveOrUpdateOtp(String email, String otp) {

        Optional<EmailOtp> existing = repository.findByEmail(email);

        if (existing.isPresent()) {
            EmailOtp otpObj = existing.get();
            otpObj.setOtp(otp);
            otpObj.setExpiryTime(LocalDateTime.now().plusMinutes(5));
            repository.save(otpObj);
        } else {
            EmailOtp newOtp = new EmailOtp();
            newOtp.setEmail(email);
            newOtp.setOtp(otp);
            newOtp.setExpiryTime(LocalDateTime.now().plusMinutes(5));
            repository.save(newOtp);
        }
    }
}