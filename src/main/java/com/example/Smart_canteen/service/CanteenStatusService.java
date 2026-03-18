package com.example.Smart_canteen.service;

import org.springframework.stereotype.Service;
import com.example.Smart_canteen.repository.CanteenStatusRepository;

@Service
public class CanteenStatusService {

    private final CanteenStatusRepository repository;

    public CanteenStatusService(CanteenStatusRepository repository) {
        this.repository = repository;
    }

    public boolean isCanteenOpen() {
        return repository.findById(1).get().isOpen();
    }

    public void updateStatus(boolean open) {
        repository.findById(1).get().setOpen(open);
        repository.flush();
    }
}