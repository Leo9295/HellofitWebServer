/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidozone.entity.service;

import com.kidozone.entity.WasteInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author leonard
 */
@Stateless
@Path("com.kidozone.entity.wasteinfo")
public class WasteInfoFacadeREST extends AbstractFacade<WasteInfo> {

    @PersistenceContext(unitName = "HellofitWebServerPU")
    private EntityManager em;

    public WasteInfoFacadeREST() {
        super(WasteInfo.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(WasteInfo entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, WasteInfo entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public WasteInfo find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<WasteInfo> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<WasteInfo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @GET
    @Path("findWasteRandomly")
    @Produces(MediaType.APPLICATION_JSON)
    public List<WasteInfo> findWasteRandomly() {
        List<WasteInfo> list = new ArrayList<WasteInfo>();
        List<WasteInfo> tempList = this.findAll();
        while (list.size() < 10) {
            int index = getRandomNum(tempList.size());
            if (!list.contains(tempList.get(index))) {
                list.add(tempList.get(index));
            }
        }
        return list;
    }
    
    private int getRandomNum(int max) {
        Random r = new Random();
        return r.nextInt(max);
    }
    
}
