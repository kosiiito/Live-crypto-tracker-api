package com.example.cryptotracker.websocket;

import com.example.cryptotracker.service.PriceService;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PriceWebSocketPublisher {

    private final SimpMessagingTemplate messagingTemplate;
    private final PriceService priceService;

    public PriceWebSocketPublisher(SimpMessagingTemplate messagingTemplate, PriceService priceService) {
        this.messagingTemplate = messagingTemplate;
        this.priceService = priceService;
    }

    @Scheduled(fixedRate = 10000)
    public void sendUpdates() {
        Map<String, Double> prices = priceService.fetchPrices();
        System.out.println("Sending to /topic/prices: " + prices);
        messagingTemplate.convertAndSend("/topic/prices", prices);
    }

}
