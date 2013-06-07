package com.ironman.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder={"county","city","state","country","zipCode"})
public class Location {

    private String county;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    
    @SuppressWarnings("unused")
    private Location(){
        
    }
    
    public Location(String county, String city, String state, String country, String zipCode) {
        this.county = county;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }
    
    public Location(String city, String state, String country) {
        this("", city, state, country, "");
    }
    
    public String getCounty() {
        return county;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getCountry() {
        return country;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setCounty(String county) {
        this.county = county;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Location [county=");
        builder.append(county);
        builder.append(", city=");
        builder.append(city);
        builder.append(", state=");
        builder.append(state);
        builder.append(", country=");
        builder.append(country);
        builder.append(", zipCode=");
        builder.append(zipCode);
        builder.append("]");
        return builder.toString();
    }
    
    
    
}
