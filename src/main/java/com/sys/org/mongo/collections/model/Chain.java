
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
    "IsAttached",
    "ContactIds",
    "CustomContacts"
})
public class Chain {

    @JsonProperty("IsAttached")
    private Boolean isAttached;
    @JsonProperty("ContactIds")
    private List<Object> contactIds = null;
    @JsonProperty("CustomContacts")
    private List<Object> customContacts = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("IsAttached")
    public Boolean getIsAttached() {
        return isAttached;
    }

    @JsonProperty("IsAttached")
    public void setIsAttached(Boolean isAttached) {
        this.isAttached = isAttached;
    }

    @JsonProperty("ContactIds")
    public List<Object> getContactIds() {
        return contactIds;
    }

    @JsonProperty("ContactIds")
    public void setContactIds(List<Object> contactIds) {
        this.contactIds = contactIds;
    }

    @JsonProperty("CustomContacts")
    public List<Object> getCustomContacts() {
        return customContacts;
    }

    @JsonProperty("CustomContacts")
    public void setCustomContacts(List<Object> customContacts) {
        this.customContacts = customContacts;
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
