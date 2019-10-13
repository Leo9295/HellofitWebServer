/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidozone.entity.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Mingzhe Liu
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.kidozone.entity.service.FoodCategoryFacadeREST.class);
        resources.add(com.kidozone.entity.service.FoodInfoFacadeREST.class);
        resources.add(com.kidozone.entity.service.SchoolInfoFacadeREST.class);
        resources.add(com.kidozone.entity.service.WasteCategoryFacadeREST.class);
        resources.add(com.kidozone.entity.service.WasteInfoFacadeREST.class);
    }
    
}
