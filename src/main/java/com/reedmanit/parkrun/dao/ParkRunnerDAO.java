/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reedmanit.parkrun.dao;

import com.reedmanit.parkrun.util.ParkRunnerCache;
import javax.servlet.ServletContext;

/**
 *
 * @author paul
 */
public class ParkRunnerDAO {
    
       
      
    public ParkRunnerDAO() {
        
    }
    
   
    public boolean validateParkRunner(String ID) {
        
        return ParkRunnerCache.getParkrunnerCache().containsKey(ID);
        
    }
    
    
    
}
