package com.csdj.springbootredis.uilt;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

public class ProductSeckill {

    public static boolean productSeckill(String prodId, String userId) {

        if (prodId == null || userId == null) {
            //如果为null时无法继续执行，可以做提示；
            return false;
        }

        //拼接redis的key值，进行存储value
        String prodKey = "sk:" + prodId + ":qt";
        String userKey = "sk:" + prodId + ":user";
        Jedis jedis = new Jedis("192.168.153.154", 6379);

        //判断是否存在商品key,如果不存在表示还未初始化
        if (jedis.get(prodKey) == null) {
            jedis.close();
            return false;
        }

        jedis.watch(prodKey);

        //校验库存量是否不足
        if (Integer.parseInt(jedis.get(prodKey)) <= 0) {
            jedis.close();
            return false;
        }

        //校验set集合中是否存在该用户，如果存在表示该用户已经秒杀过
        if (jedis.sismember(userKey, userId)) {
            jedis.close();
            return false;
        }

        //防止超卖，监控prodId,乐观锁
        Transaction multi = jedis.multi();

        //秒杀成功，库存-1，set集合加上用户信息
        multi.decr(prodKey);
        multi.sadd(userKey, userId);

        //执行事务
        List<Object> exec = multi.exec();
        if (exec == null || exec.size() == 0) {
            jedis.close();
            return false;
        }

        jedis.close();
        System.out.println("秒杀成功！");
        return true;
    }


}
