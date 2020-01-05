/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.llh.kafka.service;

import java.util.concurrent.CountDownLatch;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author AppDes
 */
@Component
class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    private CountDownLatch latch = new CountDownLatch(1);

   

    @KafkaListener(topics = "kafka-test",group = "test-kafka")
    public void processMessage(ConsumerRecord<?, ?> consumerRecord) {
        LOGGER.info("received payload='{}'", consumerRecord.value());
        latch.countDown();

    }

}
