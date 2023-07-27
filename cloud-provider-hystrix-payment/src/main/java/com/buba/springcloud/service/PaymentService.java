package com.buba.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author ming.li
 * @date 2023/7/27 11:44
 */
@Service
public class PaymentService {
    /**
     * 正常访问
     */
    public String paymentInfo_OK() {
        return "paymentInfo_OK正常访问";
    }

    /**
     * 超时访问
     */
    public String paymentInfo_TimeOut() {
        int timeNumber = 3;
        try {
            // 暂停3秒钟
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "paymentInfo_TimeOut暂停三秒后访问";
    }

}
