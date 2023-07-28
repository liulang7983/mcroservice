package com.buba.springcloud.service.fallBack;

import com.buba.springcloud.pojo.CommonResult;
import com.buba.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author ming.li
 * @date 2023/7/28 11:09
 */
@Component
public class PaymentHystrixServiceFallBack implements PaymentHystrixService {

    @Override
    public CommonResult paymentInfo_OK() {
        return new CommonResult(200,"我是paymentInfo_OK的FallBack");
    }

    @Override
    public CommonResult paymentInfo_TimeOut() {
        return new CommonResult(200,"我是paymentInfo_TimeOut的FallBack");
    }
}
