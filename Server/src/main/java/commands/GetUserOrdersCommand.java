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
public class GetUserOrdersCommand extends Command{
    
    private int idK;

    public GetUserOrdersCommand(int idK) {
        this.idK = idK;
    }

    public int getIdK() {
        return idK;
    }

    public void setIdK(int idK) {
        this.idK = idK;
    }


    @Override
    public DestQueue getDestination() {
        return Command.DestQueue.S3;
    }

    @Override
    public Type getType() {
        return Command.Type.GET_USER_ORDERS;
    }
    
}
