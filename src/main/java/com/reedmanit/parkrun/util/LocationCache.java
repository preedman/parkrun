/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reedmanit.parkrun.util;

import com.reedmanit.parkrun.data.Location;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author paul
 */
public class LocationCache {

    private static ConcurrentHashMap<String, Location> locationCache;

    public LocationCache() throws Exception {
        locationCache = new ConcurrentHashMap<String, Location>();
        
    }
    
    public void loadLocationCache(String dataLocation) throws IOException {
        
        String line = "";
        String cvsSplitBy = ",";
        
        try (BufferedReader br = new BufferedReader(new FileReader(dataLocation))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(cvsSplitBy);
                
                Location l = new Location();
                
                l.setLng(data[0]);  // lng is positive
                l.setLat(data[1]);  // lat is negative
                l.setName(data[2]);
                
                locationCache.put(l.getName(), l);
                

            }

        } catch (IOException e) {
            throw e;
        }
        
    }

}
