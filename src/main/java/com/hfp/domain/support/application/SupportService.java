package com.hfp.domain.support.application;

import com.hfp.domain.animal.domain.Animal;
import com.hfp.domain.animal.domain.repository.AnimalRepository;
import com.hfp.domain.support.domain.Support;
import com.hfp.domain.support.domain.dto.PostSupportReq;
import com.hfp.domain.support.domain.dto.PostSupportRes;
import com.hfp.domain.support.domain.repository.SupportRepository;
import com.hfp.domain.user.domain.User;
import com.hfp.domain.user.domain.repository.UserRepository;
import com.hfp.global.error.DefaultException;
import com.hfp.global.payload.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SupportService {
    private final SupportRepository supportRepository;
    private final AnimalRepository animalRepository;
    private final UserRepository userRepository;
    public PostSupportRes postSupport(PostSupportReq postSupportReq){

        Long animal_id = postSupportReq.getAnimal_id();
        Long sponsor_id = postSupportReq.getSponsor_id();
        Long rescue_id = postSupportReq.getRescue_id();
        Integer money = postSupportReq.getMoney();
        LocalDate support_date = postSupportReq.getSupport_date();

        Animal animal = animalRepository.findById(animal_id)
                .orElseThrow(() -> new DefaultException(ErrorCode.INVALID_CHECK));

        User sponsorUser = userRepository.findById(sponsor_id)
                .orElseThrow(() -> new DefaultException(ErrorCode.INVALID_CHECK));

        User rescueUser = userRepository.findById(rescue_id)
                .orElseThrow(() -> new DefaultException(ErrorCode.INVALID_CHECK));

        Support support = Support.builder()
                .supportAnimal(animal)
                .sponsorUser(sponsorUser)
                .rescueUser(rescueUser)
                .money(money)
                .support_date(support_date)
                .build();

        Support savedSupport = supportRepository.save(support);

        PostSupportRes postSupportRes = new PostSupportRes();
        postSupportRes.setSupport_id(savedSupport.getId());
        postSupportRes.setAnimal_id(savedSupport.getSupportAnimal().getId());
        postSupportRes.setSponsor_id(savedSupport.getSponsorUser().getId());
        postSupportRes.setRescue_id(savedSupport.getRescueUser().getId());
        postSupportRes.setMoney(money);
        postSupportRes.setSupport_date(support_date);

        return postSupportRes;
    }

}
