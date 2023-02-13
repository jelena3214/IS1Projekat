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
public class GetUserIdCommand extends Command{
    
    private String username;

    public GetUserIdCommand(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public DestQueue getDestination() {
        return Command.DestQueue.S1;
    }

    @Override
    public Type getType() {
        return Command.Type.GET_USER_ID;
    }
    
}
