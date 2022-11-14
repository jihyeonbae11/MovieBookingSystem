package com.vtw.dna.controller;

import com.vtw.dna.entity.Movie;
import com.vtw.dna.entity.User;
import com.vtw.dna.repository.UserRepository;
import com.vtw.dna.service.MovieService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Setter(onMethod_ = @Autowired)
    private UserRepository userRepository;

    // 전체 영화정보
    @GetMapping("/list")
    public Page<User> list(@RequestParam("page") int page,
                           @RequestParam("size") int size,
                           @RequestParam(value = "sortBy", defaultValue = "userId") String sortBy,
                           @RequestParam(value = "sortDir", defaultValue = "asc") String sortDir,
                           @RequestParam(value = "filter", defaultValue = "") String filter) throws Exception {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDir), sortBy));
        Page<User> users = userRepository.findAllByUserIdContains(pageable, filter);

        return users;
    }

}
