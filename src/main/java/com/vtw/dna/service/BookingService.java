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
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookingService {

    private BookingRepository bookingRepository;
    private UserService userService;
    private MovieService movieService;

    // 예매 ID로 예매내역 조회
    public Booking getBooking(long bookingId) {
        return bookingRepository.findById(bookingId).orElseThrow(NullPointerException::new);
    }

    // 사용자 ID로 예매내역 list 조회
    public List<Booking> findBookings(String userId) {
        return bookingRepository.findByUser(userService.findUser(userId));
    }

    // 예매 등록
    public Booking createBooking(String userId, long movieId, String cinema, Integer persons, LocalDateTime showTime) {
        User user = userService.findUser(userId);
        Movie movie = movieService.findMovie(movieId);
        Booking booking = new Booking(user, movie, cinema, persons, showTime);
        return bookingRepository.save(booking);
    }

    // 예매내역 수정
    public Booking updateBooking(long bookingId, String cinema, Integer persons, LocalDateTime showTime) {
        Booking booking = getBooking(bookingId);
        booking.update(cinema, persons, showTime);
        return booking;
    }

    // 예매내역 삭제
    public boolean deleteBooking(long bookingId) {
        Booking booking = getBooking(bookingId);
        bookingRepository.delete(booking);
        return true;
    }

}
