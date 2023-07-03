package com.hfp.domain.chatGpt.presentation;

import com.hfp.domain.chatGpt.application.ChatService;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/support")
public class ChatGptController {

    private final ChatService chatService;
    private final ChatgptService chatgptService;

    @PostMapping("/question")
    public String question(@RequestBody String question) {

        return chatService.getChatResponse(question);
    }
}
