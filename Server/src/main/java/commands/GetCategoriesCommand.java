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
public class GetCategoriesCommand extends Command{

    @Override
    public DestQueue getDestination() {
        return Command.DestQueue.S2;
    }

    @Override
    public Type getType() {
        return Command.Type.GET_CATEGORIES;
    }
    
}
