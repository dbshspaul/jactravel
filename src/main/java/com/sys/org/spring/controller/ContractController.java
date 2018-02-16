package com.sys.org.spring.controller;

import com.sys.org.spring.idclass.ContractPK;
import com.sys.org.spring.model.Contract;
import com.sys.org.spring.repositories.ContractRepository;
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
import java.util.List;
import java.util.Map;

@Controller
public class ContractController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContractController.class);

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

    @GetMapping(value = "/contract/{contractId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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

    @DeleteMapping(value = "/contract/{contractId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity getDeleteById(@PathVariable(value = "contractId") Integer contractId,
                                        @RequestParam(value = "tenant_id") String tenantId,
                                        @RequestParam(value = "property_id") Integer propertyId) {
        ResponseEntity entity = null;
        ContractPK contractPK = new ContractPK();
        contractPK.setProperty_id(propertyId);
        contractPK.setContract_id(contractId);
        contractPK.setTenant_id(tenantId);
        boolean remove = contractCache.remove(contractPK);

        if (remove) {
            entity = new ControllerUtility.ResponseEntityBuilder(new HashMap<>(), HttpStatus.OK)
                    .add("msg", "1 Contract successfully deleted")
                    .add("contract id", contractPK);
        } else {
            entity = new ResponseEntity(new StringBuilder("No Data found."), HttpStatus.NOT_FOUND);
        }

        return entity;
    }

    @PostMapping(value = "/contract", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity setContract(@RequestParam(name = "contract", required = true) Contract contract) {
        try {
            contractCache.put(contract.getContractPK(), contract);
            Map<String, String> response = new HashMap<>();
            response.put("msg", "Data updated successfully.");
            return new ResponseEntity(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return ControllerUtility.createResponseEntity(e);
        }
    }
}
