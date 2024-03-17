package com.ajax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author nbuser
 */
public class ComposerData {

    // allow the server to inject the DataSource
    private static final String URL = "jdbc:derby://localhost:1527/books";
    private static final String USERNAME = "deitel";
    private static final String PASSWORD = "deitel";

    private Connection connection = null; // manages connection

    private HashMap composers = new HashMap();

    public HashMap getComposers() {
        return composers;
    }

    //private ResultSet getComposersFromDB() throws SQLException {
    private void getComposersFromDB() throws SQLException {

        try {
            connection
                    = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            // create a PreparedStatement to insert a new entry
            
            String queryString = "SELECT TITLES.ISBN, TITLES.TITLE, TITLES.EDITIONNUMBER, TITLES.COPYRIGHT, PUBLISHERS.PUBLISHERNAME FROM TITLES INNER JOIN PUBLISHERS ON TITLES.PUBLISHERID = PUBLISHERS.PUBLISHERID";
            
            PreparedStatement getComposers = connection.prepareStatement(queryString);

            CachedRowSet rowSet = new com.sun.rowset.CachedRowSetImpl();
            rowSet.populate(getComposers.executeQuery());

            // traversing thru each row to copy database table rows to the hashmap
            while (rowSet.next()) {
                composers.put("" + rowSet.getObject(1), new Composer("" + rowSet.getObject(1), "" + rowSet.getObject(2), "" + rowSet.getObject(3), "" + rowSet.getObject(4), "" + rowSet.getObject(5)));
            } // end while        
        } // end try
        finally {
            connection.close(); // return this connection to pool
        } // end finally

    } // end method getComposers

    public ComposerData() {
        //load the composer data from the database into the hashmap
        try {
            this.getComposersFromDB();
        } catch (SQLException ex) {
            System.out.println("CANNOT CONNECT TO DATABASE!");
        }
        
    }

}
