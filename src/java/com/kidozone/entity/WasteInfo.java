/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidozone.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mingzhe Liu
 */
@Entity
@Table(name = "WASTE_INFO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WasteInfo.findAll", query = "SELECT w FROM WasteInfo w")
    , @NamedQuery(name = "WasteInfo.findById", query = "SELECT w FROM WasteInfo w WHERE w.id = :id")
    , @NamedQuery(name = "WasteInfo.findByWastename", query = "SELECT w FROM WasteInfo w WHERE w.wastename = :wastename")})
public class WasteInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "WASTENAME")
    private String wastename;
    @Size(max = 500)
    @Column(name = "WASTEIMAGEPATH")
    private String wasteimagepath;
    @JoinColumn(name = "WASTECATEGORY", referencedColumnName = "ID")
    @ManyToOne
    private WasteCategory wastecategory;

    public WasteInfo() {
    }

    public WasteInfo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWastename() {
        return wastename;
    }

    public void setWastename(String wastename) {
        this.wastename = wastename;
    }

    public WasteCategory getWastecategory() {
        return wastecategory;
    }

    public void setWastecategory(WasteCategory wastecategory) {
        this.wastecategory = wastecategory;
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
        if (!(object instanceof WasteInfo)) {
            return false;
        }
        WasteInfo other = (WasteInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kidozone.entity.WasteInfo[ id=" + id + " ]";
    }

    public String getWasteimagepath() {
        return wasteimagepath;
    }

    public void setWasteimagepath(String wasteimagepath) {
        this.wasteimagepath = wasteimagepath;
    }
    
}
