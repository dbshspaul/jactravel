package com.sys.org.spring.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sys.org.spring.idclass.RatePK;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RatePKConverter implements Converter<String, RatePK> {

    @Override
    public RatePK convert(String s) {
        ObjectMapper mapper = new ObjectMapper();
        RatePK ratePK = null;
        try {
            ratePK = mapper.readValue(s, RatePK.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ratePK;
    }
}
