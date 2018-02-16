package com.sys.org.spring.controller;

import com.sys.org.spring.idclass.PropertyPK;
import com.sys.org.spring.model.Property;
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
public class PropertyController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyController.class);

    @Autowired
    IgniteCache<PropertyPK, Property> propertyCache;

    @GetMapping(value = "/property/{propertyId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity getPropertyById(@PathVariable(value = "propertyId") Integer propertyId,
                                          @RequestParam(value = "tenant_id") String tenantId) {
        ResponseEntity entity = null;
        PropertyPK propertyPK = new PropertyPK();
        propertyPK.setProperty_id(propertyId);
        propertyPK.setTenant_id(tenantId);
        Property property = propertyCache.get(propertyPK);

        if (property != null) {

            entity = new ResponseEntity(property, HttpStatus.FOUND);
        } else {
            entity = new ResponseEntity(new StringBuilder("No Data found."), HttpStatus.NOT_FOUND);
        }

        return entity;
    }

    @DeleteMapping(value = "/property/{propertyId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity getDeleteById(@PathVariable(value = "propertyId") Integer propertyId,
                                        @RequestParam(value = "tenant_id") String tenantId) {
        ResponseEntity entity = null;
        PropertyPK propertyPK = new PropertyPK();
        propertyPK.setProperty_id(propertyId);
        propertyPK.setTenant_id(tenantId);
        boolean remove = propertyCache.remove(propertyPK);

        if (remove) {
            entity = new ControllerUtility.ResponseEntityBuilder(new HashMap<>(), HttpStatus.OK)
                    .add("msg", "1 Propery successfully deleted")
                    .add("propertyPK", propertyPK);
        } else {
            entity = new ResponseEntity(new StringBuilder("No Data found."), HttpStatus.NOT_FOUND);
        }

        return entity;
    }

    @PostMapping(value = "/property", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity setProperty(@RequestParam(name = "property", required = true) Property property) {
        try {
            propertyCache.put(property.getPropertyPK(), property);
            Map<String, String> response = new HashMap<>();
            response.put("msg", "Data updated successfully.");
            return new ResponseEntity(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return ControllerUtility.createResponseEntity(e);
        }
    }

}
