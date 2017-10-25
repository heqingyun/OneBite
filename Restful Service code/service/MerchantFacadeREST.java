/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import restClient.Merchant;

/**
 *
 * @author qingyunhe
 */
@Stateless
@Path("restclient.merchant")
public class MerchantFacadeREST extends AbstractFacade<Merchant> {
    private static final double EARTH_RADIUS = 6378.137;

    @PersistenceContext(unitName = "OneBite1PU")
    private EntityManager em;

    public MerchantFacadeREST() {
        super(Merchant.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Merchant entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Merchant entity) {
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
    public Merchant find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Merchant> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Merchant> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("getNearbyRestaurant/{myLat}/{myLon}/{distance}")
    @Produces({"application/json"})
    public List<Merchant> getNearbyRestaurant(@PathParam("myLat") double myLat, @PathParam("myLon") double myLon,@PathParam("disctance") double distance){
        double range = 180/Math.PI * distance/6372.797;
        double lngR = range / Math.cos(myLat * Math.PI / 180.0);
        double maxLat = myLat + range;double minLat = myLat - range;
        double maxLng = myLon + lngR;double minLng = myLon - lngR;
        
        return null;
    }
    
    private static double getDistance(double lng1, double lat1, double lng2, double lat2) {
        double lat_1 = (Math.PI / 180) * lat1;
        double lat_2 = (Math.PI / 180) * lat2;

        double lon_1 = (Math.PI / 180) * lng1;
        double lon_2 = (Math.PI / 180) * lng2;

        double d = Math.acos(Math.sin(lat_1) * Math.sin(lat_2) + Math.cos(lat_1) * Math.cos(lat_2) * Math.cos(lon_2 - lon_1)) * EARTH_RADIUS;

        return d;
    }
    
    @GET
    @Path("findByName/{name}")
    @Produces({"application/json"})
    public List<Merchant> findByIdPassword(@PathParam("name") String name) {
        Query q = em.createQuery("select m from Merchant m WHERE m.name LIKE '%" + name + "%' ", Merchant.class);
        return q.getResultList();
    }
    
    
}
