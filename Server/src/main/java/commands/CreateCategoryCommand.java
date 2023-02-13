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
public class CreateCategoryCommand extends Command{
    
    private String naziv;
    private int potkat;

    public CreateCategoryCommand(String naziv, int potkat) {
        this.naziv = naziv;
        this.potkat = potkat;
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


    @Override
    public DestQueue getDestination() {
        return Command.DestQueue.S2;
    }

    @Override
    public Type getType() {
        return Command.Type.CREATE_CATEGORY;
    }
    
}
