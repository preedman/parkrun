/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reedmanit.parkrun.data;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author paul
 */
public class Location {
    
    private String lng;
    private String lat;
    private String name;
    private String coursePage;
    private String googleMap;
    private String url = "https://www.google.com/maps/search/?api=1&query=";
    private String parkrunURL = "https://www.parkrun.com.au/";
    
    public Location() {
        
    }

    /**
     * @return the lng
     */
    public String getLng() {
        return lng;
    }

    /**
     * @param lng the lng to set
     */
    public void setLng(String lng) {
        this.lng = lng;
    }

    /**
     * @return the lat
     */
    public String getLat() {
        return lat;
    }

    /**
     * @param lat the lat to set
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
        setCoursePage(name);
        setGoogleMap();
        this.name = StringUtils.removeEndIgnoreCase(this.name, "parkrun");
    }

    /**
     * @return the coursePage
     */
    public String getCoursePage() {
        return coursePage;
    }

    /**
     * @param coursePage the coursePage to set
     */
    private void setCoursePage(String name) {
        
        this.coursePage = StringUtils.deleteWhitespace(name);
        this.coursePage = StringUtils.removeEndIgnoreCase(this.coursePage, "parkrun");
        this.coursePage = parkrunURL + this.coursePage;
    }

    /**
     * @return the googleMap
     */
    public String getGoogleMap() {
        return googleMap;
    }

    /**
     * @param googleMap the googleMap to set
     */
    private void setGoogleMap() {
        this.googleMap = url + this.lat + "," + this.lng;
        
    }
    
}
