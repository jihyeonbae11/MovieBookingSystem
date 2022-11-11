package com.vtw.dna.service;

import com.vtw.dna.entity.User;
import com.vtw.dna.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 사용자 ID로 사용자를 조회
    public User findUser(String userId) {
        return Optional.ofNullable(userRepository.findByUserId(userId)).orElseThrow(NullPointerException::new);
    }

}
