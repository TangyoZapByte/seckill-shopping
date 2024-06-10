package com.tyz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tyz.mapper")
public class SeckillShoppingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillShoppingApplication.class, args);
    }

}
