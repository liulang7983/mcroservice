package com.buba.springcloud.controller;

import com.buba.springcloud.pojo.CommonResult;
import com.buba.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ming.li
 * @date 2023/7/28 9:34
 */
@RestController
@RequestMapping("hystrix")
@Slf4j
public class HystrixController {

    @Autowired
    public PaymentHystrixService paymentHystrixService;
    /**
     * 正常访问
     */
    @GetMapping("/paymentInfo_OK")
    public CommonResult paymentInfo_OK(){
        log.info("调用了paymentInfo_OK");
        return paymentHystrixService.paymentInfo_OK();
    }

    /**
     * 超时访问
     */
    @GetMapping("/timeout")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                    value = "1000")
    })
    CommonResult paymentInfo_TimeOut(){
        log.info("调用了paymentInfo_TimeOut");
        return paymentHystrixService.paymentInfo_TimeOut();
    }

    //服务降级的兜底的方法
    public CommonResult paymentTimeOutFallbackMethod() {
        return new CommonResult(200,"我是消费者,我降级了");
    }

}
