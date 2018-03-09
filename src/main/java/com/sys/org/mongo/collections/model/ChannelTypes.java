
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
    "IsAllSelected",
    "Items"
})
public class ChannelTypes {

    @JsonProperty("IsAllSelected")
    private Boolean isAllSelected;
    @JsonProperty("Items")
    private List<Integer> items = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("IsAllSelected")
    public Boolean getIsAllSelected() {
        return isAllSelected;
    }

    @JsonProperty("IsAllSelected")
    public void setIsAllSelected(Boolean isAllSelected) {
        this.isAllSelected = isAllSelected;
    }

    @JsonProperty("Items")
    public List<Integer> getItems() {
        return items;
    }

    @JsonProperty("Items")
    public void setItems(List<Integer> items) {
        this.items = items;
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
