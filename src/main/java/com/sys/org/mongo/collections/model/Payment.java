
package com.sys.org.mongo.collections.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Direct",
    "Chain",
    "GroundHandler"
})
public class Payment {

    @JsonProperty("Direct")
    private Object direct;
    @JsonProperty("Chain")
    private Chain_ chain;
    @JsonProperty("GroundHandler")
    private Object groundHandler;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Direct")
    public Object getDirect() {
        return direct;
    }

    @JsonProperty("Direct")
    public void setDirect(Object direct) {
        this.direct = direct;
    }

    @JsonProperty("Chain")
    public Chain_ getChain() {
        return chain;
    }

    @JsonProperty("Chain")
    public void setChain(Chain_ chain) {
        this.chain = chain;
    }

    @JsonProperty("GroundHandler")
    public Object getGroundHandler() {
        return groundHandler;
    }

    @JsonProperty("GroundHandler")
    public void setGroundHandler(Object groundHandler) {
        this.groundHandler = groundHandler;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
