package io.red.hrpayroll.services;

import io.red.hrpayroll.configuration.RestTemplateConfig;
import io.red.hrpayroll.entities.Payment;
import io.red.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;
    private final RestTemplateConfig restTemplateConfig;

    public PaymentService(RestTemplateConfig restTemplateConfig) {
        this.restTemplateConfig = restTemplateConfig;
    }

    public Payment getPayment(long workerId, int days) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", "" + workerId);
        Worker worker = restTemplateConfig.restTemplate().getForObject(workerHost + "/v1/workers/{id}", Worker.class, uriVariables);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
