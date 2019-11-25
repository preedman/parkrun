package com.reedmanit.parkrun.util;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Web application lifecycle listener.
 *
 * @author paul
 */
public class CacheListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        LocationCache theCache = null;
        try {
            theCache = new LocationCache();
            FileConnection.getInstance().connectToData();
            theCache.loadLocationCache(FileConnection.getInstance().getDataLocation());
            
        } catch (Exception ex) {
            Logger.getLogger(CacheListener.class.getName()).log(Level.SEVERE, null, ex);
        }

        sc.setAttribute("cache", theCache);
  //      sc.setAttribute(string, sc);
      //  sc.setAttribute("memory", new Memory());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
