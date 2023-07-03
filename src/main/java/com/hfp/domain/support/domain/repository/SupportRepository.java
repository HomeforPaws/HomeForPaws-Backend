package com.hfp.domain.support.domain.repository;

import com.hfp.domain.support.domain.Support;
import com.hfp.domain.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupportRepository extends JpaRepository<Support, Long> {

    List<Support> findSupportBySponsorUser(User sponsorUser);

    List<Support> findAllById(Long sponsor_id);
}
