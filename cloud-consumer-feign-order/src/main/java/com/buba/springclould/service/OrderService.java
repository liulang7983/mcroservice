package com.buba.springclould.service;

import com.buba.springcloud.pojo.CommonResult;
import com.buba.springcloud.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author ming.li
 * @date 2023/7/26 19:58
 */
@Configuration
@FeignClient(value = "cloud-provide-eureka-payment")
public interface OrderService {
     @PostMapping("/payment/create")
     CommonResult<Payment> create(Payment payment);
     @GetMapping("/payment/queryById/{id}")
     CommonResult<Payment> getPayment(@PathVariable("id") Long id);
     @GetMapping("/payment/timeout")
     String timeout();
}
