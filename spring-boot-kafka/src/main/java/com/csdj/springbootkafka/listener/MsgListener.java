package com.csdj.springbootkafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
public class MsgListener {

    @KafkaListener(topics = "news", groupId = "read")
    public void read(ConsumerRecord consumerRecord) {
        Object key = consumerRecord.key();
        Object value = consumerRecord.value();
        System.out.println();
    }

    @KafkaListener(topicPartitions = {@TopicPartition(topic = "news", partitionOffsets = {@PartitionOffset(partition = "0", initialOffset = "0")})})
    public void reads(ConsumerRecord consumerRecord) {
        long offset = consumerRecord.offset();
        Object key = consumerRecord.key();
        Object value = consumerRecord.value();
        System.out.println("offset:" + offset + "------>" + key + ":" + value);
    }
}
