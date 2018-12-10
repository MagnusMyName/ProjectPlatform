/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import com.google.gson.Gson;
import helper.AntrianHelper;
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
import pojos.Antrian;

/**
 *
 * @author Imi
 */
@Path("antrean")
public class AntreanResources {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AntreanResource
     */
    public AntreanResources() {
    }

    /**
     * Retrieves representation of an instance of service.AntreanResources
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAntrean() {
        //TODO return proper representation object
//        throw new UnsupportedOperationException();
        AntrianHelper antre = new AntrianHelper();
        List<Antrian> list = antre.getAntrian();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
        return Response.status(200).entity(json)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods",
                        "GET,POST,HEAD,OPTIONS,PUT")
                .header("Access-Control-Allow-Headers",
                        "Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers")
                .header("Access-Exposed-Headers",
                        "Access-Control-Allow-Origin,Access-Control-Allow-Credentials")
                .header("Access-Support-Credentials",
                        "true")
                .header("Access-Control-Max-Age", "2")
                .header("Access-Preflight-Maxage", "2")
                .build();
    }

    /**
     * PUT method for updating or creating an instance of AntreanResources
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    @POST
    @Path("addAntrian")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewAntrean(String data) {
        Gson gson = new Gson();
        Antrian antre = gson.fromJson(data, Antrian.class);
        AntrianHelper help = new AntrianHelper();
        help.addNewAntrian(antre.getTanggal(), antre.getNoRm(), antre.getNama(), antre.getAlamat(), antre.getNamaKlinik());

        return Response.status(200).entity(antre).build();
    }
}
