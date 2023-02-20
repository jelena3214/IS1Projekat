/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuitems;

import bodies.CreateClientBody;
import java.util.Scanner;
import responses.TextResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import services.ClientService;

/**
 *
 * @author Lenovo
 */
public class CreateClientMenuItem extends MenuItem{

    @Override
    public void execute(Retrofit retrofit, Scanner scanner, int id) {
        ClientService service = retrofit.create(ClientService.class);
        System.out.println("Unesite username: "); String username = scanner.nextLine();
        System.out.println("Unesite ime: "); String ime = scanner.nextLine();
        System.out.println("Unesite prezime: "); String prezime = scanner.nextLine();
        System.out.println("Unesite sifru: "); String sifra = scanner.nextLine();
        System.out.println("Unesite adresu: "); String adresa = scanner.nextLine();
        System.out.println("Unesite ime grada: "); String grad = scanner.nextLine();
        System.out.println("Unesite novac: "); int novac = Integer.parseInt(scanner.nextLine());
        
        Call<TextResponse> callSync = service.createClient(new CreateClientBody(username, ime, prezime, sifra, adresa, grad, novac));
        getResponse(callSync);
    }
    
}
