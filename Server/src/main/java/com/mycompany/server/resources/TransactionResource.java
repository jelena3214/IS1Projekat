/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server.resources;

import commands.GetAllOrdersCommand;
import commands.GetAllTransactionsCommand;
import javax.inject.Inject;
import javax.ws.rs.GET;
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
@Path("orders")
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResource {
    @Inject
    ServerJMS communicator;
    
    @GET
    public Response getAllOrders(){
        Object response = communicator.communicate(new GetAllOrdersCommand());
        return Response
            .ok((TextResponse)response)
            .build();
    }
    
    @GET()
    @Path("transaction")
    public Response getAllTransactions(){
        Object response = communicator.communicate(new GetAllTransactionsCommand());
        return Response
            .ok((TextResponse)response)
            .build();
    }
}
