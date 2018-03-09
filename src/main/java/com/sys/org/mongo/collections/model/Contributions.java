
package com.sys.org.mongo.collections.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "FreeRoomContributions",
    "FinancialContributions",
    "PercentageContributions",
    "TurnoverContributions"
})
public class Contributions {

    @JsonProperty("FreeRoomContributions")
    private List<Object> freeRoomContributions = null;
    @JsonProperty("FinancialContributions")
    private List<Object> financialContributions = null;
    @JsonProperty("PercentageContributions")
    private List<Object> percentageContributions = null;
    @JsonProperty("TurnoverContributions")
    private List<Object> turnoverContributions = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("FreeRoomContributions")
    public List<Object> getFreeRoomContributions() {
        return freeRoomContributions;
    }

    @JsonProperty("FreeRoomContributions")
    public void setFreeRoomContributions(List<Object> freeRoomContributions) {
        this.freeRoomContributions = freeRoomContributions;
    }

    @JsonProperty("FinancialContributions")
    public List<Object> getFinancialContributions() {
        return financialContributions;
    }

    @JsonProperty("FinancialContributions")
    public void setFinancialContributions(List<Object> financialContributions) {
        this.financialContributions = financialContributions;
    }

    @JsonProperty("PercentageContributions")
    public List<Object> getPercentageContributions() {
        return percentageContributions;
    }

    @JsonProperty("PercentageContributions")
    public void setPercentageContributions(List<Object> percentageContributions) {
        this.percentageContributions = percentageContributions;
    }

    @JsonProperty("TurnoverContributions")
    public List<Object> getTurnoverContributions() {
        return turnoverContributions;
    }

    @JsonProperty("TurnoverContributions")
    public void setTurnoverContributions(List<Object> turnoverContributions) {
        this.turnoverContributions = turnoverContributions;
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
