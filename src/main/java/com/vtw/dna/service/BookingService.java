package com.vtw.dna.service;

import com.vtw.dna.entity.Booking;
import com.vtw.dna.entity.Movie;
import com.vtw.dna.entity.User;
import com.vtw.dna.repository.BookingRepository;
import com.vtw.dna.repository.MovieRepository;
import com.vtw.dna.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Book;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookingService {

    private BookingRepository bookingRepository;
    private MovieRepository movieRepository;
    private UserRepository userRepository;

    // 전체 영화 조회
    public List<Movie> getAllMovie() {
        return movieRepository.findAll();
    }

    // 장르별 영화 리스트 조회
    public List<Movie> findGenreMovie(String genre) {
        return Optional.ofNullable(movieRepository.findByGenre(genre)).orElseThrow(NullPointerException::new);
    }

    // 영화 ID로 영화를 조회
    public Movie findMovie(long movieId) {
        return Optional.ofNullable(movieRepository.findByMovieId(movieId)).orElseThrow(NullPointerException::new);
    }

    // 예매 ID로 예매내역 조회
    public Booking getBooking(long bookingId) {
        return bookingRepository.findById(bookingId).orElseThrow(NullPointerException::new);
    }

    // 사용자 ID로 사용자를 조회
    public User findUser(String userId) {
        return Optional.ofNullable(userRepository.findByUserId(userId)).orElseThrow(NullPointerException::new);
    }

    // 사용자 ID로 예매내역 list 조회
    public List<Booking> findBookings(String userId) {
        return bookingRepository.findByUser(findUser(userId));
    }

    // 예매 등록
    public Booking createBooking(String userId, long movieId, String cinema, Integer persons, Timestamp showTime) {
        User user = findUser(userId);
        Movie movie = findMovie(movieId);
        Booking booking = new Booking(user, movie, cinema, persons, showTime);
        return bookingRepository.save(booking);
    }

    // 예매내역 수정
    public Booking updateBooking(long bookingId, String cinema, Integer persons, Timestamp showTime) {
        Booking booking = getBooking(bookingId);
        booking.setUpdate(cinema, persons, showTime);
        return booking;
    }

    // 예매내역 삭제
    public boolean deleteBooking(long bookingId) {
        Booking booking = getBooking(bookingId);
        bookingRepository.delete(booking);
        return true;
    }

}
