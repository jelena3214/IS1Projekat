/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import javax.jms.JMSContext;
import javax.persistence.EntityManager;

/**
 *
 * @author Lenovo
 */
public class CreatePlaceCommand extends Command{
    private int postalCode;
    private String name;
    
    public CreatePlaceCommand(int postalCode, String name) {
        this.postalCode = postalCode;
        this.name = name;
    }
    
    public int getPostalCode() {
        return postalCode;
    }
    public String getName() {
        return name;
    }
    @Override
    public DestQueue getDestination() {
        return DestQueue.S1;
    }
    @Override
    public Type getType() {
        return Type.CREATE_PLACE;
    }
   
    
}
