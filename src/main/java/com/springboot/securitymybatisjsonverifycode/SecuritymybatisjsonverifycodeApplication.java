package com.springboot.securitymybatisjsonverifycode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.springboot.securitymybatisjsonverifycode.*.dao")
public class SecuritymybatisjsonverifycodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecuritymybatisjsonverifycodeApplication.class, args);
    }

}
