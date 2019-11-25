/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reedmanit.parkrun.util;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author paul
 */
public class Connection {

    private DataSource ds;
    private static java.sql.Connection con;
    private static Connection instance = null;

    private Connection() {

    }

    // static method to create instance of Singleton class 
    public static Connection getInstance() {
        if (instance == null) {
            instance = new Connection();
        }

        return instance;
    }

    public void createDBConnection() throws SQLException {

        try {
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("jdbc/austparkrun");
            if (ds == null) {

                throw new SQLException("Can't get data source");
            }
            // get database connection
            con = ds.getConnection();
            if (con == null) {
                throw new SQLException("Can't get database connection");
            }

        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    public java.sql.Connection getDBConnection() {
        return con;
    }

    public void close() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
