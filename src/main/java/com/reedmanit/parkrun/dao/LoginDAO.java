package com.reedmanit.parkrun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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

        if ((userid.equalsIgnoreCase("A317005")) && (password.equalsIgnoreCase("pulsar"))) {
            return true;
        } else {
            return false;
        }
    }
}
