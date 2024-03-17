/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Q
 */
@Entity
@Table(name = "AUTHORS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Authors.findAll", query = "SELECT a FROM Authors a"),
    @NamedQuery(name = "Authors.findByAuthorid", query = "SELECT a FROM Authors a WHERE a.authorid = :authorid"),
    @NamedQuery(name = "Authors.findByFirstname", query = "SELECT a FROM Authors a WHERE a.firstname = :firstname"),
    @NamedQuery(name = "Authors.findByLastname", query = "SELECT a FROM Authors a WHERE a.lastname = :lastname")})
public class Authors implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AUTHORID")
    private Integer authorid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LASTNAME")
    private String lastname;
    @JoinTable(name = "AUTHORISBN", joinColumns = {
        @JoinColumn(name = "AUTHORID", referencedColumnName = "AUTHORID")}, inverseJoinColumns = {
        @JoinColumn(name = "ISBN", referencedColumnName = "ISBN")})
    @ManyToMany
    private Collection<Titles> titlesCollection;

    public Authors() {
    }

    public Authors(Integer authorid) {
        this.authorid = authorid;
    }

    public Authors(Integer authorid, String firstname, String lastname) {
        this.authorid = authorid;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Integer getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
        hash += (authorid != null ? authorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Authors)) {
            return false;
        }
        Authors other = (Authors) object;
        if ((this.authorid == null && other.authorid != null) || (this.authorid != null && !this.authorid.equals(other.authorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Authors[ authorid=" + authorid + " ]";
    }
    
}
