package com.csdj.springbootredis.controller;

import com.csdj.springbootredis.uilt.ProductSeckill;
import com.csdj.springbootredis.uilt.SecKill_redisByScript;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Random;

@Controller
public class ProductSeckillController {

    @PostMapping("/productSeckill")
    @ResponseBody
    public boolean productSeckill(String prodId) throws IOException {
        Random random = new Random();
        int userId = random.nextInt(5000);
//        return ProductSeckill.productSeckill(prodId,String.valueOf(userId));
        return SecKill_redisByScript.doSecKill(String.valueOf(userId),prodId);
    }
}
