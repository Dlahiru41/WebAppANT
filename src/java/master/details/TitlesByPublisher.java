package master.details;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.sql.rowset.CachedRowSet;
import jsf.PublishersController;

@ManagedBean(name = "titlesByPublisher")
public class TitlesByPublisher {

//    @Resource(name = "jdbc/books")
//    DataSource dataSource;

    // instance variables
    private String isbn;
    private String title;
    private int editionnumber;
    private String copyright;
    private String publishername;

    public TitlesByPublisher() {
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getEditionnumber() {
        return editionnumber;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getPublishername() {
        return publishername;
    }

    public int getPublisherid() {
        //this is to get the running intstance of the session bean PublishersController object
        ExternalContext tmpEC;
        Map sMap;
        tmpEC = FacesContext.getCurrentInstance().getExternalContext();
        sMap = tmpEC.getSessionMap();
        PublishersController currentPublishersControllerInstance = (PublishersController) sMap.get("publishersController");

        //get the selected publisherID from the "master" page List.xhtml of the publishers
        return currentPublishersControllerInstance.getSelected().getPublisherid();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    //this is to get the titles by a publisher ID
    // return a ResultSet of entities
    // allow the server to inject the DataSource
    public ResultSet getTitlesbyPublisher() throws SQLException {

        String URL = "jdbc:derby://localhost:1527/books";
        String USERNAME = "deitel";
        String PASSWORD = "deitel";
        Connection connection = null; // manages connection 

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String queryString = "SELECT TITLES.ISBN, TITLES.TITLE, TITLES.EDITIONNUMBER, TITLES.COPYRIGHT, PUBLISHERS.PUBLISHERNAME FROM TITLES INNER JOIN PUBLISHERS ON TITLES.PUBLISHERID = PUBLISHERS.PUBLISHERID WHERE TITLES.PUBLISHERID = " + this.getPublisherid();

            PreparedStatement getTitlesbyPublisher = connection.prepareStatement(queryString);

            CachedRowSet rowSet = new com.sun.rowset.CachedRowSetImpl();
            rowSet.populate(getTitlesbyPublisher.executeQuery());
            return rowSet;

        } // end try
        finally {
            connection.close(); // return this connection to pool
        } // end finally
    } // end method 

    public Boolean rowSetNotEmpty() throws SQLException {
        return getTitlesbyPublisher().first();
    }

}
