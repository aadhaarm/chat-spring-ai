package com.l3.gpt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

  private final ChatService chatService;

  public ChatController(ChatService chatService) {
    this.chatService = chatService;
  }
  
  @GetMapping("/chat")
  public String chat(String prompt) {
    return chatService.getChatResponse(prompt);
  }
}
