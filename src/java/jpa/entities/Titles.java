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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "TITLES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Titles.findAll", query = "SELECT t FROM Titles t"),
    @NamedQuery(name = "Titles.findByIsbn", query = "SELECT t FROM Titles t WHERE t.isbn = :isbn"),
    @NamedQuery(name = "Titles.findByTitle", query = "SELECT t FROM Titles t WHERE t.title = :title"),
    @NamedQuery(name = "Titles.findByEditionnumber", query = "SELECT t FROM Titles t WHERE t.editionnumber = :editionnumber"),
    @NamedQuery(name = "Titles.findByCopyright", query = "SELECT t FROM Titles t WHERE t.copyright = :copyright")})
public class Titles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ISBN")
    private String isbn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EDITIONNUMBER")
    private int editionnumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "COPYRIGHT")
    private String copyright;
    @ManyToMany(mappedBy = "titlesCollection")
    private Collection<Authors> authorsCollection;
    @JoinColumn(name = "PUBLISHERID", referencedColumnName = "PUBLISHERID")
    @ManyToOne(optional = false)
    private Publishers publisherid;

    public Titles() {
    }

    public Titles(String isbn) {
        this.isbn = isbn;
    }

    public Titles(String isbn, String title, int editionnumber, String copyright) {
        this.isbn = isbn;
        this.title = title;
        this.editionnumber = editionnumber;
        this.copyright = copyright;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEditionnumber() {
        return editionnumber;
    }

    public void setEditionnumber(int editionnumber) {
        this.editionnumber = editionnumber;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    @XmlTransient
    public Collection<Authors> getAuthorsCollection() {
        return authorsCollection;
    }

    public void setAuthorsCollection(Collection<Authors> authorsCollection) {
        this.authorsCollection = authorsCollection;
    }

    public Publishers getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(Publishers publisherid) {
        this.publisherid = publisherid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Titles)) {
            return false;
        }
        Titles other = (Titles) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Titles[ isbn=" + isbn + " ]";
    }
    
    
}
