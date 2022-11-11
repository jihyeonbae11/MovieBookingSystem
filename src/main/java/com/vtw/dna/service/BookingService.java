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

//    public Optional<Object> findByBookingId(Long bookingId) {
//        return bookingRepository.findByBookingId(bookingId).orElseThrow(NullPointerException::new);
//    }

    // 사용자 ID로 예매내역 list 조회
//    public Page<Booking> findBookings(Pageable pageable, String userId) {
//        return bookingRepository.findByUserIdContains(pageable, userId, userService.findUser(userId));
//    }

    // 예매 등록
    public Booking createBooking(Booking booking) {

//        String userId, Long movieId, String cinema, Integer persons, LocalDateTime showTime
        User user = userService.findUser(booking.getUser().getUserId());
        Movie movie = movieService.findMovie(booking.getMovie().getMovieId());

        booking.setUser(user);
        booking.setMovie(movie);

        return bookingRepository.save(booking);
    }

    // 예매내역 수정
    public Booking updateBooking(Long bookingId, String cinema, Integer persons, LocalDateTime showTime) {
        Booking booking = findBooking(bookingId);
        booking.update(cinema, persons, showTime);
        return booking;
    }

    // 예매내역 삭제
    public boolean deleteBooking(Long bookingId) {
        Booking booking = findBooking(bookingId);
        bookingRepository.delete(booking);
        return true;
    }

}
