/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

/**
 *
 * @author Lenovo
 */
public class AddToBagCommand extends Command{
    private int idK;
    private String art;
    private int kol;

    public AddToBagCommand(int idK, String art, int kol) {
        this.idK = idK;
        this.art = art;
        this.kol = kol;
    }

    public int getIdK() {
        return idK;
    }

    public void setIdK(int id) {
        this.idK = id;
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

    @Override
    public Command.DestQueue getDestination() {
        return Command.DestQueue.S2;
    }

    @Override
    public Command.Type getType() {
        return Command.Type.ADD_TO_BAG;
    }
    
}
