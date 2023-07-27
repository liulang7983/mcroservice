package com.buba.springcloud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ming.li
 * @date 2023/7/27 19:29
 */
@Component
@FeignClient(value = "cloud-provide-hystrix-payment")
public interface PaymentHystrixService {

    /**
     * 正常访问
     */
    @GetMapping("/paymentInfo_OK")
    String paymentInfo_OK();

    /**
     * 超时访问
     */
    @GetMapping("/timeout")
    String paymentInfo_TimeOut();
}
