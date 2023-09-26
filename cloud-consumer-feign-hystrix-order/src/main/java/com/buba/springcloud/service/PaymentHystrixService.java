package com.buba.springcloud.service;

import com.buba.springcloud.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ming.li
 * @date 2023/7/27 19:29
 */
@Service
@FeignClient(value = "cloud-provide-hystrix-payment")
public interface PaymentHystrixService {

    /**
     * 正常访问
     */
    @GetMapping("/paymentInfo_OK")
    CommonResult paymentInfo_OK();

    /**
     * 超时访问
     */
    @GetMapping("/timeout")
    CommonResult paymentInfo_TimeOut();
}
