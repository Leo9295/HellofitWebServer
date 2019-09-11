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
@Table(name = "FOOD_CATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FoodCategory.findAll", query = "SELECT f FROM FoodCategory f")
    , @NamedQuery(name = "FoodCategory.findById", query = "SELECT f FROM FoodCategory f WHERE f.id = :id")
    , @NamedQuery(name = "FoodCategory.findByFoodcategoryname", query = "SELECT f FROM FoodCategory f WHERE f.foodcategoryname = :foodcategoryname")})
public class FoodCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 20)
    @Column(name = "FOODCATEGORYNAME")
    private String foodcategoryname;
    @OneToMany(mappedBy = "foodcategory")
    private Collection<FoodInfo> foodInfoCollection;

    public FoodCategory() {
    }

    public FoodCategory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodcategoryname() {
        return foodcategoryname;
    }

    public void setFoodcategoryname(String foodcategoryname) {
        this.foodcategoryname = foodcategoryname;
    }

    @XmlTransient
    public Collection<FoodInfo> getFoodInfoCollection() {
        return foodInfoCollection;
    }

    public void setFoodInfoCollection(Collection<FoodInfo> foodInfoCollection) {
        this.foodInfoCollection = foodInfoCollection;
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
        if (!(object instanceof FoodCategory)) {
            return false;
        }
        FoodCategory other = (FoodCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kidozone.entity.FoodCategory[ id=" + id + " ]";
    }
    
}
