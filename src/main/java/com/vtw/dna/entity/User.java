package com.vtw.dna.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends CommonDate {

    @Id
    private String userId;
    private String pw;
    private String email;
    private LocalDateTime birth;

}
