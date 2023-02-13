/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuitems;

import bodies.CreateCategoryBody;
import java.util.Scanner;
import responses.TextResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import services.CategoryService;

/**
 *
 * @author Lenovo
 */
public class CreateCategoryMenuItem extends MenuItem{

    @Override
    public void execute(Retrofit retrofit, Scanner scanner, int id) {
        System.out.println("Unesite naziv kategorije: "); String naziv = scanner.nextLine();
        System.out.println("Unesite id potkategorije: "); int pot = Integer.parseInt(scanner.nextLine());
        CategoryService service = retrofit.create(CategoryService.class);
        Call<TextResponse> callSync = service.createCategory(new CreateCategoryBody(naziv, pot));
        getResponse(callSync);
    }
    
}
