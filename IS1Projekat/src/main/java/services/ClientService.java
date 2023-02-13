/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bodies.AddClientMoneyBody;
import bodies.ChangeAdressCityBody;
import bodies.CreateClientBody;
import bodies.GetUserIdBody;
import bodies.UserBody;
import responses.MultipleObjectResponse;
import responses.TextResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 *
 * @author Lenovo
 */
public interface ClientService {
    @POST("client")
    Call<TextResponse> createClient(@Body CreateClientBody ct);
    
    @PUT("client")
    Call<TextResponse> addMoney(@Body AddClientMoneyBody ct);
    
    @PUT("client/adr")
    Call<TextResponse> changeAdressCity(@Body ChangeAdressCityBody ct);
    
    @GET("client")
    Call<TextResponse> getAllClients();
    
    @POST("client/id")
    Call<TextResponse> getClientId(@Body GetUserIdBody ct);
    
    @PUT("client/bag")
    Call<MultipleObjectResponse> getBagArticles(@Body UserBody ct);
    
    @POST("client/buy")
    Call<TextResponse> buyArticles(@Body UserBody ct);
    
    @POST("client/info")
    Call<TextResponse> getClientInfo(@Body UserBody ct);
    
    @PUT("client/order")
    Call<TextResponse> getClientsOrder(@Body UserBody ct);
}
