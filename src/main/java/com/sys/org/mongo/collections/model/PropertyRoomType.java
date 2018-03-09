
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
    "_id",
    "Name",
    "RoomType",
    "RoomView",
    "RoomClass",
    "Children",
    "Youth",
    "Infant",
    "AutoUpgradeChildToAdult",
    "ChildOccupancyOnlyAllowed",
    "InfantsCountTowardOccupancy",
    "YouthCountAsAdults",
    "BedType",
    "ExtraBedType",
    "RoomOccupancy",
    "IsSelected",
    "RatePlans",
    "Allocation",
    "Duration",
    "CloseOut"
})
public class PropertyRoomType {

    @JsonProperty("_id")
    private String id;
    @JsonProperty("Name")
    private Object name;
    @JsonProperty("RoomType")
    private RoomType roomType;
    @JsonProperty("RoomView")
    private RoomView roomView;
    @JsonProperty("RoomClass")
    private Object roomClass;
    @JsonProperty("Children")
    private Object children;
    @JsonProperty("Youth")
    private Object youth;
    @JsonProperty("Infant")
    private Object infant;
    @JsonProperty("AutoUpgradeChildToAdult")
    private Boolean autoUpgradeChildToAdult;
    @JsonProperty("ChildOccupancyOnlyAllowed")
    private Boolean childOccupancyOnlyAllowed;
    @JsonProperty("InfantsCountTowardOccupancy")
    private Boolean infantsCountTowardOccupancy;
    @JsonProperty("YouthCountAsAdults")
    private Boolean youthCountAsAdults;
    @JsonProperty("BedType")
    private Object bedType;
    @JsonProperty("ExtraBedType")
    private Object extraBedType;
    @JsonProperty("RoomOccupancy")
    private RoomOccupancy roomOccupancy;
    @JsonProperty("IsSelected")
    private Boolean isSelected;
    @JsonProperty("RatePlans")
    private Object ratePlans;
    @JsonProperty("Allocation")
    private Object allocation;
    @JsonProperty("Duration")
    private Object duration;
    @JsonProperty("CloseOut")
    private Object closeOut;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("_id")
    public String getId() {
        return id;
    }

    @JsonProperty("_id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("Name")
    public Object getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(Object name) {
        this.name = name;
    }

    @JsonProperty("RoomType")
    public RoomType getRoomType() {
        return roomType;
    }

    @JsonProperty("RoomType")
    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @JsonProperty("RoomView")
    public RoomView getRoomView() {
        return roomView;
    }

    @JsonProperty("RoomView")
    public void setRoomView(RoomView roomView) {
        this.roomView = roomView;
    }

    @JsonProperty("RoomClass")
    public Object getRoomClass() {
        return roomClass;
    }

    @JsonProperty("RoomClass")
    public void setRoomClass(Object roomClass) {
        this.roomClass = roomClass;
    }

    @JsonProperty("Children")
    public Object getChildren() {
        return children;
    }

    @JsonProperty("Children")
    public void setChildren(Object children) {
        this.children = children;
    }

    @JsonProperty("Youth")
    public Object getYouth() {
        return youth;
    }

    @JsonProperty("Youth")
    public void setYouth(Object youth) {
        this.youth = youth;
    }

    @JsonProperty("Infant")
    public Object getInfant() {
        return infant;
    }

    @JsonProperty("Infant")
    public void setInfant(Object infant) {
        this.infant = infant;
    }

    @JsonProperty("AutoUpgradeChildToAdult")
    public Boolean getAutoUpgradeChildToAdult() {
        return autoUpgradeChildToAdult;
    }

    @JsonProperty("AutoUpgradeChildToAdult")
    public void setAutoUpgradeChildToAdult(Boolean autoUpgradeChildToAdult) {
        this.autoUpgradeChildToAdult = autoUpgradeChildToAdult;
    }

    @JsonProperty("ChildOccupancyOnlyAllowed")
    public Boolean getChildOccupancyOnlyAllowed() {
        return childOccupancyOnlyAllowed;
    }

    @JsonProperty("ChildOccupancyOnlyAllowed")
    public void setChildOccupancyOnlyAllowed(Boolean childOccupancyOnlyAllowed) {
        this.childOccupancyOnlyAllowed = childOccupancyOnlyAllowed;
    }

    @JsonProperty("InfantsCountTowardOccupancy")
    public Boolean getInfantsCountTowardOccupancy() {
        return infantsCountTowardOccupancy;
    }

    @JsonProperty("InfantsCountTowardOccupancy")
    public void setInfantsCountTowardOccupancy(Boolean infantsCountTowardOccupancy) {
        this.infantsCountTowardOccupancy = infantsCountTowardOccupancy;
    }

    @JsonProperty("YouthCountAsAdults")
    public Boolean getYouthCountAsAdults() {
        return youthCountAsAdults;
    }

    @JsonProperty("YouthCountAsAdults")
    public void setYouthCountAsAdults(Boolean youthCountAsAdults) {
        this.youthCountAsAdults = youthCountAsAdults;
    }

    @JsonProperty("BedType")
    public Object getBedType() {
        return bedType;
    }

    @JsonProperty("BedType")
    public void setBedType(Object bedType) {
        this.bedType = bedType;
    }

    @JsonProperty("ExtraBedType")
    public Object getExtraBedType() {
        return extraBedType;
    }

    @JsonProperty("ExtraBedType")
    public void setExtraBedType(Object extraBedType) {
        this.extraBedType = extraBedType;
    }

    @JsonProperty("RoomOccupancy")
    public RoomOccupancy getRoomOccupancy() {
        return roomOccupancy;
    }

    @JsonProperty("RoomOccupancy")
    public void setRoomOccupancy(RoomOccupancy roomOccupancy) {
        this.roomOccupancy = roomOccupancy;
    }

    @JsonProperty("IsSelected")
    public Boolean getIsSelected() {
        return isSelected;
    }

    @JsonProperty("IsSelected")
    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

    @JsonProperty("RatePlans")
    public Object getRatePlans() {
        return ratePlans;
    }

    @JsonProperty("RatePlans")
    public void setRatePlans(Object ratePlans) {
        this.ratePlans = ratePlans;
    }

    @JsonProperty("Allocation")
    public Object getAllocation() {
        return allocation;
    }

    @JsonProperty("Allocation")
    public void setAllocation(Object allocation) {
        this.allocation = allocation;
    }

    @JsonProperty("Duration")
    public Object getDuration() {
        return duration;
    }

    @JsonProperty("Duration")
    public void setDuration(Object duration) {
        this.duration = duration;
    }

    @JsonProperty("CloseOut")
    public Object getCloseOut() {
        return closeOut;
    }

    @JsonProperty("CloseOut")
    public void setCloseOut(Object closeOut) {
        this.closeOut = closeOut;
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
