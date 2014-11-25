package com.simavirtual.ws;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("UnWebService")
public class UnWebService {

    @Context
    private UriInfo context;

    public UnWebService() {}
  
    @GET
    @Produces("text/html")
    public String getHtml() {        
        return "Hola esto es una Prueba.";
    }

    @POST
    @Produces("text/plain")
    @Consumes("text/plain")
    public String codigo(String cedula) {
    	if (cedula == null) {
    		return "000NULL000-5";
    	} else {
    		return cedula + "-5";
    	}    	
    }	

}