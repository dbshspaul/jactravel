
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
    "ContractNotes",
    "PrivateNotes"
})
public class DurationsNotes {

    @JsonProperty("ContractNotes")
    private Object contractNotes;
    @JsonProperty("PrivateNotes")
    private Object privateNotes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ContractNotes")
    public Object getContractNotes() {
        return contractNotes;
    }

    @JsonProperty("ContractNotes")
    public void setContractNotes(Object contractNotes) {
        this.contractNotes = contractNotes;
    }

    @JsonProperty("PrivateNotes")
    public Object getPrivateNotes() {
        return privateNotes;
    }

    @JsonProperty("PrivateNotes")
    public void setPrivateNotes(Object privateNotes) {
        this.privateNotes = privateNotes;
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
