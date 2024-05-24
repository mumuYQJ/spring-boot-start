package com.csdj.springbootkafka;

import com.csdj.springbootkafka.entity.User;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.StopWatch;

import java.util.concurrent.CompletableFuture;

@SpringBootTest
class SpringBootKafkaApplicationTests {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void sendMessage() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        CompletableFuture[] completableFutures = new CompletableFuture[10000];
        for (int i = 0; i < 10000; i++) {
            CompletableFuture completableFuture = kafkaTemplate.send("news", "a" + i, "hh" + i);
            completableFutures[i] = completableFuture;
        }
        CompletableFuture.allOf(completableFutures).join();
        stopWatch.stop();
        long totalTimeMillis = stopWatch.getTotalTimeMillis();
        System.out.println(totalTimeMillis);
    }

    @Test
    void sendMessageObject() {
        CompletableFuture completableFuture = kafkaTemplate.send("news", "user", new User(10L, "李乔", "女"));
        completableFuture.join();
    }
}
