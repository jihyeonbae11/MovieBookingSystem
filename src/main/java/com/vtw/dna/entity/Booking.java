package com.vtw.dna.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends CommonDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private String cinema;

    @Column(nullable = false, length = 10)
    private int persons;
    private LocalDateTime showTime;

    // Booking - User 테이블 조인 (N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    // Booking - Movie 테이블 조인 (N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movieId")
    private Movie movie;

//    public Booking(Long bookingId, String userId, Long movieId, String cinema, Integer persons, LocalDateTime showTime) {
//        this.user = user;
//        this.movie = movie;
//        this.cinema = cinema;
//        this.persons = persons;
//        this.showTime = showTime;
//    }

    // 예매 변경 시 상영관, 인원 수, 상영시간 변경 가능
    public Booking update(String cinema, int persons, LocalDateTime showTime) {
        this.cinema = cinema;
        this.persons = persons;
        this.showTime = showTime;

        return this;
    }


}
