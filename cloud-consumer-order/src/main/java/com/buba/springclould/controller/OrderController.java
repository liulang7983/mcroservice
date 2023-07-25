package com.buba.springclould.controller;


import com.buba.springcloud.pojo.CommonResult;
import com.buba.springcloud.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author ming.li
 * @date 2022/10/21 17:20
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    //调用支付订单服务端的ip+端口号
    public static final  String PAYMENT_URL = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;
    //创建支付订单的接口
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        System.out.println("调用/consumer/payment/create");
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment, CommonResult.class);
    }
    //获取id获取支付订单
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        System.out.println("调用/consumer/payment/get");
        return restTemplate.getForObject(PAYMENT_URL+"/payment/queryById/"+id,CommonResult.class);
    }
}
