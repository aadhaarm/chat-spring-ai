package com.l3.gpt;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatConfig {
    @Bean
    public ChatClient chatClient(ChatModel chatModel) {
        return ChatClient.builder(chatModel).build();
    }

    @Bean
    public ChatModel chatModel() {
        // Replace with your Ubuntu machine's IP
        return new CustomRestChatModel("http://192.168.68.73:8001/generate");
    }
}

//import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.ai.openai.OpenAiChatModel;
//import org.springframework.ai.openai.OpenAiChatOptions;
//import org.springframework.ai.openai.api.OpenAiApi;
//import org.springframework.ai.openai.api.OpenAiApi.ChatModel;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ChatConfig {
//    @Value("${spring.ai.openai.api-key}")
//    private String apiKey;
//
//    @Bean
//    public ChatClient chatClient(OpenAiChatModel chatModel) {
//        return ChatClient.builder(chatModel).build();
//    }
//
////    @Bean
////    public OpenAiChatModel openAiChatModel() {
////      OpenAiApi openAiApi =
////          OpenAiApi.builder()
////            .apiKey(apiKey).build();
////      OpenAiChatOptions options = 
////          OpenAiChatOptions.builder()
////            .model(ChatModel.GPT_4_1)
////            .build();
////      return OpenAiChatModel
////                .builder()
////                .openAiApi(openAiApi)
////                .defaultOptions(options)
////                .build();
////    }
//    
//    @Bean
//    public ChatModel chatModel() {
//        // Replace with your Ubuntu machine's IP
//        return new CustomRestChatModel("http://192.168.1.100:8001/generate");
//    }
//}