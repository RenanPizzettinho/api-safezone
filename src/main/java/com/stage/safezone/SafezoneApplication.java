package com.stage.safezone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SafezoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(SafezoneApplication.class, args);
        System.out.println("new BCryptPasswordEncoder().encode(\"123\") = " + new BCryptPasswordEncoder().encode("123"));
    }

}
