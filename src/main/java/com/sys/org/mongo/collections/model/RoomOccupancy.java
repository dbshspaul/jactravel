
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
    "Occupancy",
    "Adult",
    "AdultWithChild",
    "Children",
    "Cots",
    "ExtraBedOccupancy"
})
public class RoomOccupancy {

    @JsonProperty("Occupancy")
    private Occupancy occupancy;
    @JsonProperty("Adult")
    private Object adult;
    @JsonProperty("AdultWithChild")
    private Object adultWithChild;
    @JsonProperty("Children")
    private Object children;
    @JsonProperty("Cots")
    private Object cots;
    @JsonProperty("ExtraBedOccupancy")
    private Object extraBedOccupancy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Occupancy")
    public Occupancy getOccupancy() {
        return occupancy;
    }

    @JsonProperty("Occupancy")
    public void setOccupancy(Occupancy occupancy) {
        this.occupancy = occupancy;
    }

    @JsonProperty("Adult")
    public Object getAdult() {
        return adult;
    }

    @JsonProperty("Adult")
    public void setAdult(Object adult) {
        this.adult = adult;
    }

    @JsonProperty("AdultWithChild")
    public Object getAdultWithChild() {
        return adultWithChild;
    }

    @JsonProperty("AdultWithChild")
    public void setAdultWithChild(Object adultWithChild) {
        this.adultWithChild = adultWithChild;
    }

    @JsonProperty("Children")
    public Object getChildren() {
        return children;
    }

    @JsonProperty("Children")
    public void setChildren(Object children) {
        this.children = children;
    }

    @JsonProperty("Cots")
    public Object getCots() {
        return cots;
    }

    @JsonProperty("Cots")
    public void setCots(Object cots) {
        this.cots = cots;
    }

    @JsonProperty("ExtraBedOccupancy")
    public Object getExtraBedOccupancy() {
        return extraBedOccupancy;
    }

    @JsonProperty("ExtraBedOccupancy")
    public void setExtraBedOccupancy(Object extraBedOccupancy) {
        this.extraBedOccupancy = extraBedOccupancy;
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
