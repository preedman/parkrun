/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reedmanit.parkrun.util;

import com.reedmanit.parkrun.data.Location;
import com.reedmanit.parkrun.data.ParkRunner;
import static com.reedmanit.parkrun.util.LocationCache.getLocationCache;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author paul
 */
public class ParkRunnerCache implements DataCache {
    
    private static ConcurrentHashMap<String, ParkRunner> parkrunnerCache;
    
    public ParkRunnerCache() {
        parkrunnerCache = new ConcurrentHashMap<String, ParkRunner>();
    }
    
    public void loadCache(String dataLocation) throws IOException {
        
        String line = "";
        String cvsSplitBy = ",";
        
        try (BufferedReader br = new BufferedReader(new FileReader(dataLocation))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(cvsSplitBy);
                
                ParkRunner pr = new ParkRunner();
                
                pr.setID(data[0]);
                pr.setPassword(data[1]);
                
                getParkrunnerCache().put(pr.getID(), pr);
                
                
                

            }

        } catch (IOException e) {
            throw e;
        }
        
    }

    /**
     * @return the parkrunnerCache
     */
    public static ConcurrentHashMap<String, ParkRunner> getParkrunnerCache() {
        return parkrunnerCache;
    }
}
