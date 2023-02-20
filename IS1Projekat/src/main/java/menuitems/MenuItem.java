/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuitems;

import java.io.Serializable;
import java.util.Scanner;
import responses.TextResponse;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 *
 * @author Lenovo
 */
public abstract class MenuItem {
    abstract public void execute(Retrofit retrofit, Scanner scanner, int id);
    
    static protected String getResponse(Call<TextResponse> callSync1){
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
}
