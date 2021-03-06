package com.qjs.boot.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "city")
public class City {
    @Id
    @Column(name = "city_id")
    @GeneratedValue(generator = "JDBC")
    private Short cityId;

    private String city;

    @Column(name = "country_id")
    private Short countryId;

    @Column(name = "last_update")
    private Date lastUpdate;

    /**
     * @return city_id
     */
    public Short getCityId() {
        return cityId;
    }

    /**
     * @param cityId
     */
    public void setCityId(Short cityId) {
        this.cityId = cityId;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return country_id
     */
    public Short getCountryId() {
        return countryId;
    }

    /**
     * @param countryId
     */
    public void setCountryId(Short countryId) {
        this.countryId = countryId;
    }

    /**
     * @return last_update
     */
    public Date getLastUpdate() {
        return lastUpdate;
    }

    /**
     * @param lastUpdate
     */
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}