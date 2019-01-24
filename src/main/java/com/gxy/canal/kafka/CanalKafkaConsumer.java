package com.gxy.canal.kafka;

import com.gxy.canal.handler.TableManager;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.List;

/**
 * @author guoxingyong
 * @since 2019/1/21 13:52
 */
@Configuration
public class CanalKafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(CanalKafkaConsumer.class);

    @Autowired
    private TableManager tableManager;

    @KafkaListener(topics = {"${kafka.canal.topic}"})
    public void consumerListen(List<ConsumerRecord<String, String>> consumerRecordList) {
        for (ConsumerRecord<String, String> stringConsumerRecord : consumerRecordList) {
            try {
                tableManager.dealCanalData(stringConsumerRecord.value());
            } catch (Exception e) {
                logger.error("", e);
                logger.error("parse canalEntity fail,this consumerRecord:{}", stringConsumerRecord);
            }
        }
    }
}


