package com.l3.gpt;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.client.RestTemplate;

public class CustomRestChatModel implements ChatModel {
    private final RestTemplate restTemplate;
    private final String apiUrl;

    public CustomRestChatModel(String apiUrl) {
        this.restTemplate = new RestTemplate();
        this.apiUrl = apiUrl;
    }

    @Override
    public ChatResponse call(Prompt prompt) {
      // Extract the prompt text from the List<Message>
      List<Message> messages = prompt.getInstructions();
      String promptText = messages.stream()
              .filter(msg -> "user".equals(msg.getMessageType().getValue())) // Filter for user messages
              .map(Message::getText) // Get message content
              .reduce((first, second) -> second) // Take the last user message
              .orElseThrow(() -> new IllegalArgumentException("No user message found in prompt"));

      // Prepare the request body for the FastAPI endpoint
      Map<String, String> requestBody = new HashMap<>();
      requestBody.put("text", promptText);

      // Call the FastAPI endpoint
      Map<String, String> response = restTemplate.postForObject(apiUrl, requestBody, Map.class);

      // Extract the response text
      String responseText = response != null ? response.get("response") : "Error: No response from API";

      AssistantMessage assistantMessage = new AssistantMessage(responseText);
      // Create a ChatResponse with the generated text
      Generation generation = new Generation(assistantMessage);
      return new ChatResponse(Collections.singletonList(generation));
    }
}