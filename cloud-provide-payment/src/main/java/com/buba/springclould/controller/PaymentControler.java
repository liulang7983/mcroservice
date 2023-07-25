package com.buba.springclould.controller;


import com.buba.springcloud.pojo.CommonResult;
import com.buba.springcloud.pojo.Payment;
import com.buba.springclould.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ming.li
 * @date 2022/10/21 16:56
 */
@RestController
@RequestMapping("/payment")
public class PaymentControler {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private Integer port;

    @RequestMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        System.out.println("Payment:"+payment);
        int i = paymentService.create(payment);
        if (i==0){
            return new CommonResult(400,"插入失败");
        }else {
            return new CommonResult(200,"插入成功");
        }
    }

    @RequestMapping("/queryById/{id}")
    public CommonResult queryById(@PathVariable("id") Long id){
        System.out.println("queryById:"+id);
        Payment payment = paymentService.queryById(id);
        if (payment==null){
            return new CommonResult(400,"查询失败");
        }else {
            return new CommonResult(200,"查询成功",payment);
        }
    }
}
