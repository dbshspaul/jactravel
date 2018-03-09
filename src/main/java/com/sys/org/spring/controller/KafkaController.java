package com.sys.org.spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sys.org.mongo.collections.model.PropertyRoomType;
import com.sys.org.spring.idclass.ContractPK;
import com.sys.org.spring.idclass.PropertyPK;
import com.sys.org.spring.idclass.RatePK;
import com.sys.org.spring.idclass.RoomPK;
import com.sys.org.spring.model.Contract;
import com.sys.org.spring.model.Property;
import com.sys.org.spring.model.Rate;
import com.sys.org.spring.model.Room;
import org.apache.ignite.IgniteCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class KafkaController {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaController.class);
    @Autowired
    IgniteCache<ContractPK, Contract> contractCache;

    @Autowired
    IgniteCache<PropertyPK, Property> propertyCache;

    @Autowired
    IgniteCache<RatePK, Rate> rateCache;

    @Autowired
    IgniteCache<RoomPK, Room> roomCache;


    @KafkaListener(topics = "${kafka.consumer.topic.name}")
    public void receive(String payload) {
        LOGGER.info("New payload received from kafka");
        ObjectMapper mapper = new ObjectMapper();
        try {
            Contract contract = mapper.readValue(payload, Contract.class);
            contractCache.put(contract.getContractPK(), contract);
            LOGGER.info("Contract save/updated successfully.");
        } catch (IOException e) {
        }
        try {
            Room room = mapper.readValue(payload, Room.class);
            roomCache.put(room.getRoomPK(), room);
            LOGGER.info("Room save/updated successfully.");
        } catch (IOException e) {
        }
        try {
            Rate rate = mapper.readValue(payload, Rate.class);
            rateCache.put(rate.getRatePK(), rate);
            LOGGER.info("Rate save/updated successfully.");
        } catch (IOException e) {
        }
        try {
            Property property = mapper.readValue(payload, Property.class);
            propertyCache.put(property.getPropertyPK(), property);
            LOGGER.info("Property save/updated successfully.");
        } catch (IOException e) {
        }
        try {
            com.sys.org.mongo.collections.model.Contract contract = mapper.readValue(payload, com.sys.org.mongo.collections.model.Contract.class);

            LOGGER.info("mongo schema contract contract parse successfully.");
        } catch (IOException e) {
        }
    }
}
