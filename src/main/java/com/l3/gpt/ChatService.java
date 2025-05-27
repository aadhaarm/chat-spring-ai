package com.l3.gpt;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

  private final ChatClient chatClient;

  public ChatService(ChatClient chatClient) {
    this.chatClient = chatClient;
  }

  public String getChatResponse(String prompt) {
    return chatClient.prompt(prompt).call().content();
  }
}
