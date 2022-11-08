package com.vtw.dna.repository;

import com.vtw.dna.entity.Booking;
import com.vtw.dna.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    // 사용자별 예매목록 조회를 위한 메소드
    List<Booking> findByUser(User user);

}
