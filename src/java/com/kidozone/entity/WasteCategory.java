/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidozone.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leonard
 */
@Entity
@Table(name = "WASTE_CATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WasteCategory.findAll", query = "SELECT w FROM WasteCategory w")
    , @NamedQuery(name = "WasteCategory.findById", query = "SELECT w FROM WasteCategory w WHERE w.id = :id")
    , @NamedQuery(name = "WasteCategory.findByWastecategoryname", query = "SELECT w FROM WasteCategory w WHERE w.wastecategoryname = :wastecategoryname")})
public class WasteCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 20)
    @Column(name = "WASTECATEGORYNAME")
    private String wastecategoryname;
    @OneToMany(mappedBy = "wastecategory")
    private Collection<WasteInfo> wasteInfoCollection;

    public WasteCategory() {
    }

    public WasteCategory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWastecategoryname() {
        return wastecategoryname;
    }

    public void setWastecategoryname(String wastecategoryname) {
        this.wastecategoryname = wastecategoryname;
    }

    @XmlTransient
    public Collection<WasteInfo> getWasteInfoCollection() {
        return wasteInfoCollection;
    }

    public void setWasteInfoCollection(Collection<WasteInfo> wasteInfoCollection) {
        this.wasteInfoCollection = wasteInfoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WasteCategory)) {
            return false;
        }
        WasteCategory other = (WasteCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kidozone.entity.WasteCategory[ id=" + id + " ]";
    }
    
}
