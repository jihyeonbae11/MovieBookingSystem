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

    private UserRepository userRepository;

    // 사용자 ID로 사용자를 조회
    public User findUser(String userId) {
        return Optional.ofNullable(userRepository.findByUserId(userId)).orElseThrow(NullPointerException::new);
    }

//    @PostConstruct
//    public void init() {

//        log.trace("init() invoked.");

//        User user1 = new User("a1111", "a1111", "a1111@naver.com", LocalDateTime.now());
//        User user2 = new User("a2222", "a2222", "a2222@naver.com", LocalDateTime.now());
//        User user3 = new User("a3333", "a3333", "a3333@naver.com", LocalDateTime.now());
//        User user4 = new User("a4444", "a4444", "a4444@naver.com", LocalDateTime.now());
//        User user5 = new User("a5555", "a5555", "a5555@naver.com", LocalDateTime.now());
//        User user6 = new User("a6666", "a6666", "a6666@naver.com", LocalDateTime.now());
//        User user7 = new User("a7777", "a7777", "a7777@naver.com", LocalDateTime.now());
//        User user8 = new User("a8888", "a8888", "a8888@naver.com", LocalDateTime.now());
//        User user9 = new User("a9999", "a9999", "a9999@naver.com", LocalDateTime.now());
//        User user10 = new User("a0000", "a0000", "a0000@naver.com", LocalDateTime.now());

//        User user = new User();
//        user.setUserId("a1111");
//        user.setPw("a1111");
//        user.setEmail("a1111@naver.com");
//        user.setBirth(LocalDateTime.now());
//
//        userRepository.save(user);
//        userRepository.save(user2);
//        userRepository.save(user3);
//        userRepository.save(user4);
//        userRepository.save(user5);
//        userRepository.save(user6);
//        userRepository.save(user7);
//        userRepository.save(user8);
//        userRepository.save(user9);
//        userRepository.save(user10);

//    }


}
