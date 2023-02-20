/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bodies.CreateCategoryBody;
import bodies.CreateCityBody;
import responses.TextResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 *
//// * @author Lenovo
 */
public interface CategoryService {
    @POST("category")
    Call<TextResponse> createCategory(@Body CreateCategoryBody ct);
    
    @GET("category")
    Call<TextResponse> getCategories();
    
}
