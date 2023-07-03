package com.hfp.domain.support.application;

import com.hfp.domain.animal.domain.Animal;
import com.hfp.domain.animal.domain.repository.AnimalRepository;
import com.hfp.domain.support.domain.Support;
import com.hfp.domain.support.domain.dto.PostSupportReq;
import com.hfp.domain.support.domain.dto.PostSupportRes;
import com.hfp.domain.support.domain.dto.response.SupportBadgeResponseDto;
import com.hfp.domain.support.domain.dto.response.SupportListResponseDto;
import com.hfp.domain.support.domain.repository.SupportRepository;
import com.hfp.domain.user.domain.Users;
import com.hfp.domain.user.domain.repository.UserRepository;
import com.hfp.global.error.DefaultException;
import com.hfp.global.payload.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Service
@Transactional
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

        Users sponsorUser = userRepository.findById(sponsor_id)
                .orElseThrow(() -> new DefaultException(ErrorCode.INVALID_CHECK));

        Users rescueUser = userRepository.findById(rescue_id)
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

    public SupportBadgeResponseDto getSupport(Long sponsor_id) {

        Users sponsorUser = userRepository.findById(sponsor_id).orElseThrow(
                () -> new IllegalArgumentException("해당하는 후원자 정보를 찾을 수 없습니다.")
        );

        List<Support> support_list = supportRepository.findAllBySponsorUser(sponsorUser);

        System.out.println("support_list.size() = " + support_list.size());

        List<SupportListResponseDto> supportListResponseDtos = support_list.stream()
                .map(support -> SupportListResponseDto.builder()
                        .support_id(support.getId())
                        .support_date(support.getSupport_date())
                        .money(support.getMoney())
                        .animal_name(support.getSupportAnimal().getName())
                        .animal_url(support.getSupportAnimal().getImage_url())
                        .build())
                .toList();

        int support_num = supportListResponseDtos.size();
        int badge_num = 0;
        if (support_num > 0 && support_num <= 5) {
            badge_num = 1;
        } else if (support_num > 5 && support_num <= 10) {
            badge_num = 2;
        } else if (support_num > 10 && support_num <= 15) {
            badge_num = 3;
        } else if (support_num > 15) {
            badge_num = 4;
        }

        System.out.println("badge_num = " + badge_num);

        List<Integer> badge_list = IntStream.range(1, badge_num + 1).boxed().collect(Collectors.toList());

        return SupportBadgeResponseDto.builder()
                .badge_list(badge_list)
                .support_list(supportListResponseDtos)
                .build();
    }
}
