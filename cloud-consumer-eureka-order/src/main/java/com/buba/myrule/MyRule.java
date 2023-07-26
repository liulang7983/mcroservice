package com.buba.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ming.li
 * @date 2023/7/26 19:21
 */
@Configuration
public class MyRule {
    @Bean
    public IRule getIRule(){
        return new RandomRule();
    }
}
