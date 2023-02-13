/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server.resources;

import bodies.BagBody;
import bodies.ChangePriceArticleBody;
import bodies.CreateArticleBody;
import bodies.SetDiscountBody;
import bodies.UserBody;
import commands.AddToBagCommand;
import commands.ChangePriceCommand;
import commands.CreateArticleCommand;
import commands.GetSellingArticlesCommand;
import commands.RemoveFromBagCommand;
import commands.SetDiscountCommand;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
@Path("article")
@Produces(MediaType.APPLICATION_JSON)
public class ArticleResource {
    @Inject
    ServerJMS communicator;
    
    @POST
    public Response createArticle(CreateArticleBody ct){
        Object response = communicator.communicate(new CreateArticleCommand(ct.getNaziv(), ct.getOpis(), ct.getKategorija(), ct.getCena(), ct.getPopust()));
        
        return Response
            .ok((TextResponse)response)
            .build();
    }
    
    @PUT
    public Response changePriceArticle(ChangePriceArticleBody ct){
        Object response = communicator.communicate(new ChangePriceCommand(ct.getIdArt(), ct.getCena()));
        
        return Response
            .ok((TextResponse)response)
            .build();
    }
    
    @PUT
    @Path("discount")
    public Response setDiscount(SetDiscountBody ct){
        Object response = communicator.communicate(new SetDiscountCommand(ct.getPopust(), ct.getIdart()));
        
        return Response
            .ok((TextResponse)response)
            .build();
    }
    
    @POST
    @Path("addToBag")
    public Response addToBag(BagBody ct){
        Object response = communicator.communicate(new AddToBagCommand(ct.getId(), ct.getArt(), ct.getKol()));
        
        return Response
            .ok((TextResponse)response)
            .build();
    }
    
    @PUT
    @Path("removeFromBag")
    public Response removeFromBag(BagBody ct){
        Object response = communicator.communicate(new RemoveFromBagCommand(ct.getId(), ct.getArt(), ct.getKol()));
        
        return Response
            .ok((TextResponse)response)
            .build();
    }
    
    @PUT
    @Path("sell")
    public Response sellingArticles(UserBody ct){
        Object response = communicator.communicate(new GetSellingArticlesCommand(ct.getIdK()));
        
        return Response
            .ok((TextResponse)response)
            .build();
    }
}
