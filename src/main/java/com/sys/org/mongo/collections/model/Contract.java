
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
    "_id",
    "IsActive",
    "VersionId",
    "ContractId",
    "ContractPrefix",
    "PropertyId",
    "ContractStatus",
    "GroundHandlerId",
    "SupplierReference",
    "ChannelTypes",
    "StayFrom",
    "StayTo",
    "BookedFrom",
    "BookedTo",
    "Currency",
    "ChannelManager",
    "ContractType",
    "Reservation",
    "Payment",
    "PropertyRoomTypes",
    "Notes",
    "Supplements",
    "SpecialOffers",
    "ContractTaxes",
    "Contributions",
    "BoardBasisUpgrades",
    "Duration",
    "CloseOut",
    "NoEndDates"
})
public class Contract {

    @JsonProperty("_id")
    private String id;
    @JsonProperty("IsActive")
    private Boolean isActive;
    @JsonProperty("VersionId")
    private String versionId;
    @JsonProperty("ContractId")
    private Integer contractId;
    @JsonProperty("ContractPrefix")
    private String contractPrefix;
    @JsonProperty("PropertyId")
    private String propertyId;
    @JsonProperty("ContractStatus")
    private Integer contractStatus;
    @JsonProperty("GroundHandlerId")
    private String groundHandlerId;
    @JsonProperty("SupplierReference")
    private Object supplierReference;
    @JsonProperty("ChannelTypes")
    private ChannelTypes channelTypes;
    @JsonProperty("StayFrom")
    private String stayFrom;
    @JsonProperty("StayTo")
    private String stayTo;
    @JsonProperty("BookedFrom")
    private String bookedFrom;
    @JsonProperty("BookedTo")
    private String bookedTo;
    @JsonProperty("Currency")
    private Currency currency;
    @JsonProperty("ChannelManager")
    private Object channelManager;
    @JsonProperty("ContractType")
    private Integer contractType;
    @JsonProperty("Reservation")
    private Reservation reservation;
    @JsonProperty("Payment")
    private Payment payment;
    @JsonProperty("PropertyRoomTypes")
    private List<PropertyRoomType> propertyRoomTypes = null;
    @JsonProperty("Notes")
    private Notes notes;
    @JsonProperty("Supplements")
    private List<Object> supplements = null;
    @JsonProperty("SpecialOffers")
    private List<Object> specialOffers = null;
    @JsonProperty("ContractTaxes")
    private List<Object> contractTaxes = null;
    @JsonProperty("Contributions")
    private Contributions contributions;
    @JsonProperty("BoardBasisUpgrades")
    private List<Object> boardBasisUpgrades = null;
    @JsonProperty("Duration")
    private Object duration;
    @JsonProperty("CloseOut")
    private Object closeOut;
    @JsonProperty("NoEndDates")
    private Boolean noEndDates;
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

