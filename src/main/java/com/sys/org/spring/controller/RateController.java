package com.sys.org.spring.controller;

import com.datastax.driver.core.LocalDate;
import com.sys.org.spring.idclass.RatePK;
import com.sys.org.spring.model.Rate;
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
public class RateController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RateController.class);

    @Autowired
    IgniteCache<RatePK, Rate> rateCache;

    @GetMapping(value = "/rate/{ratePlanId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity getRateById(@PathVariable(name = "ratePlanId") Integer ratePlanId,
                                      @RequestParam(name = "stayDate") LocalDate stayDate,
                                      @RequestParam(name = "tenantId") String tenantId) {
        ResponseEntity entity = null;
        RatePK ratePK = new RatePK();
        ratePK.setRate_plan_id(ratePlanId);
        ratePK.setStay_date(stayDate);
        ratePK.setTenant_id(tenantId);
        Rate rate = rateCache.get(ratePK);

        if (rate != null) {

            entity = new ResponseEntity(rate, HttpStatus.FOUND);
        } else {
            entity = new ResponseEntity(new StringBuilder("No Data found."), HttpStatus.NOT_FOUND);
        }

        return entity;
    }

    @DeleteMapping(value = "/rate/{ratePlanId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity getDeleteById(@PathVariable(name = "ratePlanId") Integer ratePlanId,
                                        @RequestParam(name = "stayDate") LocalDate stayDate,
                                        @RequestParam(name = "tenantId") String tenantId) {
        ResponseEntity entity = null;
        RatePK ratePK = new RatePK();
        ratePK.setRate_plan_id(ratePlanId);
        ratePK.setStay_date(stayDate);
        ratePK.setTenant_id(tenantId);
        boolean remove = rateCache.remove(ratePK);

        if (remove) {
            entity = new ControllerUtility.ResponseEntityBuilder(new HashMap<>(), HttpStatus.OK)
                    .add("msg", "1 Rate successfully deleted");
        } else {
            entity = new ResponseEntity(new StringBuilder("No Data found."), HttpStatus.NOT_FOUND);
        }

        return entity;
    }

    @PostMapping(value = "/rate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity setRate(@RequestParam(name = "rate", required = true) Rate rate) {
        try {
            rateCache.put(rate.getRatePK(), rate);
            Map<String, String> response = new HashMap<>();
            response.put("msg", "Data updated successfully.");
            return new ResponseEntity(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return ControllerUtility.createResponseEntity(e);
        }
    }
}
