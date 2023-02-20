/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuitems;

import bodies.ChangeAdressCityBody;
import java.util.Scanner;
import responses.TextResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import services.ClientService;

/**
 *
 * @author Lenovo
 */
public class ChangeAdressAndCityMenuItem extends MenuItem{

    @Override
    public void execute(Retrofit retrofit, Scanner scanner, int id) {
        System.out.println("Unesite username: "); String username = scanner.nextLine();
        System.out.println("Unesite grad: "); String grad = scanner.nextLine();
        System.out.println("Unesite adresu: "); String adresa = scanner.nextLine();
        ClientService service = retrofit.create(ClientService.class);
        Call<TextResponse> callSync = service.changeAdressCity(new ChangeAdressCityBody(adresa, grad, username));
        getResponse(callSync);
    }
    
}
