package com.vtw.dna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DnaBackendSkeletonApplication {

    public static void main(String[] args) {
        SpringApplication.run(DnaBackendSkeletonApplication.class, args);
    }

}
