package com.hfp.domain.user.domain.repository;

import com.hfp.domain.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    List<Users> findByEmail(String email);

    Boolean existsByEmail(String email);
}
