package com.sys.org.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sys.org.spring.idclass.PropertyPK;
import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.math.BigDecimal;

@Table("property")
public class Property {
    @PrimaryKey
    private PropertyPK propertyPK;
    private Integer cutoff_time;
    private String name;
    private BigDecimal star_rating;
    private Boolean status;
    private String timezone_id;
    @JsonIgnore
    @Transient
    private boolean isSync;

    public boolean isSync() {
        return isSync;
    }

    public void setSync(boolean sync) {
        isSync = sync;
    }

    public Integer getCutoff_time() {
        return cutoff_time;
    }

    public void setCutoff_time(Integer cutoff_time) {
        this.cutoff_time = cutoff_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(BigDecimal star_rating) {
        this.star_rating = star_rating;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTimezone_id() {
        return timezone_id;
    }

    public void setTimezone_id(String timezone_id) {
        this.timezone_id = timezone_id;
    }

    public PropertyPK getPropertyPK() {
        return propertyPK;
    }

    public void setPropertyPK(PropertyPK propertyPK) {
        this.propertyPK = propertyPK;
    }

    @Override
    public String toString() {
        return "Property:{" +
                "propertyPK=" + propertyPK +
                ", cutoff_time=" + cutoff_time +
                ", name='" + name + '\'' +
                ", star_rating=" + star_rating +
                ", status=" + status +
                ", timezone_id='" + timezone_id + '\'' +
                '}';
    }
}
