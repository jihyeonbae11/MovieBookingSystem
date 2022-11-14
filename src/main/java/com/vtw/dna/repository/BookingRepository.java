package com.vtw.dna.repository;

import com.vtw.dna.entity.Booking;
import com.vtw.dna.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    // userId로 검색
    Page<Booking> findAllByCinemaContains(Pageable pageable, String searchName);

    // 예매번호로 검색
    Booking findByBookingId(Long bookingId);
}
