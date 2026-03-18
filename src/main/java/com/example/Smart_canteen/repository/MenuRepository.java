package com.example.Smart_canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Smart_canteen.model.MenuItem;

public interface MenuRepository extends JpaRepository<MenuItem, Long> {
	 

}
