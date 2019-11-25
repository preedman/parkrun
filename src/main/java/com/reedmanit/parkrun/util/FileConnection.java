/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reedmanit.parkrun.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author paul
 */
public class FileConnection {

    private static FileConnection instance = null;
    private String dataLocation;

    private FileConnection() {

    }

    // static method to create instance of Singleton class 
    public static FileConnection getInstance() {
        if (instance == null) {
            instance = new FileConnection();
        }

        return instance;
    }

    public void connectToData() throws NamingException {

        Context context = new InitialContext();
        Context envContext = (Context) context.lookup("java:/comp/env");
        
        dataLocation = (String) envContext.lookup("parkrundata");
        
        System.out.println("Data Location " + dataLocation);
        

    }
    
    public String getDataLocation() {
        return dataLocation;
    }

}
