package com.buba.springcloud.pojo.test;

import java.math.BigDecimal;

/**
 * @author ming.li
 * @date 2023/9/26 16:24
 */
public class Demo1 {
    public static void main(String[] args) {
        String str="-1234.1254";
        System.out.println(str.replace(" ",""));
        System.out.println(str.matches("-?\\d+(\\.\\d+)?"));

        double num = 3.1415926;
        BigDecimal bd = new BigDecimal(str);
        num = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(num);
        String s = bd.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        System.out.println(s);
    }
}
