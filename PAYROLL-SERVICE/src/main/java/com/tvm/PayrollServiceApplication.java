package com.tvm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.tvm.feign")
@EnableScheduling
public class PayrollServiceApplication {
        public static void main(String[] args) {
                SpringApplication.run(PayrollServiceApplication.class, args);
        }
}
