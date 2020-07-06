package com.reedmanit.parkrun.dao;

import com.reedmanit.parkrun.util.DataCache;
import com.reedmanit.parkrun.util.ParkRunnerCache;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.context.FacesContext;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

public class LoginDAO {

    private DataSource ds;
    Connection con;
    

    public LoginDAO(Connection aConnection) {
        con = aConnection;

    }
    
    public LoginDAO() {
        
    }
    
    

    public boolean validateUser(String userid, String password) {
        
        ParkRunnerDAO pr = new ParkRunnerDAO();
        return pr.validateParkRunner(userid);

        
    }
}
