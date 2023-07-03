package com.hfp.domain.support.presentation;

import com.hfp.domain.common.BaseEntity;
import com.hfp.domain.support.application.SupportService;
import com.hfp.domain.support.domain.dto.PostSupportReq;
import com.hfp.domain.support.domain.dto.PostSupportRes;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RequiredArgsConstructor
@RestController
public class SupportController {
    private final SupportService supportService;
    //후원 정보 등록
    @PostMapping("/support")
    public PostSupportRes postSupport(@RequestBody PostSupportReq postSupportReq){
        return supportService.postSupport(postSupportReq);
    }
}
