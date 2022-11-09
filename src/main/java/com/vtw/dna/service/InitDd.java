package com.vtw.dna.service;

import com.vtw.dna.entity.User;
import com.vtw.dna.repository.MovieRepository;
import com.vtw.dna.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Slf4j

@Component
public class InitDd {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void init() {

        log.trace("init() invoked.");

        User user1 = new User("a1111", "a1111", "a1111@naver.com", LocalDateTime.now());
        User user2 = new User("a2222", "a2222", "a2222@naver.com", LocalDateTime.now());
        User user3 = new User("a3333", "a3333", "a3333@naver.com", LocalDateTime.now());
        User user4 = new User("a4444", "a4444", "a4444@naver.com", LocalDateTime.now());
        User user5 = new User("a5555", "a5555", "a5555@naver.com", LocalDateTime.now());

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);

    }


}
