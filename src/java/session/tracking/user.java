/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.tracking;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Q
 */

@ManagedBean(name = "user")
@SessionScoped
public class user {
    private String username = null;
    
    private String currTime = null;
    
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
  

    /**
     * @return the currTime
     */
    public String getCurrTime() {
        java.util.Date myDate = new java.util.Date();
        currTime = "Time now: " + myDate.getHours()+ ":" + myDate.getMinutes() + ":" + myDate.getSeconds();
        return currTime;
    }
}
