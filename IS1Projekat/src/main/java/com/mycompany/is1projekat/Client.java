/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.is1projekat;

import bodies.GetUserIdBody;
import bodies.UserBody;
import com.google.gson.Gson;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import menuitems.AddClientMoneyMenuItem;
import menuitems.AddToBagMenuItem;
import menuitems.BuyArticlesMenuItem;
import menuitems.ChangeAdressAndCityMenuItem;
import menuitems.ChangeArticlePriceMenuItem;
import menuitems.CreateArticalMenuItem;
import menuitems.CreateCategoryMenuItem;
import menuitems.CreateCityMenuItem;
import menuitems.CreateClientMenuItem;
import menuitems.GetAllCitiesMenuItem;
import menuitems.GetAllClientsMenuItem;
import menuitems.GetAllOrdersMenuItem;
import menuitems.GetAllTransactionsMenuItem;
import menuitems.GetArticlesFromBagMenuItem;
import menuitems.GetCategoriesMenuItem;
import menuitems.GetClientsOrdersMenuItem;
import menuitems.GetSellingArticlesMenuItem;
import menuitems.MenuItem;
import menuitems.RemoveArticlesFromBagMenuItem;
import menuitems.SetArticleDiscountMenuItem;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import responses.ArtikalModel;
import responses.MultipleObjectResponse;
import responses.TextResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import services.ClientService;

/**
 *
 * @author Lenovo
 */


public class Client {
    
    static private void printMenu(){
        String menu = "\n\n1. Kreiranje grada\n" +
                "2. Kreiranje korisnika\n" +
                "3. Dodavanje novca korisniku\n" +
                "4. Promena adrese i grada za korisnika\n" +
                "5. Dohvatanje svih gradova\n" +
                "6. Dohvatanje svih korisnika\n" +
                "7. Kreiranje kategorije\n" +
                "8. Kreiranje artikla\n" +
                "9. Menjanje cene artikla\n" +
                "10. Postavljanje popusta za artikal\n" +
                "11. Dodavanje artikala u određenoj kolicini u korpu\n" +
                "12. Brisanje artikla u određenoj kolicini iz korpe\n" +
                "13. Dohvatanje svih kategorija\n" +
                "14. Dohvatanje svih artikala koje prodaje korisnik koji je poslao zahtev\n" +
                "15. Dohvatanje sadrzaja korpe korisnika koji je poslao zahtev\n" +
                "16. Placanje, koje obuhvata kreiranje transakcije, kreiranje narudzbine sa njenim stavkama, i\n" +
                "brisanje sadrzaja iz korpe\n" +
                "17. Dohvatanje svih narudzbina korisnika koji je poslao zahtev\n" +
                "18. Dohvatanje svih narudzbina\n" +
                "19. Dohvatanje svih transakcija\n" +
                "20. Kraj programa\n\n"; 
        
        System.out.println("Izaberite opciju: \n" + menu);
        
    }
    
    static private String getResponse(Call<TextResponse> callSync1){
        String res = "";
        try {
            Serializable response = callSync1.execute().body();
            if(response == null)System.out.println("Odgovor klijentu je null");
            res = ((TextResponse)response).getMess();
            System.out.println(res);
        } catch (Exception ex) { 
            ex.printStackTrace();
        } 
        return res;
    }
    private static Map<Integer, MenuItem> menuItems = new HashMap<Integer, MenuItem>(){{
        put(1, new CreateCityMenuItem());
        put(2, new CreateClientMenuItem());
        put(3, new AddClientMoneyMenuItem());
        put(4, new ChangeAdressAndCityMenuItem());
        put(5, new GetAllCitiesMenuItem());
        put(6, new GetAllClientsMenuItem());
        put(7, new CreateCategoryMenuItem());
        put(8, new CreateArticalMenuItem());
        put(9, new ChangeArticlePriceMenuItem());
        put(10, new SetArticleDiscountMenuItem());
        put(11, new AddToBagMenuItem());
        put(12, new RemoveArticlesFromBagMenuItem());
        put(13, new GetCategoriesMenuItem());
        put(14, new GetSellingArticlesMenuItem());
        put(15, new GetArticlesFromBagMenuItem());
        put(16, new BuyArticlesMenuItem());
        put(17, new GetClientsOrdersMenuItem());
        put(18, new GetAllOrdersMenuItem());
        put(19, new GetAllTransactionsMenuItem());
    }};
    
    
    
    public static void main(String[] args) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(Level.BASIC);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder().addInterceptor(logging).readTimeout(20,TimeUnit.SECONDS);
     
        
        Retrofit retrofit = new Retrofit.Builder()
          .baseUrl("http://localhost:8080/Server/resources/")
          .addConverterFactory(GsonConverterFactory.create())
          .client(httpClient.build())
          .build();
        Gson gson = new Gson();
        
        Scanner scanner = new Scanner(System.in);
        int choice = 20;
        
        String client = "peraperic1";
        System.out.println("Unesite username: "); 
        client = scanner.nextLine();
        
        
        //dohvatanje kor id
        int id = -1;
        ClientService serviceId = retrofit.create(ClientService.class);
        Call<TextResponse> callSync1 = serviceId.getClientId(new GetUserIdBody(client));
        String res = getResponse(callSync1);
        if(!res.isEmpty())
            id = Integer.parseInt(res);
        if(id == -1)System.out.println("Ne postoji taj username");

        while(true){
            printMenu();
            choice = Integer.parseInt(scanner.nextLine());
            if(choice == 20)break;
            MenuItem mi = menuItems.get(choice);
            mi.execute(retrofit, scanner, id);
        }

    }
}
