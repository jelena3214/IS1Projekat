/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuitems;

import bodies.UserBody;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import responses.ArtikalModel;
import responses.MultipleObjectResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import services.ClientService;

/**
 *
 * @author Lenovo
 */
public class GetArticlesFromBagMenuItem extends MenuItem{

    @Override
    public void execute(Retrofit retrofit, Scanner scanner, int id) {
        List<ArtikalModel> result;
        ClientService service = retrofit.create(ClientService.class);
        Call<MultipleObjectResponse> callSync = service.getBagArticles(new UserBody(id));
        try {
            Serializable response = callSync.execute().body();
            if(response == null)System.out.println("Odgovor klijentu je null");
            result = ((MultipleObjectResponse)response).getObjects();
            if(result.isEmpty())System.out.println("Nema proizvoda u korpi");
            else{
                result.forEach(art -> {
                    System.out.println(art.toString());
                });
            }
        } catch (Exception ex) { 
            ex.printStackTrace();
        }
    }
    
}
