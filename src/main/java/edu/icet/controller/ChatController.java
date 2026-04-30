package edu.icet.controller;

import edu.icet.service.AiChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ChatController {

    private final AiChatService aiChatService;

    @PostMapping("/ask")
    public ResponseEntity<Map<String, String>> askAi(@RequestBody Map<String, String> request) {
        String userMessage = request.get("message");

        if (userMessage == null || userMessage.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("reply", "Message cannot be empty!"));
        }

        String aiResponse = aiChatService.getAiResponse(userMessage);

        return ResponseEntity.ok(Map.of("reply", aiResponse));
    }
}