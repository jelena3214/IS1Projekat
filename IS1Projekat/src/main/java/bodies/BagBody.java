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
public class BagBody implements Serializable{
    private int id;
    private String art;
    private int kol;

    public BagBody(int id, String art, int kol) {
        this.id = id;
        this.art = art;
        this.kol = kol;
    }
    

    public BagBody() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public int getKol() {
        return kol;
    }

    public void setKol(int kol) {
        this.kol = kol;
    }
    
    
}
