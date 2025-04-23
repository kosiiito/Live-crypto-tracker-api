package com.example.cryptotracker.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.core.ParameterizedTypeReference;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PriceService {

    private final WebClient webClient = WebClient.create("https://api.coingecko.com/api/v3");

    public Map<String, Double> fetchPrices() {
        String url = "/simple/price?ids=bitcoin,ethereum,dogecoin&vs_currencies=usd";
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Map<String, Double>>>() {})
                .map(result -> result.entrySet().stream()
                        .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            e -> e.getValue().get("usd")
                        )))
                .block();
    }
}
