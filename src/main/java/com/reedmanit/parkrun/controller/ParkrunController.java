/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reedmanit.parkrun.controller;

import com.reedmanit.parkrun.data.Location;
import com.reedmanit.parkrun.util.LocationCache;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author paul
 */
@ManagedBean
@Named(value = "parkrunController")
@RequestScoped
public class ParkrunController {

    /**
     * Creates a new instance of ParkrunController
     */
    private List<Location> parkrunLocations;
    private List<Location> filteredParkrunLocations;

    public ParkrunController() {
    }

    @PostConstruct
    public void init() {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        LocationCache theCache = (LocationCache) servletContext.getAttribute("cache");
        parkrunLocations = new ArrayList<Location>();
        ConcurrentHashMap<String, Location> Map = LocationCache.getLocationCache();
        for (Map.Entry<String, Location> entry : Map.entrySet()) {
            Location l = entry.getValue();
            getParkrunLocations().add(l);
           // System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    /**
     * @return the parkrunLocations
     */
    public List<Location> getParkrunLocations() {
        return parkrunLocations;
    }

    /**
     * @return the filteredParkrunLocations
     */
    public List<Location> getFilteredParkrunLocations() {
        return filteredParkrunLocations;
    }

    /**
     * @param filteredParkrunLocations the filteredParkrunLocations to set
     */
    public void setFilteredParkrunLocations(List<Location> filteredParkrunLocations) {
        this.filteredParkrunLocations = filteredParkrunLocations;
    }

}
