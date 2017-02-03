/**
 * Copyright：中软海晟信息科技有限公司 版权所有 违者必究 2015 
 */
package com.smart.spel;

import com.smart.PlaceOfBirth;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author : linkx(topiter@163.com)
 * @date: 2015/8/1
 */
public class Inventor {
    private String name;
    private String nationality;
    private String[] inventions;
    private Date birthdate;
    private PlaceOfBirth placeOfBirth;


    public Inventor(String name, String nationality) {
        GregorianCalendar c= new GregorianCalendar();
        this.name = name;
        this.nationality = nationality;
        this.birthdate = c.getTime();
    }
    public Inventor(String name, Date birthdate, String nationality) {
        this.name = name;
        this.nationality = nationality;
        this.birthdate = birthdate;
    }
    public Inventor() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public Date getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    public PlaceOfBirth getPlaceOfBirth() {
        return placeOfBirth;
    }
    public void setPlaceOfBirth(PlaceOfBirth placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }
    public void setInventions(String[] inventions) {
        this.inventions = inventions;
    }
    public String[] getInventions() {
        return inventions;
    }
}
