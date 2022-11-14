package com.vtw.dna.controller;

import com.vtw.dna.entity.Booking;
import com.vtw.dna.service.BookingService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("booking")
public class BookingController {

    @Setter(onMethod_ = @Autowired)
    private BookingService bookingService;

    // 예매내역 list 조회
    @GetMapping("list")
    public Page<Booking> list(@RequestParam("page") int page,
                              @RequestParam("size") int size,
                              @RequestParam(value = "sortBy", defaultValue = "bookingId") String sortBy,
                              @RequestParam(value = "sortDir", defaultValue = "asc") String sortDir,
                              @RequestParam(value = "filter", defaultValue = "") String filter) throws Exception {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDir), sortBy));
        Page<Booking> bookings = bookingService.findBookings(pageable, filter);

        return bookings;

    }

    // 해당 예매내역 조회
    @GetMapping("/{bookingId}")
    public Booking find(@PathVariable Long bookingId) {
        Booking booking = bookingService.findBooking(bookingId);
        return booking;
    }

    // 예매하기
    @PostMapping
    public Booking create(@RequestBody Booking booking) {
        return bookingService.create(booking);
    }

    // 해당 예매내역 수정
    @PutMapping( "/{bookingId}")
    public Booking update(@PathVariable Long bookingId,
                          @RequestBody Booking newBooking) {

        String cinema = newBooking.getCinema();
        int persons = newBooking.getPersons();
        LocalDateTime showTime = newBooking.getShowTime();

        return bookingService.update(bookingId, cinema, persons, showTime);
    }

    // 해당 예매내역 삭제
    @DeleteMapping("/{bookingId}")
    public boolean delete(@PathVariable Long bookingId) {
        return bookingService.delete(bookingId);
    }

}
