package com.beyourself;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.beyourself.mapper")
public class BYsfWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BYsfWebApplication.class, args);
    }

}
