package com.buba.springclould.controller;


import com.buba.springcloud.pojo.CommonResult;
import com.buba.springcloud.pojo.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author ming.li
 * @date 2022/10/21 17:20
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    //调用支付订单服务端的ip+端口号
    public static final String PAYMENT_URL = "http://cloud-provide-eureka-payment";
    //注入服务发现的注解
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;

    //创建支付订单的接口
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        System.out.println("调用/consumer/payment/create");
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    //获取id获取支付订单
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        System.out.println("调用/consumer/payment/get");
        CommonResult forObject = null;
        for (int i = 0; i < 10; i++) {
            forObject = restTemplate.getForObject(PAYMENT_URL + "/payment/queryById/" + id, CommonResult.class);
        }
        return forObject;
    }


    //获取服务信息
    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        logger.info("********注册到eureka中的服务中有:" + services);
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-provide-eureka-payment");
        for (ServiceInstance s : instances) {
            logger.info("当前服务的实例有" + s.getServiceId() + "\t" + s.getHost() + "\t" + s.getPort() + "\t" + s.getUri());
        }
        return this.discoveryClient;
    }
}
