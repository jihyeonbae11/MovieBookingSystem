package com.vtw.dna.repository;

import com.vtw.dna.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // 사용자 ID로 사용자를 조회하는 메소드
    User findByUserId(String userId);

}
