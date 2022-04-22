package io.red.hrworker.controller;

import io.red.hrworker.entities.Worker;
import io.red.hrworker.services.WorkerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "v1/workers")
public class WorkerController {

    private final WorkerService service;

    public WorkerController(WorkerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        return service.findAll();
    }

    @GetMapping("/{workerId}")
    public ResponseEntity findById(@PathVariable Long workerId){
        return service.findById(workerId);
    }


}
