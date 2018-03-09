
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
    "ContractHeaderNotes",
    "RateNotes",
    "InventoryNotes",
    "BoardBasisNotes",
    "SupplementsNotes",
    "SpecialOffersNotes",
    "DurationsNotes",
    "ContributionsNotes",
    "CloseOutsNotes",
    "TaxesNotes"
})
public class Notes {

    @JsonProperty("ContractHeaderNotes")
    private ContractHeaderNotes contractHeaderNotes;
    @JsonProperty("RateNotes")
    private RateNotes rateNotes;
    @JsonProperty("InventoryNotes")
    private InventoryNotes inventoryNotes;
    @JsonProperty("BoardBasisNotes")
    private BoardBasisNotes boardBasisNotes;
    @JsonProperty("SupplementsNotes")
    private SupplementsNotes supplementsNotes;
    @JsonProperty("SpecialOffersNotes")
    private SpecialOffersNotes specialOffersNotes;
    @JsonProperty("DurationsNotes")
    private DurationsNotes durationsNotes;
    @JsonProperty("ContributionsNotes")
    private ContributionsNotes contributionsNotes;
    @JsonProperty("CloseOutsNotes")
    private CloseOutsNotes closeOutsNotes;
    @JsonProperty("TaxesNotes")
    private TaxesNotes taxesNotes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ContractHeaderNotes")
    public ContractHeaderNotes getContractHeaderNotes() {
        return contractHeaderNotes;
    }

    @JsonProperty("ContractHeaderNotes")
    public void setContractHeaderNotes(ContractHeaderNotes contractHeaderNotes) {
        this.contractHeaderNotes = contractHeaderNotes;
    }

    @JsonProperty("RateNotes")
    public RateNotes getRateNotes() {
        return rateNotes;
    }

    @JsonProperty("RateNotes")
    public void setRateNotes(RateNotes rateNotes) {
        this.rateNotes = rateNotes;
    }

    @JsonProperty("InventoryNotes")
    public InventoryNotes getInventoryNotes() {
        return inventoryNotes;
    }

    @JsonProperty("InventoryNotes")
    public void setInventoryNotes(InventoryNotes inventoryNotes) {
        this.inventoryNotes = inventoryNotes;
    }

    @JsonProperty("BoardBasisNotes")
    public BoardBasisNotes getBoardBasisNotes() {
        return boardBasisNotes;
    }

    @JsonProperty("BoardBasisNotes")
    public void setBoardBasisNotes(BoardBasisNotes boardBasisNotes) {
        this.boardBasisNotes = boardBasisNotes;
    }

    @JsonProperty("SupplementsNotes")
    public SupplementsNotes getSupplementsNotes() {
        return supplementsNotes;
    }

    @JsonProperty("SupplementsNotes")
    public void setSupplementsNotes(SupplementsNotes supplementsNotes) {
        this.supplementsNotes = supplementsNotes;
    }

    @JsonProperty("SpecialOffersNotes")
    public SpecialOffersNotes getSpecialOffersNotes() {
        return specialOffersNotes;
    }

    @JsonProperty("SpecialOffersNotes")
    public void setSpecialOffersNotes(SpecialOffersNotes specialOffersNotes) {
        this.specialOffersNotes = specialOffersNotes;
    }

    @JsonProperty("DurationsNotes")
    public DurationsNotes getDurationsNotes() {
        return durationsNotes;
    }

    @JsonProperty("DurationsNotes")
    public void setDurationsNotes(DurationsNotes durationsNotes) {
        this.durationsNotes = durationsNotes;
    }

    @JsonProperty("ContributionsNotes")
    public ContributionsNotes getContributionsNotes() {
        return contributionsNotes;
    }

    @JsonProperty("ContributionsNotes")
    public void setContributionsNotes(ContributionsNotes contributionsNotes) {
        this.contributionsNotes = contributionsNotes;
    }

    @JsonProperty("CloseOutsNotes")
    public CloseOutsNotes getCloseOutsNotes() {
        return closeOutsNotes;
    }

    @JsonProperty("CloseOutsNotes")
    public void setCloseOutsNotes(CloseOutsNotes closeOutsNotes) {
        this.closeOutsNotes = closeOutsNotes;
    }

    @JsonProperty("TaxesNotes")
    public TaxesNotes getTaxesNotes() {
        return taxesNotes;
    }

    @JsonProperty("TaxesNotes")
    public void setTaxesNotes(TaxesNotes taxesNotes) {
        this.taxesNotes = taxesNotes;
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
