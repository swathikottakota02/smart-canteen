package com.example.Smart_canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Smart_canteen.model.EmailOtp;

public interface EmailOtpRepository extends JpaRepository<EmailOtp, Long> {

    EmailOtp findByEmail(String email);

}