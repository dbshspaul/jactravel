package com.sys.org.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerUtil {
    private ProducerUtil() {
    }

    private static class SingletonHelper{
        private static final ProducerUtil INSTANCE = new ProducerUtil();
    }

    public static ProducerUtil getInstance() {
        return SingletonHelper.INSTANCE;
    }

    private Producer<String, String> getProducer() {
        Properties configProperties = new Properties();
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return new KafkaProducer<String, String>(configProperties);
    }

    public void sendMessage(String topicName, String message) {
        Producer<String, String> producer = getInstance().getProducer();
        try {
            ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, message);
            producer.send(rec);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }
}