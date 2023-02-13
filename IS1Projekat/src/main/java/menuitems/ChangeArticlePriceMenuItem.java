/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuitems;

import bodies.ChangePriceArticleBody;
import java.util.Scanner;
import responses.TextResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import services.ArticleService;

/**
 *
 * @author Lenovo
 */
public class ChangeArticlePriceMenuItem extends MenuItem{

    @Override
    public void execute(Retrofit retrofit, Scanner scanner, int id) {
        System.out.println("Unesite id artikla: "); int ida = Integer.parseInt(scanner.nextLine());
        System.out.println("Unesite novu cenu: "); int cena = Integer.parseInt(scanner.nextLine());
        ArticleService service = retrofit.create(ArticleService.class);
        Call<TextResponse> callSync = service.changePrice(new ChangePriceArticleBody(ida, cena));
        getResponse(callSync);
    }
    
}
