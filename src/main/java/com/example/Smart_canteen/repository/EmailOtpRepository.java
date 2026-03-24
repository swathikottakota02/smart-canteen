package com.example.Smart_canteen.repository;

import com.example.Smart_canteen.model.EmailOtp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmailOtpRepository extends JpaRepository<EmailOtp, Long> {

    Optional<EmailOtp> findByEmail(String email);
}


//package com.example.Smart_canteen.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import com.example.Smart_canteen.model.EmailOtp;
//
//public interface EmailOtpRepository extends JpaRepository<EmailOtp, Long> {
//
//    EmailOtp findByEmail(String email);
//
//}