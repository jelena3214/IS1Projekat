/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responses;

import java.io.Serializable;

/**
 *
 * @author Lenovo
 */
public class ArtikalModel implements Serializable{
    private String naziv, opis;
    private int idart, popust, idkat, kolicina;
    private double cena;

    public ArtikalModel(String naziv, String opis, int idart, double cena, int popust, int idkat, int kolicina) {
        this.naziv = naziv;
        this.opis = opis;
        this.idart = idart;
        this.cena = cena;
        this.popust = popust;
        this.idkat = idkat;
        this.kolicina = kolicina;
    }

    public ArtikalModel() {
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

    public int getIdart() {
        return idart;
    }

    public void setIdart(int idart) {
        this.idart = idart;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getPopust() {
        return popust;
    }

    public void setPopust(int popust) {
        this.popust = popust;
    }

    public int getIdkat() {
        return idkat;
    }

    public void setIdkat(int idkat) {
        this.idkat = idkat;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    @Override
    public String toString() {
        return "ArtikalModel{" + "naziv=" + naziv + ", opis=" + opis + ", idart=" + idart + ", cena=" + cena + ", popust=" + popust + ", idkat=" + idkat + ", kolicina=" + kolicina + '}';
    }
    
    
}
