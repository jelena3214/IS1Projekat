/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server.resources;

import bodies.AddClientMoneyBody;
import bodies.ChangeAdressCityBody;
import bodies.CreateClientBody;
import bodies.GetUserIdBody;
import bodies.UserBody;
import commands.AddClientMoneyCommand;
import commands.BuyArticlesCommand;
import commands.ChangeAdressCityCommand;
import commands.CreateClientCommand;
import commands.GetBagArticlesCommand;
import commands.GetClientsCommand;
import commands.GetUserIdCommand;
import commands.GetUserInfoCommand;
import commands.GetUserOrdersCommand;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jms.ServerJMS;
import responses.ArtikalModel;
import responses.MultipleObjectResponse;
import responses.TextResponse;

/**
 *
 * @author Lenovo
 */
@Path("client")
@Produces(MediaType.APPLICATION_JSON)
public class ClientResource {
    @Inject
    ServerJMS communicator;
    
    @POST
    public Response createClient(CreateClientBody ct){
        Object response = communicator.communicate(new CreateClientCommand(ct.getUsername(), ct.getIme(), ct.getPrezime(), ct.getSifra(), ct.getAdresa(), ct.getGrad(), ct.getNovac()));
        System.out.println(((TextResponse)response).toString());
        return Response
            .ok((TextResponse)response)
            .build();
    }
    
    @PUT
    public Response addMoney(AddClientMoneyBody ct){
        Object response = communicator.communicate(new AddClientMoneyCommand(ct.getNovac(), ct.getUsername()));
        System.out.println(((TextResponse)response).toString());
        return Response
            .ok((TextResponse)response)
            .build();
    }
    
    @PUT
    @Path("adr")
    public Response changeAdressCity(ChangeAdressCityBody ct){
        Object response = communicator.communicate(new ChangeAdressCityCommand(ct.getAdresa(), ct.getGrad(), ct.getUsername()));
        System.out.println(((TextResponse)response).toString());
        return Response
            .ok((TextResponse)response)
            .build();
    }
    
    @GET
    public Response getClients(){
        Object response = communicator.communicate(new GetClientsCommand());
        return Response
            .ok((TextResponse)response)
            .build();
    }
    
    @POST
    @Path("id")
    public Response getClientId(GetUserIdBody ct){
        Object response = communicator.communicate(new GetUserIdCommand(ct.getUsername()));
        return Response
            .ok((TextResponse)response)
            .build();
    }
    
    
    
    @PUT
    @Path("bag")
    public Response getBagArticles(UserBody ct){
        Object response = communicator.communicate(new GetBagArticlesCommand(ct.getIdK()));
        return Response
            .ok((MultipleObjectResponse)response)
            .build();
    }
    
    @POST
    @Path("buy")
    public Response buyArticles(UserBody ct){
        //dohvatanje artikala
        Object responseAr = communicator.communicate(new GetBagArticlesCommand(ct.getIdK()));
        List<ArtikalModel> listaAr = ((MultipleObjectResponse)responseAr).getObjects();
        if(listaAr.isEmpty()){
            return Response
            .ok(new TextResponse("Nema artikala u korpi korisnika"))
            .build();
        }
        //dohvatanje korisnik info
        Object responseInf = communicator.communicate(new GetUserInfoCommand(ct.getIdK()));
        String[] info = ((TextResponse)responseInf).getMess().split(",");
        String adr = "";
        int idGrad = -1;
        double novac = -1;
        if(info != null){
            adr = info[0];
            idGrad = Integer.parseInt(info[1]);
            novac = Double.parseDouble(info[2]);
        }
        Object response = communicator.communicate(new BuyArticlesCommand(listaAr, adr, idGrad, novac, ct.getIdK()));
        return Response
            .ok((TextResponse)response)
            .build();
    }
    
    @POST
    @Path("info")
    public Response getClientInfo(UserBody ct){
        Object response = communicator.communicate(new GetUserInfoCommand(ct.getIdK()));
        return Response
            .ok((TextResponse)response)
            .build();
    }
    
    @PUT
    @Path("order")
    public Response getClientsOrder(UserBody ct){
        Object response = communicator.communicate(new GetUserOrdersCommand(ct.getIdK()));
        System.out.println(((TextResponse)response).toString());
        return Response
            .ok((TextResponse)response)
            .build();
    }
    
}
