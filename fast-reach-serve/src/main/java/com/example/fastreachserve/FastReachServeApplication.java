package com.example.fastreachserve;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class FastReachServeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastReachServeApplication.class, args);
        log.info("serve start");
    }

}
