/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bodies.CreateCityBody;
import responses.TextResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 *
 * @author Lenovo
 */
public interface CityService {
    @POST("city")
    Call<TextResponse> createCity(@Body CreateCityBody ct);
    
    @GET("city")
    Call<TextResponse> getCities();
}
