/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Q
 */
@Entity
@Table(name = "PUBLISHERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publishers.findAll", query = "SELECT p FROM Publishers p"),
    @NamedQuery(name = "Publishers.findByPublisherid", query = "SELECT p FROM Publishers p WHERE p.publisherid = :publisherid"),
    @NamedQuery(name = "Publishers.findByPublishername", query = "SELECT p FROM Publishers p WHERE p.publishername = :publishername")})
public class Publishers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PUBLISHERID")
    private Integer publisherid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PUBLISHERNAME")
    private String publishername;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publisherid")
    private Collection<Titles> titlesCollection;

    public Publishers() {
    }

    public Publishers(Integer publisherid) {
        this.publisherid = publisherid;
    }

    public Publishers(Integer publisherid, String publishername) {
        this.publisherid = publisherid;
        this.publishername = publishername;
    }

    public Integer getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(Integer publisherid) {
        this.publisherid = publisherid;
    }

    public String getPublishername() {
        return publishername;
    }

    public void setPublishername(String publishername) {
        this.publishername = publishername;
    }

    @XmlTransient
    public Collection<Titles> getTitlesCollection() {
        return titlesCollection;
    }

    public void setTitlesCollection(Collection<Titles> titlesCollection) {
        this.titlesCollection = titlesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (publisherid != null ? publisherid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publishers)) {
            return false;
        }
        Publishers other = (Publishers) object;
        if ((this.publisherid == null && other.publisherid != null) || (this.publisherid != null && !this.publisherid.equals(other.publisherid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "jpa.entities.Publishers[ publisherid=" + publisherid + " ]";
        return publishername; //to be displayed on the table lookup dropdown
    }
    
}
