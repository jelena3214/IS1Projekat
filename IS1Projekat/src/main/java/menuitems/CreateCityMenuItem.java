/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuitems;

import bodies.CreateCityBody;
import java.util.Scanner;
import responses.TextResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import services.CityService;

/**
 *
 * @author Lenovo
 */
public class CreateCityMenuItem extends MenuItem{

    @Override
    public void execute(Retrofit retrofit, Scanner scanner, int id) {
        CityService service = retrofit.create(CityService.class);
        
        System.out.println("Unesite ime grada: ");
        String ime = scanner.nextLine();
        System.out.println("Unesite postanski broj: ");
        int postanskiBroj = Integer.parseInt(scanner.nextLine());
        System.out.println("ime : " + ime + postanskiBroj);
        
        Call<TextResponse> callSync = service.createCity(new CreateCityBody(ime, postanskiBroj));
        getResponse(callSync);
    }
    
    
}
