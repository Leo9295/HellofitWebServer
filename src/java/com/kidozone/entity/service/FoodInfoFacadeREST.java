/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kidozone.entity.service;

import com.kidozone.entity.FoodInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
 * @author Mingzhe Liu
 */
@Stateless
@Path("com.kidozone.entity.foodinfo")
public class FoodInfoFacadeREST extends AbstractFacade<FoodInfo> {

    @PersistenceContext(unitName = "HellofitWebServerPU")
    private EntityManager em;

    public FoodInfoFacadeREST() {
        super(FoodInfo.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(FoodInfo entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, FoodInfo entity) {
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
    public FoodInfo find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<FoodInfo> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<FoodInfo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("findFoodRandomly")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FoodInfo> findFoodRandomly() {
        List<FoodInfo> list = new ArrayList<FoodInfo>();
        for (int i = 1; i < 8; i++){
            List<FoodInfo> categoryList = new ArrayList<FoodInfo>();
            TypedQuery<FoodInfo> query = em.createQuery("SELECT f FROM FoodInfo f WHERE f.foodcategory.id = " + i, FoodInfo.class);
            List<FoodInfo> tempList = query.getResultList();
            if (tempList.size() >= 3) {
                while (categoryList.size() < 3) {
                    int index = getRandomNum(tempList.size());
                    if (!categoryList.contains(tempList.get(index))) {
                        list.add(tempList.get(index));
                        categoryList.add(tempList.get(index));
                    }
                }
            } else {
                for (FoodInfo f : tempList) {
                    list.add(f);
                }
            }
        }
        return list;
    }
    
    @GET
    @Path("findFoodPic/{foodid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String findFoodPic(@PathParam("foodid") int foodid) {
        try{
            TypedQuery<FoodInfo> tq = em.createQuery("SELECT f FROM FoodInfo f WHERE f.id = :foodid", FoodInfo.class);
            tq.setParameter("foodid", foodid);
            List<FoodInfo> list = tq.getResultList();
            if (!list.isEmpty()) {
                String decodePic = JsonOutputUtil.encodeImage(list.get(0).getFoodimagepath());
                return decodePic;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @GET
    @Path("findLunchboxFood")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FoodInfo> findLunchboxFood() {
        List<FoodInfo> list = new ArrayList<FoodInfo>();
        List<FoodInfo> tempList = this.findAll();
        // Fruit id (1 - 15) -> list index (0 - 14)
        // choose three from them
        for (int i = 0; i < 3;) {
            int index = this.getRandomNum(0, 14);
            if (!list.contains(tempList.get(index))) {
                list.add(tempList.get(index));
                i++;
            }
        }
        // Two ohter anwsers
        for (int i = 0; i < 2;) {
            int index = this.getRandomNum(15, 53);
            if (!list.get(list.size() - 1).equals(tempList.get(index))) {
                list.add(tempList.get(index));
                i++;
            }
        }
        
        // Vege id (16 - 26) -> list index (15 - 25)
        // Choose three from them
        for (int i = 0; i < 3;) {
            int index = this.getRandomNum(15, 25);
            if (!list.contains(tempList.get(index))) {
                list.add(tempList.get(index));
                i++;
            }
        }
        // Two ohter anwsers
        for (int i = 0; i < 2;) {
            int r = this.getRandomNum(2);
            switch (r){
                case 0:
                    int index = this.getRandomNum(0, 14);
                    if (!list.get(list.size() - 1).equals(tempList.get(index))) {
                        list.add(tempList.get(index));
                        i++;
                    }
                    break;
                case 1:
                    int index1 = this.getRandomNum(26, 53);
                    if (!list.get(list.size() - 1).equals(tempList.get(index1))) {
                        list.add(tempList.get(index1));
                        i++;
                    }
                    break;
                default:
                    break;
            }
        }
        // Diary Product id (27 - 31) -> list index (26 - 30)
        // Choose three from them
        for (int i = 0; i < 3;) {
            int index = this.getRandomNum(26, 30);
            if (!list.contains(tempList.get(index))) {
                list.add(tempList.get(index));
                i++;
            }
        }
        // Two ohter anwsers
        for (int i = 0; i < 2;) {
            int r = this.getRandomNum(2);
            switch (r){
                case 0:
                    int index = this.getRandomNum(0, 25);
                    if (!list.get(list.size() - 1).equals(tempList.get(index))) {
                        list.add(tempList.get(index));
                        i++;
                    }
                    break;
                case 1:
                    int index1 = this.getRandomNum(31, 53);
                    if (!list.get(list.size() - 1).equals(tempList.get(index1))) {
                        list.add(tempList.get(index1));
                        i++;
                    }
                    break;
                default:
                    break;
            }
        }
        // Meat id (32 - 37) -> list index (31 - 36)
        // Choose three from them
        for (int i = 0; i < 3;) {
            int index = this.getRandomNum(31, 36);
            if (!list.contains(tempList.get(index))) {
                list.add(tempList.get(index));
                i++;
            }
        }
        // Two ohter anwsers
        for (int i = 0; i < 2;) {
            int r = this.getRandomNum(2);
            switch (r){
                case 0:
                    int index = this.getRandomNum(0, 30);
                    if (!list.get(list.size() - 1).equals(tempList.get(index))) {
                        list.add(tempList.get(index));
                        i++;
                    }
                    break;
                case 1:
                    int index1 = this.getRandomNum(37, 53);
                    if (!list.get(list.size() - 1).equals(tempList.get(index1))) {
                        list.add(tempList.get(index1));
                        i++;
                    }
                    break;
                default:
                    break;
            }
        }
        // Grain id (38 - 43) -> list index (37 - 42)
        // Choose three from them
        for (int i = 0; i < 3;) {
            int index = this.getRandomNum(37, 42);
            if (!list.contains(tempList.get(index))) {
                list.add(tempList.get(index));
                i++;
            }
        }
        // Two ohter anwsers
        for (int i = 0; i < 2;) {
            int r = this.getRandomNum(2);
            switch (r){
                case 0:
                    int index = this.getRandomNum(0, 36);
                    if (!list.get(list.size() - 1).equals(tempList.get(index))) {
                        list.add(tempList.get(index));
                        i++;
                    }
                    break;
                case 1:
                    int index1 = this.getRandomNum(43, 53);
                    if (!list.get(list.size() - 1).equals(tempList.get(index1))) {
                        list.add(tempList.get(index1));
                        i++;
                    }
                    break;
                default:
                    break;
            }
        }
        // Drink id (44 - 45) -> list index (43 - 44)
        // Choose both of them
        list.add(tempList.get(43));
        list.add(tempList.get(44));
        list.add(tempList.get(47));
        // three ohter anwsers
        for (int i = 0; i < 2;) {
            int r = this.getRandomNum(2);
            switch (r){
                case 0:
                    int index = this.getRandomNum(0, 42);
                    if (!list.get(list.size() - 1).equals(tempList.get(index))) {
                        list.add(tempList.get(index));
                        i++;
                    }
                    break;
                case 1:
                    int index1 = this.getRandomNum(48, 53);
                    if (!list.get(list.size() - 1).equals(tempList.get(index1))) {
                        list.add(tempList.get(index1));
                        i++;
                    }
                    break;
                default:
                    break;
            }
        }
        return list;
    }
    
    private int getRandomNum(int max) {
        Random r = new Random();
        return r.nextInt(max);
    }
    
    private int getRandomNum(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
