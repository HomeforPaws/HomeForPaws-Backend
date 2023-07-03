package com.hfp.domain.user.domain.repository;

import java.util.Optional;


import com.hfp.domain.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long>{
    
    Optional<Users> findByEmail(String email);
    Boolean existsByEmail(String email);
}
