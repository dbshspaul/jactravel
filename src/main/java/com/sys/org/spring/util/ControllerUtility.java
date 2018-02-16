package com.sys.org.spring.util;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ControllerUtility {
    @NotNull
    public static ResponseEntity createResponseEntity(Exception e, String... message) {
        Map<String, String> response = new HashMap<>();
        response.put("msg", message.length > 0 ? message[0] : "Failed to find data.");
        response.put("cause", e.getMessage());
        e.printStackTrace();
        return new ResponseEntity(response, HttpStatus.EXPECTATION_FAILED);
    }

    public static class ResponseEntityBuilder extends ResponseEntity {
        private Map<String, Object> response;

        public ResponseEntityBuilder(Map<String, Object> response, HttpStatus status) {
            super(response, status);
            this.response = response;
        }

        public ResponseEntityBuilder add(String key, Object value) {
            response.put(key, value);
            return this;
        }
    }
}
