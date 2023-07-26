package com.buba.springclould;


import com.buba.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author ming.li
 * @date 2022/10/21 17:18
 */
@SpringBootApplication
@EnableDiscoveryClient
//name为生产者服务的服务名称  configuration为配置类的类名
//此时代表着负载均衡不是是使用RestTemplate的roundRobinRule轮询负载算法，使用的是自己定义的非@ComponentScan可扫描到的MyRule里面的
@RibbonClient(name = "cloud-provide-eureka-payment",configuration = MyRule.class)
public class OrderEurekaMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderEurekaMain.class,args);
    }
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
