package com.zzz.pped;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableDubbo
@MapperScan("com.zzz.pped.test.mapper")
public class RecordApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecordApplication.class, args);
    }

}
