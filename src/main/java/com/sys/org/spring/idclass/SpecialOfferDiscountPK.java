package com.sys.org.spring.idclass;

import com.datastax.driver.core.LocalDate;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import java.util.Objects;

public class SpecialOfferDiscountPK {
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Integer special_offer_id;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Boolean is_customer;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private LocalDate stay_from;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private LocalDate stay_to;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Byte day_of_week;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private String tenant_id;

    public Integer getSpecial_offer_id() {
        return special_offer_id;
    }

    public void setSpecial_offer_id(Integer special_offer_id) {
        this.special_offer_id = special_offer_id;
    }

    public Boolean getIs_customer() {
        return is_customer;
    }

    public void setIs_customer(Boolean is_customer) {
        this.is_customer = is_customer;
    }

    public LocalDate getStay_from() {
        return stay_from;
    }

    public void setStay_from(LocalDate stay_from) {
        this.stay_from = stay_from;
    }

    public LocalDate getStay_to() {
        return stay_to;
    }

    public void setStay_to(LocalDate stay_to) {
        this.stay_to = stay_to;
    }

    public Byte getDay_of_week() {
        return day_of_week;
    }

    public void setDay_of_week(Byte day_of_week) {
        this.day_of_week = day_of_week;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpecialOfferDiscountPK)) return false;
        SpecialOfferDiscountPK that = (SpecialOfferDiscountPK) o;
        return Objects.equals(getSpecial_offer_id(), that.getSpecial_offer_id()) &&
                Objects.equals(getIs_customer(), that.getIs_customer()) &&
                Objects.equals(getStay_from(), that.getStay_from()) &&
                Objects.equals(getStay_to(), that.getStay_to()) &&
                Objects.equals(getDay_of_week(), that.getDay_of_week());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getSpecial_offer_id(), getIs_customer(), getStay_from(), getStay_to(), getDay_of_week());
    }

    @Override
    public String toString() {
        return "SpecialOfferDiscountPK:{" +
                "special_offer_id=" + special_offer_id +
                ", is_customer=" + is_customer +
                ", stay_from=" + stay_from +
                ", stay_to=" + stay_to +
                ", day_of_week=" + day_of_week +
                '}';
    }

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }
}
