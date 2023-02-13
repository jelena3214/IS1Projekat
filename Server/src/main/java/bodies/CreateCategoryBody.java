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
public class CreateCategoryBody implements Serializable{
    private String naziv;
    private int potkat;

    public CreateCategoryBody(String naziv, int potkat) {
        this.naziv = naziv;
        this.potkat = potkat;
    }

    public CreateCategoryBody() {
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getPotkat() {
        return potkat;
    }

    public void setPotkat(int potkat) {
        this.potkat = potkat;
    }
    
    
}
