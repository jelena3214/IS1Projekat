/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server.resources;

import bodies.CreateCityBody;
import commands.CreatePlaceCommand;
import commands.GetCitiesCommand;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jdk.nashorn.internal.objects.annotations.Getter;
import jms.ServerJMS;
import responses.TextResponse;
import retrofit2.http.Field;

/**
 *
 * @author Lenovo
 */ 
@Path("city")
@Produces(MediaType.APPLICATION_JSON)
public class CityResource {
    @Inject
    ServerJMS communicator;
    
    @POST
    public Response createCity(CreateCityBody ct){
        Object response = communicator.communicate(new CreatePlaceCommand(ct.getNum(), ct.getName()));
        System.out.println(((TextResponse)response).toString());
        return Response
            .ok((TextResponse)response)
            .build();
    }
   
    
    @GET
    public Response getCities(){
        Object response = communicator.communicate(new GetCitiesCommand());
        
        return Response
            .ok((TextResponse)response)
            .build();
    }
}
