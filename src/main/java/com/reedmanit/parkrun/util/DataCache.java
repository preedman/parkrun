/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reedmanit.parkrun.util;

import java.io.IOException;

/**
 *
 * @author paul
 */
public interface DataCache {
    
    public void loadCache(String dataLocation) throws IOException;
    
}
