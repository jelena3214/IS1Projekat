/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bodies.BagBody;
import bodies.ChangePriceArticleBody;
import bodies.CreateArticleBody;
import bodies.SetDiscountBody;
import bodies.UserBody;
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
public interface ArticleService {
    @POST("article")
    Call<TextResponse> createArticle(@Body CreateArticleBody ct);
    
    @PUT("article")
    Call<TextResponse> changePrice(@Body ChangePriceArticleBody ct);
    
    @PUT("article/discount")
    Call<TextResponse> setDiscount(@Body SetDiscountBody ct);
    
    @POST("article/addToBag")
    Call<TextResponse> addToBag(@Body BagBody ct);
    
    @PUT("article/removeFromBag")
    Call<TextResponse> removeFromBag(@Body BagBody ct);
    
    @PUT("article/sell")
    Call<TextResponse> sellingArticles(@Body UserBody ct);
}
