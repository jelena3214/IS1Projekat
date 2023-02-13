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
import services.CityService;

/**
 *
 * @author Lenovo
 */
public class GetAllCitiesMenuItem extends MenuItem{

    @Override
    public void execute(Retrofit retrofit, Scanner scanner, int id) {
        CityService service = retrofit.create(CityService.class);
        Call<TextResponse> callSync = service.getCities();
        getResponse(callSync);
    }
    
}
