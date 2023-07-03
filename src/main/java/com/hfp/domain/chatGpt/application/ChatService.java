package com.hfp.domain.chatGpt.application;

import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatgptService chatgptService;

    public String getChatResponse(String prompt) {

        //ChatGPT한테 질문함
        return chatgptService.sendMessage(prompt);
    }
}
