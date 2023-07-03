package com.hfp.domain.support.presentation;

import com.hfp.domain.support.application.SupportService;
import com.hfp.domain.support.domain.dto.PostSupportReq;
import com.hfp.domain.support.domain.dto.PostSupportRes;
import com.hfp.domain.support.domain.dto.response.SupportBadgeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/support")
public class SupportController {
    private final SupportService supportService;
    //후원 정보 등록
    @PostMapping("/")
    public PostSupportRes postSupport(@RequestBody PostSupportReq postSupportReq) {
        return supportService.postSupport(postSupportReq);
    }

    @GetMapping("/{sponsor_id}")
    public ResponseEntity<?> getSupport(@PathVariable Long sponsor_id) {

        SupportBadgeResponseDto supportBadgeResponseDto = supportService.getSupport(sponsor_id);

        return ResponseEntity.ok(supportBadgeResponseDto);
    }
}
