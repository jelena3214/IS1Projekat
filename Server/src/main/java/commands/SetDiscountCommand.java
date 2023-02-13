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
public class SetDiscountCommand extends Command{
    private int popust, idart;

    public SetDiscountCommand(int popust, int idart) {
        this.popust = popust;
        this.idart = idart;
    }

    public int getPopust() {
        return popust;
    }

    public void setPopust(int popust) {
        this.popust = popust;
    }

    public int getIdart() {
        return idart;
    }

    public void setIdart(int idart) {
        this.idart = idart;
    }


    @Override
    public DestQueue getDestination() {
        return Command.DestQueue.S2;
    }

    @Override
    public Type getType() {
        return Command.Type.SET_DISCOUNT;
    }
    
}
