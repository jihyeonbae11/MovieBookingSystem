package com.vtw.dna.service;

import com.vtw.dna.entity.Booking;
import com.vtw.dna.entity.Movie;
import com.vtw.dna.entity.User;
import com.vtw.dna.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserService userService;
    private final MovieService movieService;

    // 예매번호로 예매내역 list 조회
    public Page<Booking> findBookings(Pageable pageable, String searchName) {
        return bookingRepository.findAllByCinemaContains(pageable, searchName);
    }

    // 예매번호로 해당 예매정보 조회
    public Booking findBooking(Long bookingId) {
        return bookingRepository.findByBookingId(bookingId);
    }

    // 예매 등록
    public Booking create(Booking booking) {

        User user = userService.findUser(booking.getUser().getUserId());
        Movie movie = movieService.findMovie(booking.getMovie().getMovieId());
        booking.setUser(user);
        booking.setMovie(movie);

        bookingRepository.save(booking);
        return booking;
    }

    // 예매내역 수정
    public Booking update(Long bookingId, String cinema, Integer persons, LocalDateTime showTime) {
        Booking booking = findBooking(bookingId);
        booking.update(cinema, persons, showTime);
        return booking;
    }

    // 예매내역 삭제
    public boolean delete(Long bookingId) {
        Booking booking = findBooking(bookingId);
        bookingRepository.delete(booking);
        return true;
    }

}
