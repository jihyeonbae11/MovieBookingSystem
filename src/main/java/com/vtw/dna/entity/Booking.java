package com.vtw.dna.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Booking extends CommonDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingId;
    private String cinema;

    @Column(nullable = false, length = 10)
    private Integer persons;
    private Timestamp showTime;

    // Booking - User 테이블 조인 (N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    // Booking - Movie 테이블 조인 (N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movieId")
    private Movie movie;

    public Booking(User user, Movie movie, String cinema, Integer persons, Timestamp showTime) {
        this.user = user;
        this.movie = movie;
        this.cinema = cinema;
        this.persons = persons;
        this.showTime = showTime;
    }

    // 예매 변경 시 상영관, 인원 수, 상영시간 변경 가능
    public Booking setUpdate(String cinema, Integer persons, Timestamp showTime) {
        this.cinema = cinema;
        this.persons = persons;
        this.showTime = showTime;

        return this;
    }


}
