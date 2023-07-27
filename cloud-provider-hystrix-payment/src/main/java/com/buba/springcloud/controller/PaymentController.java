package com.buba.springcloud.controller;

import com.buba.springcloud.pojo.CommonResult;
import com.buba.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ming.li
 * @date 2023/7/27 11:47
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    /**
     * 正常访问
     */
    @GetMapping("/paymentInfo_OK")
    public CommonResult paymentInfo_OK() {
        String result = paymentService.paymentInfo_OK();
        log.info("paymentInfo_OK*******************result:" + result);
        return new CommonResult(200,result);
    }

    /**
     * 超时访问
     */
    @GetMapping("/timeout")
    public CommonResult paymentInfo_TimeOut() {
        String result = paymentService.paymentInfo_TimeOut();
        log.info("paymentInfo_TimeOut*********************result:" + result);
        return new CommonResult(200,result);

    }
}