    @JsonProperty("IsActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("IsActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("VersionId")
    public String getVersionId() {
        return versionId;
    }

    @JsonProperty("VersionId")
    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    @JsonProperty("ContractId")
    public Integer getContractId() {
        return contractId;
    }

    @JsonProperty("ContractId")
    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    @JsonProperty("ContractPrefix")
    public String getContractPrefix() {
        return contractPrefix;
    }

    @JsonProperty("ContractPrefix")
    public void setContractPrefix(String contractPrefix) {
        this.contractPrefix = contractPrefix;
    }

    @JsonProperty("PropertyId")
    public String getPropertyId() {
        return propertyId;
    }

    @JsonProperty("PropertyId")
    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    @JsonProperty("ContractStatus")
    public Integer getContractStatus() {
        return contractStatus;
    }

    @JsonProperty("ContractStatus")
    public void setContractStatus(Integer contractStatus) {
        this.contractStatus = contractStatus;
    }

    @JsonProperty("GroundHandlerId")
    public String getGroundHandlerId() {
        return groundHandlerId;
    }

    @JsonProperty("GroundHandlerId")
    public void setGroundHandlerId(String groundHandlerId) {
        this.groundHandlerId = groundHandlerId;
    }

    @JsonProperty("SupplierReference")
    public Object getSupplierReference() {
        return supplierReference;
    }

    @JsonProperty("SupplierReference")
    public void setSupplierReference(Object supplierReference) {
        this.supplierReference = supplierReference;
    }

    @JsonProperty("ChannelTypes")
    public ChannelTypes getChannelTypes() {
        return channelTypes;
    }

    @JsonProperty("ChannelTypes")
    public void setChannelTypes(ChannelTypes channelTypes) {
        this.channelTypes = channelTypes;
    }

    @JsonProperty("StayFrom")
    public String getStayFrom() {
        return stayFrom;
    }

    @JsonProperty("StayFrom")
    public void setStayFrom(String stayFrom) {
        this.stayFrom = stayFrom;
    }

    @JsonProperty("StayTo")
    public String getStayTo() {
        return stayTo;
    }

    @JsonProperty("StayTo")
    public void setStayTo(String stayTo) {
        this.stayTo = stayTo;
    }

    @JsonProperty("BookedFrom")
    public String getBookedFrom() {
        return bookedFrom;
    }

    @JsonProperty("BookedFrom")
    public void setBookedFrom(String bookedFrom) {
        this.bookedFrom = bookedFrom;
    }

    @JsonProperty("BookedTo")
    public String getBookedTo() {
        return bookedTo;
    }

    @JsonProperty("BookedTo")
    public void setBookedTo(String bookedTo) {
        this.bookedTo = bookedTo;
    }

    @JsonProperty("Currency")
    public Currency getCurrency() {
        return currency;
    }

    @JsonProperty("Currency")
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @JsonProperty("ChannelManager")
    public Object getChannelManager() {
        return channelManager;
    }

    @JsonProperty("ChannelManager")
    public void setChannelManager(Object channelManager) {
        this.channelManager = channelManager;
    }

    @JsonProperty("ContractType")
    public Integer getContractType() {
        return contractType;
    }

    @JsonProperty("ContractType")
    public void setContractType(Integer contractType) {
        this.contractType = contractType;
    }

    @JsonProperty("Reservation")
    public Reservation getReservation() {
        return reservation;
    }

    @JsonProperty("Reservation")
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @JsonProperty("Payment")
    public Payment getPayment() {
        return payment;
    }

    @JsonProperty("Payment")
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @JsonProperty("PropertyRoomTypes")
    public List<PropertyRoomType> getPropertyRoomTypes() {
        return propertyRoomTypes;
    }

    @JsonProperty("PropertyRoomTypes")
    public void setPropertyRoomTypes(List<PropertyRoomType> propertyRoomTypes) {
        this.propertyRoomTypes = propertyRoomTypes;
    }

    @JsonProperty("Notes")
    public Notes getNotes() {
        return notes;
    }

    @JsonProperty("Notes")
    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    @JsonProperty("Supplements")
    public List<Object> getSupplements() {
        return supplements;
    }

    @JsonProperty("Supplements")
    public void setSupplements(List<Object> supplements) {
        this.supplements = supplements;
    }

    @JsonProperty("SpecialOffers")
    public List<Object> getSpecialOffers() {
        return specialOffers;
    }

    @JsonProperty("SpecialOffers")
    public void setSpecialOffers(List<Object> specialOffers) {
        this.specialOffers = specialOffers;
    }

    @JsonProperty("ContractTaxes")
    public List<Object> getContractTaxes() {
        return contractTaxes;
    }

    @JsonProperty("ContractTaxes")
    public void setContractTaxes(List<Object> contractTaxes) {
        this.contractTaxes = contractTaxes;
    }

    @JsonProperty("Contributions")
    public Contributions getContributions() {
        return contributions;
    }

    @JsonProperty("Contributions")
    public void setContributions(Contributions contributions) {
        this.contributions = contributions;
    }

    @JsonProperty("BoardBasisUpgrades")
    public List<Object> getBoardBasisUpgrades() {
        return boardBasisUpgrades;
    }

    @JsonProperty("BoardBasisUpgrades")
    public void setBoardBasisUpgrades(List<Object> boardBasisUpgrades) {
        this.boardBasisUpgrades = boardBasisUpgrades;
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

    @JsonProperty("NoEndDates")
    public Boolean getNoEndDates() {
        return noEndDates;
    }

    @JsonProperty("NoEndDates")
    public void setNoEndDates(Boolean noEndDates) {
        this.noEndDates = noEndDates;
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
