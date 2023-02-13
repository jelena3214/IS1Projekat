/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuitems;

import bodies.BagBody;
import java.util.Scanner;
import responses.TextResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import services.ArticleService;

/**
 *
 * @author Lenovo
 */
public class AddToBagMenuItem extends MenuItem{
    @Override
    public void execute(Retrofit retrofit, Scanner scanner, int id) {
        System.out.println("Unesite ime artikla: "); String art = scanner.nextLine();
        System.out.println("Unesite kolicinu: "); int kol = Integer.parseInt(scanner.nextLine());
        if(kol > 0){
            ArticleService service = retrofit.create(ArticleService.class);
            Call<TextResponse> callSync = service.addToBag(new BagBody(id, art, kol));
            getResponse(callSync);
        }else{
            System.out.println("Kolicina je 0.");
        }
        
    }
    
}
