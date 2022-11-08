package com.vtw.dna.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class User extends CommonDate {

    @Id
    private String userId;
    private String pw;
    private String email;
    private Timestamp birth;

}
