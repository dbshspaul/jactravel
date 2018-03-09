
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
    "MinAmount",
    "StandardAmount",
    "MaxAmount"
})
public class Occupancy {

    @JsonProperty("MinAmount")
    private Integer minAmount;
    @JsonProperty("StandardAmount")
    private Integer standardAmount;
    @JsonProperty("MaxAmount")
    private Integer maxAmount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("MinAmount")
    public Integer getMinAmount() {
        return minAmount;
    }

    @JsonProperty("MinAmount")
    public void setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
    }

    @JsonProperty("StandardAmount")
    public Integer getStandardAmount() {
        return standardAmount;
    }

    @JsonProperty("StandardAmount")
    public void setStandardAmount(Integer standardAmount) {
        this.standardAmount = standardAmount;
    }

    @JsonProperty("MaxAmount")
    public Integer getMaxAmount() {
        return maxAmount;
    }

    @JsonProperty("MaxAmount")
    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
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
