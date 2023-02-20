/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bodies;

/**
 *
 * @author Lenovo
 */
public class CreateArticleBody {
    private String naziv, opis, kategorija;
    private int cena, popust;

    public CreateArticleBody(String naziv, String opis, String kategorija, int cena, int popust) {
        this.naziv = naziv;
        this.opis = opis;
        this.kategorija = kategorija;
        this.cena = cena;
        this.popust = popust;
    }

    public CreateArticleBody() {
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getPopust() {
        return popust;
    }

    public void setPopust(int popust) {
        this.popust = popust;
    }
    
    
    
}
