package com.sys.org.spring.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sys.org.spring.model.Contract;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ContractConverter implements Converter<String, Contract> {

    @Override
    public Contract convert(String s) {
        ObjectMapper mapper = new ObjectMapper();
        Contract contract = null;
        try {
            contract = mapper.readValue(s, Contract.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contract;
    }
}
