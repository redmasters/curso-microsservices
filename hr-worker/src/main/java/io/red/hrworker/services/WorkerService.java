package io.red.hrworker.services;

import io.red.hrworker.entities.Worker;
import io.red.hrworker.repositories.WorkerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

   private final WorkerRepository repository;

    public WorkerService(WorkerRepository repository) {
        this.repository = repository;
    }


    public ResponseEntity<List<Worker>> findAll() {
        List workers = repository.findAll();
        return ResponseEntity.ok(workers);
    }
}