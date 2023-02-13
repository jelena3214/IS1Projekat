/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuitems;

import java.util.Scanner;
import responses.TextResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import services.CategoryService;

/**
 *
 * @author Lenovo
 */
public class GetCategoriesMenuItem extends MenuItem{

    @Override
    public void execute(Retrofit retrofit, Scanner scanner, int id) {
        CategoryService service = retrofit.create(CategoryService.class);
        Call<TextResponse> callSync = service.getCategories();
        getResponse(callSync);
    }
    
}
