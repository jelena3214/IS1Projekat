/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server.resources;

import bodies.CreateCategoryBody;
import commands.CreateCategoryCommand;
import commands.GetCategoriesCommand;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jms.ServerJMS;
import responses.TextResponse;

/**
 *
 * @author Lenovo
 */
@Path("category")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryResource {
    @Inject
    ServerJMS communicator;
    
    @POST
    public Response createCategory(CreateCategoryBody ct){
        Object response = communicator.communicate(new CreateCategoryCommand(ct.getNaziv(), ct.getPotkat()));
        
        return Response
            .ok((TextResponse)response)
            .build();
    }
    
    @GET
    public Response getCategories(){
        Object response = communicator.communicate(new GetCategoriesCommand());
        
        return Response
            .ok((TextResponse)response)
            .build();
    }
}
