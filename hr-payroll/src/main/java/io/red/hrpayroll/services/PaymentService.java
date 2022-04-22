package io.red.hrpayroll.services;

import io.red.hrpayroll.controller.PaymentController;
import io.red.hrpayroll.entities.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public ResponseEntity<Payment> getPayment(long workerId, int days) {
        final var payment = new Payment("Felipe", 200.0, days);
        return ResponseEntity.ok(payment);
    }
}
