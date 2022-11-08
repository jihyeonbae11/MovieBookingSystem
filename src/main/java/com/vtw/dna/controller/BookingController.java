package com.vtw.dna.controller;

import com.vtw.dna.entity.Booking;
import com.vtw.dna.service.BookingService;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("bookinglist")
public class BookingController {

    @Setter(onMethod_ = @Autowired)
    private BookingService bookingService;

    // 해당 유저의 예매내역 조회
    @GetMapping(value="/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Booking> getBookingList(@PathVariable("userId") String userId) throws Exception {

        try { return bookingService.findBookings(userId); }
        catch(Exception e) { throw new Exception (e); }
    }

    // 예매하기
    @PostMapping(value = "/{userId}")
    public Booking createBooking(@PathVariable String userId,
                                 @RequestParam long movieId,
                                 @RequestParam String cinema,
                                 @RequestParam Integer persons,
                                 @RequestParam Timestamp showTime) throws Exception {

        return bookingService.createBooking(userId, movieId, cinema, persons, showTime);
    }

    // 해당 예매내역 수정
    @PutMapping(value = "/{bookingId}")
    public Booking updateBooking(@RequestParam long bookingId,
                                 @RequestParam String cinema,
                                 @RequestParam Integer persons,
                                 @RequestParam Timestamp showTime) throws Exception {

        return bookingService.updateBooking(bookingId, cinema, persons, showTime);
    }

    // 해당 예매내역 삭제
    @DeleteMapping(value = "/{bookingId}")
    public boolean deleteBooking(@PathVariable long bookingId) {
        return bookingService.deleteBooking(bookingId);
    }

}
