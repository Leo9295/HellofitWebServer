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
 * @author leonard
 */
@Entity
@Table(name = "FOOD_INFO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FoodInfo.findAll", query = "SELECT f FROM FoodInfo f")
    , @NamedQuery(name = "FoodInfo.findById", query = "SELECT f FROM FoodInfo f WHERE f.id = :id")
    , @NamedQuery(name = "FoodInfo.findByFoodname", query = "SELECT f FROM FoodInfo f WHERE f.foodname = :foodname")
    , @NamedQuery(name = "FoodInfo.findByFoodranking", query = "SELECT f FROM FoodInfo f WHERE f.foodranking = :foodranking")})
public class FoodInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 200)
    @Column(name = "FOODNAME")
    private String foodname;
    @Column(name = "FOODRANKING")
    private Integer foodranking;
    @JoinColumn(name = "FOODCATEGORY", referencedColumnName = "ID")
    @ManyToOne
    private FoodCategory foodcategory;

    public FoodInfo() {
    }

    public FoodInfo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public Integer getFoodranking() {
        return foodranking;
    }

    public void setFoodranking(Integer foodranking) {
        this.foodranking = foodranking;
    }

    public FoodCategory getFoodcategory() {
        return foodcategory;
    }

    public void setFoodcategory(FoodCategory foodcategory) {
        this.foodcategory = foodcategory;
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
        if (!(object instanceof FoodInfo)) {
            return false;
        }
        FoodInfo other = (FoodInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kidozone.entity.FoodInfo[ id=" + id + " ]";
    }
    
}
