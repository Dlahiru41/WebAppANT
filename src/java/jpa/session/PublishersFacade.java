/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Publishers;

/**
 *
 * @author Q
 */
@Stateless
public class PublishersFacade extends AbstractFacade<Publishers> {
    @PersistenceContext(unitName = "WebApplicationBooksDBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PublishersFacade() {
        super(Publishers.class);
    }
    
}
