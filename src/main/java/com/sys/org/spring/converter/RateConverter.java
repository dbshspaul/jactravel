package com.sys.org.spring.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sys.org.spring.model.Rate;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RateConverter implements Converter<String, Rate> {

    @Override
    public Rate convert(String s) {
        ObjectMapper mapper = new ObjectMapper();
        Rate rate = null;
        try {
            rate = mapper.readValue(s, Rate.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rate;
    }
}
