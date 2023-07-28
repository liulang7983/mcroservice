package com.buba.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHabdler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")
    } )
    public String paymentInfo_TimeOut() {
        int timeNumber = 3;
        //处理时间超过HystrixCommand时间会走Fallback
      /*  try {
            // 暂停3秒钟
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //程序报错也会走Fallback
        int i=10/0;
        return "paymentInfo_TimeOut暂停三秒后访问";
    }
    public String paymentInfo_TimeOutHabdler(){
        return "超时了，我是生产者的Fallback";
    }

}
