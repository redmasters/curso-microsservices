package io.red.hrworker.controller;

import io.red.hrworker.entities.Worker;
import io.red.hrworker.services.WorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "v1/workers")
public class WorkerController {

    private static Logger LOGGER = LoggerFactory.getLogger(WorkerController.class);
    private final WorkerService service;
    private final Environment env;

    public WorkerController(WorkerService service, Environment env) {
        this.service = service;
        this.env = env;
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        return service.findAll();
    }

    @GetMapping("/{workerId}")
    public ResponseEntity findById(@PathVariable Long workerId){
        LOGGER.info("Worker na porta {}", env.getProperty("local.server.port"));
        return service.findById(workerId);
    }


}
