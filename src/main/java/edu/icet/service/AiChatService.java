package edu.icet.service;

import edu.icet.model.entity.Car;
import edu.icet.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AiChatService {

    @Value("${gemini.api.key}")
    private String apiKey;

    private final CarRepository carRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    public String getAiResponse(String userMessage) {
        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=" + apiKey;

        List<Car> cars = carRepository.findAll();
        StringBuilder carListStr = new StringBuilder("Available Fleet:\n");
        for (Car car : cars) {
            carListStr.append("- ").append(car.getBrand()).append(" ").append(car.getModel())
                    .append(" (").append(car.getSeatCapacity()).append(" seats, ")
                    .append(car.getFuelType()).append(", LKR ").append(car.getPricePerDay()).append(" per day)\n");
        }

        String systemPrompt = "You are an intelligent and friendly AI Assistant for 'UdaraDirect.Car' car rental in Sri Lanka. " +
                "Always reply in short, concise, and helpful paragraphs. " +
                "Recommend cars based ONLY on the following available fleet data from our database:\n" +
                carListStr.toString() + "\n" +
                "If someone needs a driver, mention it costs an extra LKR 2500 per day. " +
                "Here is the user's message: ";

        String fullPrompt = systemPrompt + userMessage;

        Map<String, Object> part = new HashMap<>();
        part.put("text", fullPrompt);

        Map<String, Object> content = new HashMap<>();
        content.put("parts", Collections.singletonList(part));

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("contents", Collections.singletonList(content));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);
            List<Map<String, Object>> candidates = (List<Map<String, Object>>) response.getBody().get("candidates");
            Map<String, Object> contentMap = (Map<String, Object>) candidates.get(0).get("content");
            List<Map<String, Object>> parts = (List<Map<String, Object>>) contentMap.get("parts");

            return (String) parts.get(0).get("text");
        } catch (Exception e) {
            e.printStackTrace();
            return "Sorry! I am currently taking a small break. Please try again in a few moments. 🤖";
        }
    }
}