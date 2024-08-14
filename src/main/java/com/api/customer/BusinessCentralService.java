package com.api.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class BusinessCentralService {

    private final WebClient webClient;

    public BusinessCentralService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://api.businesscentral.dynamics.com/v2.0/YOUR_TENANT_ID/Sandbox/ODataV4")
                .defaultHeader("Authorization", "Bearer YOUR_ACCESS_TOKEN")
                .defaultHeader("Content-Type", "application/json")
                .defaultHeader("Accept", "application/json")
                .build();
    }

    /**
     * Fetches data from a given endpoint in the Business Central API.
     * @param endpoint the API endpoint to fetch data from.
     * @return Mono<String> containing the response data.
     */
    public Mono<String> fetchDataFromBusinessCentral(String endpoint) {
        return this.webClient.get()
                .uri(endpoint)
                .retrieve()
                .bodyToMono(String.class);
    }

    /**
     * Posts data to a given endpoint in the Business Central API.
     * @param endpoint the API endpoint to post data to.
     * @param requestBody the data to be posted.
     * @return Mono<String> containing the response data.
     */
    public Mono<String> postDataToBusinessCentral(String endpoint, Object requestBody) {
        return this.webClient.post()
                .uri(endpoint)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class);
    }


}
