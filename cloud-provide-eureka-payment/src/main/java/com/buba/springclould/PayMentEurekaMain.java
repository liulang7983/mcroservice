package com.buba.springclould;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ming.li
 * @date 2022/10/21 16:43
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PayMentEurekaMain {
    public static void main(String[] args) {
        SpringApplication.run(PayMentEurekaMain.class,args);
    }
}
