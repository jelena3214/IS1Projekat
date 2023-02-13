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
public class CreateClientBody implements Serializable{
    private String username, ime, prezime, sifra, adresa, grad;
    private int novac;

    public CreateClientBody(String username, String ime, String prezime, String sifra, String adresa, String grad,int novac) {
        this.username = username;
        this.ime = ime;
        this.prezime = prezime;
        this.sifra = sifra;
        this.adresa = adresa;
        this.novac = novac;
        this.grad = grad;
    }
    
    public CreateClientBody(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIme() {
        return ime;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getNovac() {
        return novac;
    }

    public void setNovac(int novac) {
        this.novac = novac;
    }
    
    
    
}
