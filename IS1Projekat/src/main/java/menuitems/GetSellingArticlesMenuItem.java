/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuitems;

import bodies.UserBody;
import java.util.Scanner;
import responses.TextResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import services.ArticleService;

/**
 *
 * @author Lenovo
 */
public class GetSellingArticlesMenuItem extends MenuItem{

    @Override
    public void execute(Retrofit retrofit, Scanner scanner, int id) {
        ArticleService service = retrofit.create(ArticleService.class);
        Call<TextResponse> callSync = service.sellingArticles(new UserBody(id));
        getResponse(callSync);
    }
    
}
