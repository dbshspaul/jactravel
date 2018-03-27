package com.sys.org.spring.controller;

import com.sys.org.spring.idclass.ContractPK;
import com.sys.org.spring.idclass.PropertyPK;
import com.sys.org.spring.idclass.RatePK;
import com.sys.org.spring.idclass.RoomPK;
import com.sys.org.spring.model.Contract;
import com.sys.org.spring.model.Property;
import com.sys.org.spring.model.Rate;
import com.sys.org.spring.model.Room;
import com.sys.org.spring.repositories.ContractRepository;
import com.sys.org.spring.repositories.PropertyRepository;
import com.sys.org.spring.repositories.RateRepository;
import com.sys.org.spring.repositories.RoomRepository;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.ScanQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.cache.Cache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DataWriteController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataWriteController.class);

    @Autowired
    Ignite ignite;
    @Autowired
    ContractRepository contractRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    RateRepository rateRepository;
    @Autowired
    PropertyRepository propertyRepository;

    @GetMapping(value = "/sync", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<?> autoSyncTask() {
        LOGGER.info(">>>>>>>>>>>>>>>>Sync started...");
        Map<String, String> response = new HashMap<>();
        IgniteCache<ContractPK, Contract> contractCache = ignite.cache("contractCache");
        IgniteCache<RoomPK, Room> roomCache = ignite.cache("roomCache");
        IgniteCache<RatePK, Rate> rateCache = ignite.cache("rateCache");
        IgniteCache<PropertyPK, Property> propertytCache = ignite.cache("propertytCache");

        try (QueryCursor<Cache.Entry<ContractPK, Contract>> cursor = contractCache.query(new ScanQuery<ContractPK, Contract>((k, p) -> !p.isSync()))) {
            int i = 0;
            for (Cache.Entry<ContractPK, Contract> p : cursor)
            {
                Contract contract = p.getValue();
                contract.setSync(true);
                contractCache.put(contract.getContractPK(),contract);
                contractRepository.save(p.getValue());
                i++;
            }
            response.put("Contract", String.valueOf(i));
        }

        try (QueryCursor<Cache.Entry<RoomPK, Room>> cursor = roomCache.query(new ScanQuery<RoomPK, Room>((k, p) -> !p.isSync()))) {
            int i = 0;
            for (Cache.Entry<RoomPK, Room> p : cursor)
            {
                Room room = p.getValue();
                room.setSync(true);
                roomCache.put(room.getRoomPK(),room);
                roomRepository.save(p.getValue());
                i++;
            }
            response.put("Room", String.valueOf(i));
        }

        try (QueryCursor<Cache.Entry<RatePK, Rate>> cursor = rateCache.query(new ScanQuery<RatePK, Rate>((k, p) -> !p.isSync()))) {
            int i = 0;
            for (Cache.Entry<RatePK, Rate> p : cursor)
            {
                Rate rate = p.getValue();
                rate.setSync(true);
                rateCache.put(rate.getRatePK(),rate);
                rateRepository.save(p.getValue());
                i++;
            }
            response.put("Rate", String.valueOf(i));
        }

        try (QueryCursor<Cache.Entry<PropertyPK, Property>> cursor = propertytCache.query(new ScanQuery<PropertyPK, Property>((k, p) -> !p.isSync()))) {
            int i = 0;
            for (Cache.Entry<PropertyPK, Property> p : cursor)
            {
                Property property = p.getValue();
                property.setSync(true);
                propertytCache.put(property.getPropertyPK(),property);
                propertyRepository.save(p.getValue());
                i++;
            }
            response.put("Rate", String.valueOf(i));
        }
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

}
