/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import responses.TextResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 *
 * @author Lenovo
 */
public interface TransactionService {
    @GET("orders")
    Call<TextResponse> getAllOrders();
    
    @GET("orders/transaction")
    Call<TextResponse> getAllTransactions();
    
}
