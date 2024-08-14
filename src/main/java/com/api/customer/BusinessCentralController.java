package com.api.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/business-central")
public class BusinessCentralController {
    private final BusinessCentralService businessCentralService;

    public BusinessCentralController(BusinessCentralService businessCentralService) {
        this.businessCentralService = businessCentralService;
    }

    @GetMapping("/fetch-data")
    public Mono<String> fetchData() {
        return businessCentralService.fetchDataFromBusinessCentral("/your-endpoint");
    }
}
