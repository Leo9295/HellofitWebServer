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
@Table(name = "SCHOOL_INFO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SchoolInfo.findAll", query = "SELECT s FROM SchoolInfo s")
    , @NamedQuery(name = "SchoolInfo.findById", query = "SELECT s FROM SchoolInfo s WHERE s.id = :id")
    , @NamedQuery(name = "SchoolInfo.findBySchoolname", query = "SELECT s FROM SchoolInfo s WHERE s.schoolname = :schoolname")
    , @NamedQuery(name = "SchoolInfo.findBySchoolsuburb", query = "SELECT s FROM SchoolInfo s WHERE s.schoolsuburb = :schoolsuburb")
    , @NamedQuery(name = "SchoolInfo.findBySchoollatitude", query = "SELECT s FROM SchoolInfo s WHERE s.schoollatitude = :schoollatitude")
    , @NamedQuery(name = "SchoolInfo.findBySchoollongitude", query = "SELECT s FROM SchoolInfo s WHERE s.schoollongitude = :schoollongitude")})
public class SchoolInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 200)
    @Column(name = "SCHOOLNAME")
    private String schoolname;
    @Size(max = 50)
    @Column(name = "SCHOOLSUBURB")
    private String schoolsuburb;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SCHOOLLATITUDE")
    private Double schoollatitude;
    @Column(name = "SCHOOLLONGITUDE")
    private Double schoollongitude;

    public SchoolInfo() {
    }

    public SchoolInfo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getSchoolsuburb() {
        return schoolsuburb;
    }

    public void setSchoolsuburb(String schoolsuburb) {
        this.schoolsuburb = schoolsuburb;
    }

    public Double getSchoollatitude() {
        return schoollatitude;
    }

    public void setSchoollatitude(Double schoollatitude) {
        this.schoollatitude = schoollatitude;
    }

    public Double getSchoollongitude() {
        return schoollongitude;
    }

    public void setSchoollongitude(Double schoollongitude) {
        this.schoollongitude = schoollongitude;
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
        if (!(object instanceof SchoolInfo)) {
            return false;
        }
        SchoolInfo other = (SchoolInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kidozone.entity.SchoolInfo[ id=" + id + " ]";
    }
    
}
