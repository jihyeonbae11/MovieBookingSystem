package com.vtw.dna.service;

import com.vtw.dna.employee.Employee;
import com.vtw.dna.employee.Gender;
import com.vtw.dna.employee.repository.EmployeeRepository;
import com.vtw.dna.entity.Booking;
import com.vtw.dna.entity.Movie;
import com.vtw.dna.entity.User;
import com.vtw.dna.repository.BookingRepository;
import com.vtw.dna.repository.MovieRepository;
import com.vtw.dna.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class InitDd {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostConstruct
    private void init() {

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

        Movie movie1 = new Movie(1L, "블랙팬서-와칸다 포에버", "라이언 쿠글러", "액션", "12세");
        Movie movie2 = new Movie(2L, "동감", "서은영", "로맨스", "12세");
        Movie movie3 = new Movie(3L, "데시벨", "황인호", "액션", "12세");
        Movie movie4 = new Movie(4L, "폴-600미터", "스콧 만", "액션", "12세");
        Movie movie5 = new Movie(5L, "자백", "윤종석", "스릴러", "15세");
        Movie movie6 = new Movie(6L, "고속도로 가족", "이상문", "드라마", "15세");
        Movie movie7 = new Movie(7L, "리멤버", "이일형", "드라마", "15세");

        movieRepository.save(movie1);
        movieRepository.save(movie2);
        movieRepository.save(movie3);
        movieRepository.save(movie4);
        movieRepository.save(movie5);
        movieRepository.save(movie6);
        movieRepository.save(movie7);

        Booking booking1 = new Booking(1L, "CGV", 3, LocalDateTime.now(), user1, movie1);
        Booking booking2 = new Booking(2L, "MEGABOX", 2, LocalDateTime.now(), user2, movie4);
        Booking booking3 = new Booking(3L, "CGV", 1, LocalDateTime.now(), user1, movie2);
        Booking booking4 = new Booking(4L, "CGV", 3, LocalDateTime.now(), user3, movie4);
        Booking booking5 = new Booking(5L, "롯데시네마", 2, LocalDateTime.now(), user5, movie7);


        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);
        bookingRepository.save(booking4);
        bookingRepository.save(booking5);

        Employee employee1 = new Employee(1L, "hien", Gender.Female, null);

        employeeRepository.save(employee1);

    }


}
