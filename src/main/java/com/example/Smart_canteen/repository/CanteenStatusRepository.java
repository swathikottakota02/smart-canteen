package com.example.Smart_canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Smart_canteen.model.CanteenStatus;

public interface CanteenStatusRepository extends JpaRepository<CanteenStatus, Integer> {
}