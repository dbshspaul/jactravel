package com.sys.org.spring.controller;

import com.sys.org.spring.idclass.RoomPK;
import com.sys.org.spring.model.Room;
import com.sys.org.spring.util.ControllerUtility;
import org.apache.ignite.IgniteCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RoomController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoomController.class);

    @Autowired
    IgniteCache<RoomPK, Room> roomCache;

    @GetMapping(value = "/room/{roomId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity getRoomById(@PathVariable(name = "roomId") Integer roomId,
                                          @RequestParam(name = "contractId") Integer contractId,
                                          @RequestParam(name = "tenantId") String tenantId) {
        ResponseEntity entity = null;
        RoomPK roomPK = new RoomPK();
        roomPK.setRoom_id(roomId);
        roomPK.setContract_id(contractId);
        roomPK.setTenant_id(tenantId);
        Room room = roomCache.get(roomPK);

        if (room != null) {

            entity = new ResponseEntity(room, HttpStatus.FOUND);
        } else {
            entity = new ResponseEntity(new StringBuilder("No Data found."), HttpStatus.NOT_FOUND);
        }

        return entity;
    }

    @DeleteMapping(value = "/room/{roomId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity getDeleteById(@PathVariable(name = "roomId") Integer roomId,
                                        @RequestParam(name = "contractId") Integer contractId,
                                        @RequestParam(name = "tenantId") String tenantId) {
        ResponseEntity entity = null;
        RoomPK roomPK = new RoomPK();
        roomPK.setRoom_id(roomId);
        roomPK.setContract_id(contractId);
        roomPK.setTenant_id(tenantId);
        boolean remove = roomCache.remove(roomPK);

        if (remove) {
            entity = new ControllerUtility.ResponseEntityBuilder(new HashMap<>(), HttpStatus.OK)
                    .add("msg", "1 Room successfully deleted");
        } else {
            entity = new ResponseEntity(new StringBuilder("No Data found."), HttpStatus.NOT_FOUND);
        }

        return entity;
    }

    @PostMapping(value = "/room", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity setRoom(@RequestParam(name = "room", required = true) Room room) {
        try {
            roomCache.put(room.getRoomPK(), room);
            Map<String, String> response = new HashMap<>();
            response.put("msg", "Data inserted successfully.");
            return new ResponseEntity(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return ControllerUtility.createResponseEntity(e);
        }
    }

    @PutMapping(value = "/room", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity updateRoom(@RequestParam(name = "room", required = true) Room room) {
        try {
            roomCache.put(room.getRoomPK(), room);
            Map<String, String> response = new HashMap<>();
            response.put("msg", "Data updated successfully.");
            return new ResponseEntity(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return ControllerUtility.createResponseEntity(e);
        }
    }
}
