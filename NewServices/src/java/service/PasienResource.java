/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Helper.PasienHelper;
import Pojos.Pasien;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author basisa11
 */
@Path("pasien")
public class PasienResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PasienResource
     */
    public PasienResource() {
    }

    /**
     * Retrieves representation of an instance of service.PasienResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        PasienHelper test = new PasienHelper();
        List<Pasien> list = test.getAllPasien();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }

    /**
     * PUT method for updating or creating an instance of PasienResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @POST
    @Path("addPasien")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewPasien(String data){
   Gson gson = new Gson();
        Pasien pasien = gson.fromJson(data, Pasien.class);
        PasienHelper helper = new PasienHelper();
        helper.addNewPasien(
                pasien.getNoRm(), 
                pasien.getNama(), 
                pasien.getAlamat(), 
                pasien.getNik(), 
                pasien.getTanggalLahir(), 
                pasien.getKelamin());
        return Response
                .status(200)
                .entity(pasien)
                .build();
    }
}
