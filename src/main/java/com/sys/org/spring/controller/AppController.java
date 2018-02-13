package com.sys.org.spring.controller;

import com.sys.org.spring.idclass.ContractPK;
import com.sys.org.spring.model.Contract;
import com.sys.org.spring.repositories.ContractRepository;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;
import java.util.List;

@Controller
public class AppController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @Autowired
    IgniteCache<ContractPK, Contract> contractCache;

    ContractRepository contractRepository;

    @Autowired
    public void setContractRepository(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @GetMapping(path = "/")
    @ResponseBody
    public String getData() {
        LOGGER.info("request to /");
        return "Hello India!!!";
    }

    @GetMapping(path = "/contracts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity getAllContracts() {
        List<Contract> contractList = (List<Contract>) contractRepository.findAll();
        return new ResponseEntity(contractList, HttpStatus.FOUND);
    }

    @GetMapping(value = "/contract/{contractId}")
    @ResponseBody
    public ResponseEntity getContractById(@PathVariable(value = "contractId") Integer contractId,
                                          @RequestParam(value = "tenant_id") String tenantId,
                                          @RequestParam(value = "property_id") Integer propertyId) {
        ResponseEntity entity = null;
        ContractPK contractPK = new ContractPK();
        contractPK.setProperty_id(propertyId);
        contractPK.setContract_id(contractId);
        contractPK.setTenant_id(tenantId);
        Contract contract = contractCache.get(contractPK);

        if (contract != null) {

            entity = new ResponseEntity(contract, HttpStatus.FOUND);
        } else {
            entity = new ResponseEntity(new StringBuilder("No Data found."), HttpStatus.NOT_FOUND);
        }

        return entity;
    }
}
