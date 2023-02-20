/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bodies;

import java.io.Serializable;

/**
 *
 * @author Lenovo
 */
public class ChangePriceArticleBody implements Serializable{
    private int idArt, cena;

    public ChangePriceArticleBody(int idArt, int cena) {
        this.idArt = idArt;
        this.cena = cena;
    }

    public ChangePriceArticleBody() {
    }

    public int getIdArt() {
        return idArt;
    }

    public void setIdArt(int idArt) {
        this.idArt = idArt;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
    
    
    
}
