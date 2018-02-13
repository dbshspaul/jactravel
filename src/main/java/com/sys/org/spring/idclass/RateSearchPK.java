package com.sys.org.spring.idclass;

import com.datastax.driver.core.LocalDate;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import java.util.Objects;

public class RateSearchPK {
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Integer rate_plan_id;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Integer board_basis_id;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Byte adults;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Byte infants;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private String child_occupancy_key;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private String youth_occupancy_key;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private LocalDate stay_date;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private String tenant_id;

    public Integer getRate_plan_id() {
        return rate_plan_id;
    }

    public void setRate_plan_id(Integer rate_plan_id) {
        this.rate_plan_id = rate_plan_id;
    }

    public Integer getBoard_basis_id() {
        return board_basis_id;
    }

    public void setBoard_basis_id(Integer board_basis_id) {
        this.board_basis_id = board_basis_id;
    }

    public Byte getAdults() {
        return adults;
    }

    public void setAdults(Byte adults) {
        this.adults = adults;
    }

    public Byte getInfants() {
        return infants;
    }

    public void setInfants(Byte infants) {
        this.infants = infants;
    }

    public String getChild_occupancy_key() {
        return child_occupancy_key;
    }

    public void setChild_occupancy_key(String child_occupancy_key) {
        this.child_occupancy_key = child_occupancy_key;
    }

    public String getYouth_occupancy_key() {
        return youth_occupancy_key;
    }

    public void setYouth_occupancy_key(String youth_occupancy_key) {
        this.youth_occupancy_key = youth_occupancy_key;
    }

    public LocalDate getStay_date() {
        return stay_date;
    }

    public void setStay_date(LocalDate stay_date) {
        this.stay_date = stay_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RateSearchPK)) return false;
        RateSearchPK that = (RateSearchPK) o;
        return Objects.equals(getRate_plan_id(), that.getRate_plan_id()) &&
                Objects.equals(getBoard_basis_id(), that.getBoard_basis_id()) &&
                Objects.equals(getAdults(), that.getAdults()) &&
                Objects.equals(getInfants(), that.getInfants()) &&
                Objects.equals(getChild_occupancy_key(), that.getChild_occupancy_key()) &&
                Objects.equals(getYouth_occupancy_key(), that.getYouth_occupancy_key()) &&
                Objects.equals(getStay_date(), that.getStay_date());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getRate_plan_id(), getBoard_basis_id(), getAdults(), getInfants(), getChild_occupancy_key(), getYouth_occupancy_key(), getStay_date());
    }

    @Override
    public String toString() {
        return "RateSearchPK:{" +
                "rate_plan_id=" + rate_plan_id +
                ", board_basis_id=" + board_basis_id +
                ", adults=" + adults +
                ", infants=" + infants +
                ", child_occupancy_key='" + child_occupancy_key + '\'' +
                ", youth_occupancy_key='" + youth_occupancy_key + '\'' +
                ", stay_date=" + stay_date +
                '}';
    }

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }
}
