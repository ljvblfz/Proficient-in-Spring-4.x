/**
 * Copyright：中软海晟信息科技有限公司 版权所有 违者必究 2015 
 */
package com.smart;

public class PlaceOfBirth {
    private String city;
    private String country;
    public PlaceOfBirth(String city) {
        this.city=city;
    }

    public PlaceOfBirth( String country,String city) {
        this(city);
        this.country = country;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String s) {
        this.city = s;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}
