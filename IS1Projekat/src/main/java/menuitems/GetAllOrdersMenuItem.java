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
import services.TransactionService;

/**
 *
 * @author Lenovo
 */
public class GetAllOrdersMenuItem extends MenuItem{

    @Override
    public void execute(Retrofit retrofit, Scanner scanner, int id) {
        TransactionService service = retrofit.create(TransactionService.class);
        Call<TextResponse> callSync = service.getAllOrders();
        getResponse(callSync);
    }
    
}
