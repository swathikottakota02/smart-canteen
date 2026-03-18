package com.example.Smart_canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Smart_canteen.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);

}
