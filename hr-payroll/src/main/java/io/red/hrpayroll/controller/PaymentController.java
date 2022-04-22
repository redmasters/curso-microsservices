package io.red.hrpayroll.controller;

import io.red.hrpayroll.entities.Payment;
import io.red.hrpayroll.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/payments")
public class PaymentController {

    PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
        return service.getPayment(workerId,days);

    }
}
