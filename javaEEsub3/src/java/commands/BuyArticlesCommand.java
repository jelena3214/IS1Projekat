/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.io.Serializable;
import java.util.List;
import responses.ArtikalModel;

/**
 *
 * @author Lenovo
 */
public class BuyArticlesCommand extends Command{
    
    private String adresa;
    private int idGrad, idK;
    private List<ArtikalModel> artikli;
    private double novac;

    public BuyArticlesCommand(List<ArtikalModel> artikli, String adresa, int idGrad, double novac, int idK) {
        this.artikli = artikli;
        this.adresa = adresa;
        this.idGrad = idGrad;
        this.novac = novac;
        this.idK = idK;
    }
    
    

    public List<ArtikalModel> getArtikli() {
        return artikli;
    }

    public void setArtikli(List<ArtikalModel> artikli) {
        this.artikli = artikli;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getIdGrad() {
        return idGrad;
    }

    public void setIdGrad(int idGrad) {
        this.idGrad = idGrad;
    }

    public double getNovac() {
        return novac;
    }

    public void setNovac(double novac) {
        this.novac = novac;
    }

    public int getIdK() {
        return idK;
    }

    public void setIdK(int idK) {
        this.idK = idK;
    }

    @Override
    public Command.DestQueue getDestination() {
        return Command.DestQueue.S3;
    }

    @Override
    public Command.Type getType() {
        return Command.Type.BUY_ARTICLES;
    }
    
}
